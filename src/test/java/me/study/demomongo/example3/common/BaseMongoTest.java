package me.study.demomongo.example3.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootTest
public class BaseMongoTest {

    @Autowired
    protected MongoTemplate mongoTemplate;
}
