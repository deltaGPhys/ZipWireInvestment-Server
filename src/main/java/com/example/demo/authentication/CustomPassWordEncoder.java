package com.example.demo.authentication;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomPassWordEncoder implements PasswordEncoder {

    public CustomPassWordEncoder() {
    }

    @Override
    public String encode(CharSequence rawPassword) {
        String hashed = BCrypt.hashpw(rawPassword.toString(), BCrypt.gensalt(0));
        return hashed;
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {

        return BCrypt.checkpw(rawPassword.toString(), encodedPassword);
    }

}
