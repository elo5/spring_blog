package com.lilwork.mmall.config;

import com.lilwork.mmall.filter.UserFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new UserFilter());
        registrationBean.addUrlPatterns("/cart/*");
//        registrationBean.addUrlPatterns("/cart/*", "/orders/*", "user/userInfo");
        return registrationBean;
    }
}
