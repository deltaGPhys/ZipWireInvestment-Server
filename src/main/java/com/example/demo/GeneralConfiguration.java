package com.example.demo;

import com.example.demo.authentication.CustomPassWordEncoder;
import com.example.demo.services.CustomPasswordEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Profile({"development", "test"})
@Configuration
public class GeneralConfiguration {

    @Bean
    private static final PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //public static

//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }

}
