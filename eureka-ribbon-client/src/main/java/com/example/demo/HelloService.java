package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by hy on 2018/5/18.
 */
@Service
public class HelloService {

    @Autowired
    private RestTemplate restTemplate;
    public String hello(String name){
       return restTemplate.getForObject("http://service-hello/hello?name="+name,String.class);
    }
}
