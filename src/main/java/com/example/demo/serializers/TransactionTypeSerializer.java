package com.example.demo.serializers;

import com.example.demo.enums.TransactionType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class TransactionTypeSerializer extends JsonSerializer<TransactionType> {

    @Override
    public void serialize(TransactionType type, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(type.getDescription());
    }
}
