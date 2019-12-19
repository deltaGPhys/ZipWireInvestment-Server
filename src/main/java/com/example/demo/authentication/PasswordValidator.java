package com.example.demo.authentication;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {


    public static Boolean validatePassword (String password){
        String regex = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!_.@$%^&*-]).{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        if(matcher.matches()) {
            return true;
        }
        else return false;
    }

        //The following regex ensures at least one lowercase, uppercase, number, and symbol exist in a 8+ character length password:
        //In the special character section we can add more characters if we want.
}
