/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.archer.lab.microservice.servicefeign.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.archer.lab.microservice.servicefeign.service.ScheduledServiceHi;

@RestController
public class HiController {

    @Autowired
    ScheduledServiceHi scheduledServiceHi;

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String sayHi(@RequestParam String name) {
        return scheduledServiceHi.sayHiFromClientOne(name);
    }
}
