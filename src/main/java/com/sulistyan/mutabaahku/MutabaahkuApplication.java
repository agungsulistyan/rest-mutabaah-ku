package com.sulistyan.mutabaahku;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MutabaahkuApplication {
    public static void main(String[] args){
        SpringApplication.run(MutabaahkuApplication.class, args);
    }
}
