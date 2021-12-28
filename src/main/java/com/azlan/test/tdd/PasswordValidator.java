package com.azlan.test.tdd;

public class PasswordValidator {

    public boolean isValid(String pwd){
        return pwd.length() >= 5 && pwd.length() <= 10;
    }
}
