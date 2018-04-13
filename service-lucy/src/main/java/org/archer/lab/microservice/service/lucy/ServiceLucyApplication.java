/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package org.archer.lab.microservice.service.lucy;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient
@RestController
@EnableHystrix
@EnableHystrixDashboard
@SpringBootApplication
public class ServiceLucyApplication {
}
