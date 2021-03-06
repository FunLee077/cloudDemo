package com.example.demo;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by hy on 2018/5/18.
 */
@FeignClient(value="service-hello",fallback = FallBackError.class)
@Service
public interface SchedualService {

    @RequestMapping(value="/hello")
    String hello(@RequestParam(value="name") String name);
}
