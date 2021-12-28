package com.azlan.test.tdd;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

/*
 * This is an example TDD
 * Problem Statement: I want to validate the password length with minimum 5  & maximum 10 characters
 */
class PasswordValidatorTest {

    public PasswordValidator pv = new PasswordValidator();

    @Test
    void TestPasswordLengthValid(){
        Assertions.assertTrue(pv.isValid("12345"));
    }

    @Test
    void TestPasswordLengthMoreThanTen(){
        Assertions.assertFalse(pv.isValid("12345678901"));
    }

    @Test
    void TestPasswordLengthLessThanFive(){
        Assertions.assertFalse(pv.isValid("1234"));
    }
}
