package com.mycompany.pem.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author amanm
 */
@Configuration
@ComponentScan(basePackages = {"com.mycompany.pem.dao","com.mycompany.pem.service"})
public class SpringRootConfig {    
    //TODO: Services, DAO, DataSource, Email Sender or some other business layer beans   
    @Bean
    public BasicDataSource getDataSource(){
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/pem?useSSL=false");
        ds.setUsername("root");
        ds.setPassword("root");
        ds.setMaxTotal(9);
        ds.setInitialSize(1);
        ds.setTestOnBorrow(true);
        ds.setValidationQuery("SELECT 1");
        ds.setDefaultAutoCommit(true);
        return ds;
    }
}
