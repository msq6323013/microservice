/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.archer.lab.microservice.servicefeign.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.archer.lab.microservice.servicefeign.ScheduledServiceHiHystric;

@FeignClient(value = "service-hi", fallback = ScheduledServiceHiHystric.class)
public interface ScheduledServiceHi {
    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam("name") String name);


}
