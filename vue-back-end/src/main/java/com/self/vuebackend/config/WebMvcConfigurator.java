package com.self.vuebackend.config;

import com.self.vuebackend.interceptor.TestInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * 拦截配置
 */
@Configuration
public class WebMvcConfigurator extends WebMvcConfigurationSupport {

    /**
     * 拦截器添加
     * @param registry registry
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        //按照拦截器的声明顺序执行(表达式指向请求方法的url，* 和 ** 代表全部)
        registry.addInterceptor(new TestInterceptor()).addPathPatterns("/**");

        super.addInterceptors(registry);
    }

    /**
     * 跨域拦截配置
     * @param registry registry
     */
    @Override
    protected void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("*")
                .allowedHeaders("*")
                .maxAge(3600);

        super.addCorsMappings(registry);
    }

}
