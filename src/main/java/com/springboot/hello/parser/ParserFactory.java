package com.springboot.hello.parser;

import com.springboot.hello.domain.Hospital;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ParserFactory {

    @Bean
    public ReadLineContext<Hospital> hospitalReadLineContext() {
        return new ReadLineContext<Hospital>(new HospitalParser());
    }

    public ReadLineContext<Hospital> hospitalReadLineContext2() {
        return new ReadLineContext<Hospital>(new HospitalParser());
    }

}
