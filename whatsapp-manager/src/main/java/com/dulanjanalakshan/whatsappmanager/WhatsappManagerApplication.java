package com.dulanjanalakshan.whatsappmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
/**
 * @author Imalka Gayani
 */
@SpringBootApplication
@EnableDiscoveryClient
public class WhatsappManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WhatsappManagerApplication.class, args);
    }

}
