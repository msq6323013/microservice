package org.archer.lab.microservice.service;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;

@EnableEurekaClient
@RestController
@EnableHystrix
@EnableHystrixDashboard
@SpringBootApplication
public class ServiceHiApplication {
    private Logger LOG = Logger.getLogger(ServiceHiApplication.class.getName());
    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
    @HystrixCommand(fallbackMethod = "hiError")
    public String greetings(@RequestParam String name) {
        LOG.log(Level.INFO, "call trace service-hi");
        return "hi " + name + ", i am from port: " + port;
    }

    @RequestMapping("/whois")
    public String info() {
        LOG.log(Level.INFO, "call trace service-hi");
        return "I'm service-hi!";
    }

    public String hiError(String name) {
        return "hi, " + name + ",sorry, error!";
    }
    public static void main(String[] args) {
        SpringApplication.run(ServiceHiApplication.class, args);
    }
}
