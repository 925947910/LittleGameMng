package com.cointer.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 持久层相关配置
 */
@Configuration
@AutoConfigureAfter(DBProperties.class)
public class SessionFactoryConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(SessionFactoryConfig.class);

    private final DBProperties db;

    @Autowired
    public SessionFactoryConfig(DBProperties db) {
        this.db = db;
    }

    /**
     * 创建数据源
     */
    @Bean
    @Primary
    public DataSource dataSource() {
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(db.getUrl());
        datasource.setUsername(db.getUsername());
        datasource.setPassword(db.getPassword());
        datasource.setDriverClassName(db.getDriverClassName());
        datasource.setInitialSize(db.getInitialSize());
        datasource.setMinIdle(db.getMinIdle());
        datasource.setMaxActive(db.getMaxActive());
        datasource.setMaxWait(db.getMaxWait());
        datasource.setTimeBetweenEvictionRunsMillis(db.getTimeBetweenEvictionRunsMillis());
        datasource.setMinEvictableIdleTimeMillis(db.getMinEvictableIdleTimeMillis());
        datasource.setValidationQuery(db.getValidationQuery());
        datasource.setTestOnReturn(db.isTestOnReturn());
        datasource.setPoolPreparedStatements(db.isPoolPreparedStatements());
        datasource.setMaxPoolPreparedStatementPerConnectionSize(db.getMaxPoolPreparedStatementPerConnectionSize());
        datasource.setUseGlobalDataSourceStat(db.isUseGlobalDataSourceStat());
        try {
            datasource.setFilters(db.getFilters());
        } catch (SQLException e) {
            LOGGER.info("druid configuration initialization filter: " + e);
        }
        datasource.setConnectionProperties(db.getConnectionProperties());
        return datasource;
    }

    /**
     * 配置分页插件
     */
    @Bean(name = "pageInterceptor")
    public PageInterceptor pageHelperConfig() {
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("reasonable", "true");
        properties.setProperty("supportMethodsArguments", "true");
        properties.setProperty("returnPageInfo", "check");
        properties.setProperty("params", "count=countSql");
        pageInterceptor.setProperties(properties);
        return pageInterceptor;
    }

    /**
     * 配置mybatis
     */
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(
            @Qualifier("dataSource") final DataSource dataSource,
            @Qualifier("pageInterceptor") final PageInterceptor pageInterceptor) throws Exception {
        final SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);
        final PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        resolver.getResources("classpath*:mapper/**/*.xml");
        sqlSessionFactory.setMapperLocations(resolver.getResources("classpath*:mapper/**/*.xml"));
        // 具体参考自己设置，参考 xml 参数说明或源码注释
        sqlSessionFactory.setPlugins(new Interceptor[]{pageInterceptor});
        return sqlSessionFactory.getObject();
    }
}
