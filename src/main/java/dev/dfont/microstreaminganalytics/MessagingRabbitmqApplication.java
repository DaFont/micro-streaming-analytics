package dev.dfont.microstreaminganalytics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MessagingRabbitmqApplication{

    public static void main(String[] args) {
        SpringApplication.run(MessagingRabbitmqApplication.class, args);
    }

}