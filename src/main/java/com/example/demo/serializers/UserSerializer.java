package com.example.demo.serializers;

import com.example.demo.entities.Account;
import com.example.demo.entities.User;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class UserSerializer extends JsonSerializer<User> {

    @Override
    public void serialize(User user, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (user != null) {
            jsonGenerator.writeNumber(user.getId());
        } else {
            jsonGenerator.writeNull();
        }
    }
}
