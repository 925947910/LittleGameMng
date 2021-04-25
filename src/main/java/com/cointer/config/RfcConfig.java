package com.cointer.config;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
 
 
@Configuration
public class RfcConfig{

    @Bean
    public TomcatServletWebServerFactory webServerFactory() {
//        System.out.println("tomcat工厂配置成功啦。。。");
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        factory.addConnectorCustomizers(connector -> connector.setProperty("relaxedQueryChars", "[]{}"));
        return factory;
    }
}