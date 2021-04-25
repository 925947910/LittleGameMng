package com.cointer.config;

import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import com.cointer.interceptor.LoginInterceptor;

@Configuration
public class webConfiguration extends WebMvcConfigurationSupport {
	 @Autowired
	 private LoginInterceptor LoginInterceptor;
	@Override
    protected void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        // 解决controller返回字符串中文乱码问题
        for (HttpMessageConverter<?> converter : converters) {
            if (converter instanceof StringHttpMessageConverter) {
                ((StringHttpMessageConverter)converter).setDefaultCharset(StandardCharsets.UTF_8);
            }
        }
    }
	/**
	 * 在springboot2.0.0之后继承WebMvcConfigurationSupport类，重写addInterceptors方法
	 *
	 * @param registry
	 */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
	 @Override
	 protected void addInterceptors(InterceptorRegistry registry) {
		 /**
		  * 拦截器按照顺序执行,如果不同拦截器拦截存在相同的URL，前面的拦截器会执行，后面的拦截器将不执行
		  */
		 InterceptorRegistration InterceptorRegistration =registry.addInterceptor(LoginInterceptor);
		 InterceptorRegistration.addPathPatterns("/user/**","/redGreenBall/**","/benzBmw/**","/coin/**","/task/**","/Common/**");
		 super.addInterceptors(registry);
	 }
	 
	 
}
