package com.ebottini.Produto_42;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@RefreshScope
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class Produto42Application {

	public static void main(String[] args) {
		SpringApplication.run(Produto42Application.class, args);
	}

}
