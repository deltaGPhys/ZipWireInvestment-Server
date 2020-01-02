package com.example.demo.serializers;

import com.example.demo.entities.Account;
import com.example.demo.repositories.AccountRepository;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public class AccountDeserializer extends JsonDeserializer<Account> {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public Account deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);

        Long id = node.longValue();

        return accountRepository.findById(id).orElse(null);
    }
}
