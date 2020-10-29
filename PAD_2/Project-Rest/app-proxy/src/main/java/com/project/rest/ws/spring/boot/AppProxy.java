
package com.project.rest.ws.spring.boot;

import com.project.rest.ws.spring.boot.client.Client;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
//@EnableCaching
public class AppProxy {

    public static void main(String[] args) {
        SpringApplication.run(AppProxy.class, args);
    }

    @Bean
    public Client client() {
        return new Client();
    }
}
