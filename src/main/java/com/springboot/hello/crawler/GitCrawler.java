package com.springboot.hello.crawler;

import org.springframework.web.reactive.function.client.WebClient;

public class GitCrawler {
    public static void main(String[] args) {

        WebClient client = WebClient.create("http://:8080");

    }
}
