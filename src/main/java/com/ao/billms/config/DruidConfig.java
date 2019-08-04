package com.ao.billms.config;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){

        return new DruidDataSource();
    }


    /**
     * 配置druid的后台监控
     * 配置druid的后台，管理servlet
     * 配置druid的servlet
     */
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");

        Map<String,String> initParm = new HashMap<>();
        initParm.put(StatViewServlet.PARAM_NAME_JMX_USERNAME,"root");
        initParm.put(StatViewServlet.PARAM_NAME_JMX_PASSWORD,"123");
        //不写，都可以访问后台
        initParm.put(StatViewServlet.PARAM_NAME_ALLOW,"");



        return bean;
    }
    @Bean
   public FilterRegistrationBean webStatFilter(){
       FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();
       bean.setFilter(new WebStatFilter());

       Map<String,String> initParm = new HashMap<>();
       initParm.put(WebStatFilter.PARAM_NAME_EXCLUSIONS,"*.js,*.css,/druid/*");
        //拦截请求（所有）
       bean.setUrlPatterns(Arrays.asList("/*"));

       return bean;



   }

}
