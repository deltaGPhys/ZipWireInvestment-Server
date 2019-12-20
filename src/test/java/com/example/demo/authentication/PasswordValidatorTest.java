package com.example.demo.authentication;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PasswordValidatorTest {

    @Test
    void validPassword() {
        Assertions.assertFalse(PasswordValidator.validatePassword("Waldo82"));
    }

    @Test
    void validPassword1() {
        Assertions.assertFalse(PasswordValidator.validatePassword("Waldo2482"));
    }

    @Test
    void validPassword2() {
        Assertions.assertFalse(PasswordValidator.validatePassword("waldo!2482"));
    }

    @Test
    void validPassword3() {
        Assertions.assertFalse(PasswordValidator.validatePassword("WALDO!2482"));
    }

    @Test
    void validPassword4() {
        Assertions.assertFalse(PasswordValidator.validatePassword("Waldo2482"));
    }

    @Test
    void validPassword5() {
        Assertions.assertTrue(PasswordValidator.validatePassword("WALdO!2482"));
    }

    @Test
    void validPassword6() {
        Assertions.assertTrue(PasswordValidator.validatePassword("Waldo!2482"));
    }

    @Test
    void validPassword7() {
        Assertions.assertTrue(PasswordValidator.validatePassword("Mr.Smith9"));
    }

    @Test
    void validPassword8() {
        Assertions.assertTrue(PasswordValidator.validatePassword("WALdO.2482"));
    }
}