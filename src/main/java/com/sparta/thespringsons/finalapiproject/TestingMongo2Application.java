package com.sparta.thespringsons.finalapiproject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableMongoRepositories
public class TestingMongo2Application {

    public static void main(String[] args) {
        SpringApplication.run(TestingMongo2Application.class, args);
    }

    @Bean
    public CommandLineRunner runner(UsersRepository usersRepository) {
        return args -> {
            User thisGuy = usersRepository.findByName("Jon Snow");
            System.out.println(thisGuy.email);
        };
    }

}