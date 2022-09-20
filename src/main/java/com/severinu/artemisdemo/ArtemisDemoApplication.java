package com.severinu.artemisdemo;

import com.severinu.artemisdemo.config.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
        FileStorageProperties.class
})
public class ArtemisDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArtemisDemoApplication.class, args);
    }

}
