package com.springboot.hello.parser;

import com.springboot.hello.domain.Hospital;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;

@Configuration
public class ParserFactory {

    @Bean
    public ReadLineContext<Hospital> hospitalReadLineContext() {
        return new ReadLineContext<Hospital>(new HospitalParser());
    }

    public ReadLineContext<Hospital> hospitalReadLineContext2() {
        return new ReadLineContext<Hospital>(new HospitalParser());
    }

    @Bean
    public JdbcTemplate awsJdbcTemplate() {
        return new JdbcTemplate(awsDataSource());
    }

    public DataSource awsDataSource() {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setUsername("root");
        //...
        //...
        return dataSource;
    }

}
