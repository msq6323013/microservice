package org.archer.lab.microservice.servicemiya;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@EnableEurekaClient
@SpringBootApplication
public class ServiceMiyaApplication {
    @Value("${server.port}")
    private String port;
    private static final Logger logger = Logger.getLogger(ServiceMiyaApplication.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(ServiceMiyaApplication.class, args);
    }

    @RequestMapping("/hi")
    public String home() {
        logger.log(Level.INFO, "hi is being called!");
        return "Hi, I'm Miya!";
    }

    @RequestMapping("/miya")
    public String info() {
        logger.log(Level.INFO, "miya is being called!");
        return restTemplate.getForObject("http://localhost:8763/whois", String.class);
    }

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
