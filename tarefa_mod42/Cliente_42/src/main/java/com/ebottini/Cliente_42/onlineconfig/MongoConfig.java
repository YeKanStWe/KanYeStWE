package com.ebottini.Cliente_42.onlineconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.ebottini.Cliente_42.online.repository")
public class MongoConfig {

}
