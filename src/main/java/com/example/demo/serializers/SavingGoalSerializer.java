package com.example.demo.serializers;

import com.example.demo.entities.SavingGoal;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class SavingGoalSerializer extends StdSerializer<SavingGoal> {
    public SavingGoalSerializer(){
        this(null);
    }

    public SavingGoalSerializer(Class<SavingGoal> vc){
        super(vc);
    }

    @Override
    public void serialize(SavingGoal savingGoal, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        SavingGoal savingGoal1 = new SavingGoal();
        jsonGenerator.writeObject(savingGoal1);
    }
}
