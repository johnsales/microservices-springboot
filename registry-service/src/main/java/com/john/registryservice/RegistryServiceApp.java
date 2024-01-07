package com.john.registryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class RegistryServiceApp {

    public static void main(String[] args) {
        SpringApplication.run(RegistryServiceApp.class, args);
    }

}
