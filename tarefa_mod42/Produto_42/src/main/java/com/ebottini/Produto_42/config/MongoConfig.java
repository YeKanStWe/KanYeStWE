package com.ebottini.Produto_42.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.ebottini.Produto_42.online.repository")
public class MongoConfig {

}
