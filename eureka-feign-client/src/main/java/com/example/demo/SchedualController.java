package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hy on 2018/5/18.
 */
@RestController
public class SchedualController {

    @Autowired
    SchedualService schedualService;
    @RequestMapping(value="/hello")
    public String hello(@RequestParam String name){
        return schedualService.hello(name);
    }
}
