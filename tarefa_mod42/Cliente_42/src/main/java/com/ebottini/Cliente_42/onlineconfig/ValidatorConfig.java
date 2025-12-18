package com.ebottini.Cliente_42.onlineconfig;

import jakarta.validation.Validator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class ValidatorConfig {

    @Bean
    public Validator validatorFactory () {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        return bean;
    }
}
