package com.store.storeend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableCaching
public class StoreEndApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoreEndApplication.class, args);
    }

}
