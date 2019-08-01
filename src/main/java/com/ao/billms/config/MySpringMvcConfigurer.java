package com.ao.billms.config;

import com.ao.billms.component.MyLocaleResolver;
import com.ao.billms.interceptor.LoginHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MySpringMvcConfigurer {

    //add view controller
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        //inner class
        return new WebMvcConfigurer(){


            @Override
            public void addViewControllers(ViewControllerRegistry registry){
                //login.html as index page
                registry.addViewController("/").setViewName("main/login");
                //when user request index jump to login.html
                registry.addViewController("index.html").setViewName("main/login");
                registry.addViewController("main.html").setViewName("main/index");
            }

            public void addInterceptors(InterceptorRegistry registry){
                registry.addInterceptor(new LoginHandlerInterceptor())  //interceptor
                        .addPathPatterns("/**")                         //intercept every request
                        .excludePathPatterns("/","/index.html","/login")//exclude path
                        .excludePathPatterns("/css/*","/img/*","/js/*");//exclude static resources                         //exclude path
            }
        };

    }
    //add customized locale resolver
    @Bean
    public LocaleResolver localeResolver(){

        return new MyLocaleResolver();

    }

}
