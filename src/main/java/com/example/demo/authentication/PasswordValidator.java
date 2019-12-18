package com.example.demo.authentication;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {


    public static Boolean validatePassword (String password){
        String regex = "^(?=\\P{Ll}*\\p{Ll})(?=\\P{Lu}*\\p{Lu})(?=\\P{N}*\\p{N})(?=[\\p{L}\\p{N}]*[^\\p{L}\\p{N}])[\\s\\S]$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        if(matcher.matches()) {
            return true;
        }
        else return false;
    }

        //The following regex ensures at least one lowercase, uppercase, number, and symbol exist in a 8+ character length password:
}
