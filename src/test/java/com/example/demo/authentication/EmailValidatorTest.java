package com.example.demo.authentication;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailValidatorTest {

    @Test
    void validateEmail() {
        Assertions.assertFalse(EmailValidator.validateEmail("Waldo.82@peanuts"));
    }

    @Test
    void validateEmail2() {
        Assertions.assertFalse(EmailValidator.validateEmail(".Waldo2482@com"));
    }

    @Test
    void validateEmail3() {
        Assertions.assertFalse(EmailValidator.validateEmail("waldo!2482@yeet..edu"));
    }

    @Test
    void validateEmail4() {
        Assertions.assertFalse(EmailValidator.validateEmail("WALDO!2482"));
    }

    @Test
    void validateEmail5() {
        Assertions.assertTrue(EmailValidator.validateEmail("pluto.mars@state.de.us"));
    }

    @Test
    void validateEmail6() {
        Assertions.assertTrue(EmailValidator.validateEmail("poor.teacher@cr.k12.de.us"));
    }

    @Test
    void validateEmail7() {
        Assertions.assertTrue(EmailValidator.validateEmail("R@chelSm!th@hotmail.com"));
    }
}