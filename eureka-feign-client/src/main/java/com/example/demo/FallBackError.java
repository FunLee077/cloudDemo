package com.example.demo;

import org.springframework.stereotype.Component;

/**
 * Created by hy on 2018/5/21.
 */
@Component
public class FallBackError implements SchedualService {

    @Override
    public String hello(String name){

        return "hi "+name+" Error! --from Feign & Hystrix";
    }
}
