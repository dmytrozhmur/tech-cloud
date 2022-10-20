package com.griddynamics.techcloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class TechCloudApplication {
    @Autowired
    private DatabaseFiller filler;

    public static void main(String[] args) {
        SpringApplication.run(TechCloudApplication.class, args);
    }

    @PostConstruct
    private void initDB() {
        filler.fill();
    }
}
