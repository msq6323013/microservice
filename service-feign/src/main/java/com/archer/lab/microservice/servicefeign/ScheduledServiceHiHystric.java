/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.archer.lab.microservice.servicefeign;

import org.springframework.stereotype.Component;

import com.archer.lab.microservice.servicefeign.service.ScheduledServiceHi;

@Component
public class ScheduledServiceHiHystric implements ScheduledServiceHi {

    public String sayHiFromClientOne(String name) {
        return "sorry" + name;
    }
}
