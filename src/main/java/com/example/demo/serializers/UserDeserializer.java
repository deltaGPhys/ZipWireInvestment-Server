package com.example.demo.serializers;

import com.example.demo.entities.Account;
import com.example.demo.entities.User;
import com.example.demo.repositories.AccountRepository;
import com.example.demo.repositories.UserRepository;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public class UserDeserializer extends JsonDeserializer<User> {

    @Autowired
    UserRepository userRepository;

    Logger logger = LoggerFactory.getLogger(UserDeserializer.class);

    @Override
    public User deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {

        JsonNode node = jsonParser.getCodec().readTree(jsonParser);

        Long id = node.asLong();

        return userRepository.findById(id).orElse(null);
    }
}
