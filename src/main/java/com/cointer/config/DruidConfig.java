package com.cointer.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.servlet.Servlet;

/**
 * Druid连接池配置
 */
@Configuration
public class DruidConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(DruidConfig.class);

    /**
     * 访问路径及用户名、密码
     */
    @Bean
    public ServletRegistrationBean<Servlet> DruidConfig() {
        LOGGER.info("init Druid Servlet Configuration ");
        final ServletRegistrationBean<Servlet> srb = new ServletRegistrationBean<Servlet>();
        srb.setServlet(new StatViewServlet());
        srb.addUrlMappings("/druid/*");
        srb.addInitParameter("loginUsername", "admin");
        srb.addInitParameter("loginPassword", "admin");
        return srb;
    }

    /**
     * 配置过滤器
     */
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        final FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<Filter>();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }
}