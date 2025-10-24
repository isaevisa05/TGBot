package io.github.isaevisa05.TGBot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class TGBotApp {

    public static void main(String[] args) {
        SpringApplication.run(TGBotApp.class, args);
    }

}
