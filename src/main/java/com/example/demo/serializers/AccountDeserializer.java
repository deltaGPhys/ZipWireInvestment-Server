package com.example.demo.serializers;

import com.example.demo.entities.Account;
import com.example.demo.repositories.AccountRepository;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public class AccountDeserializer extends JsonDeserializer<Account> {

    @Autowired
    AccountRepository accountRepository;

    Logger logger = LoggerFactory.getLogger(AccountDeserializer.class);

    @Override
    public Account deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {

        JsonNode node = jsonParser.getCodec().readTree(jsonParser);

        Long id = node.asLong();
        logger.info(String.valueOf(id));
        logger.info(String.valueOf(node));
        logger.info(String.valueOf(accountRepository.findById(id).orElse(null)));

        return accountRepository.findById(id).orElse(null);
    }
}
