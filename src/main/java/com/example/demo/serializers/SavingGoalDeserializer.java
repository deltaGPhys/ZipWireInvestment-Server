package com.example.demo.serializers;

import com.example.demo.entities.SavingGoal;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class SavingGoalDeserializer extends StdDeserializer<SavingGoal> {

    public SavingGoalDeserializer(){
        this(null);
    }

    public SavingGoalDeserializer(Class<?> vc){
        super(vc);
    }



    @Override
    public SavingGoal deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        return new SavingGoal();
    }
}
