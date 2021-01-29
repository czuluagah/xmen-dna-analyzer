package com.xmen.dnasentinel.config;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;


@Configuration
public class EmbeddedMongoDB {

    private static final String MONGO_DB_URL = "localhost";
    private static final int MONGO_DB_PORT = 12345;


}
