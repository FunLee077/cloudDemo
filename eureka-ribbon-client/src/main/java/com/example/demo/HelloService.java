package com.example.demo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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

@HystrixCommand(fallbackMethod="fallbackError")
    public String hello(String name){
       return restTemplate.getForObject("http://service-hello/hello?name="+name,String.class);
    }

    public String fallbackError(String name){
        return "hi"+name+",error!--from robbin & Hystrrix";
    }
}
