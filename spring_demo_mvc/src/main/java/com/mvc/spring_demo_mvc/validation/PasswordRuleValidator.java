package com.mvc.spring_demo_mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordRuleValidator implements ConstraintValidator<PasswordRule, String> {


    @Override
    public void initialize(PasswordRule constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        //check if s starts with upper case letter
        if (!Character.isUpperCase(s.charAt(0))) {
            return false;
        }
        if (s.length() < 6) {
            return false;
        }
        //check if s contains at least one number
        boolean hasNumber = false;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                hasNumber = true;
            }
        }
        return hasNumber;
    }
}
