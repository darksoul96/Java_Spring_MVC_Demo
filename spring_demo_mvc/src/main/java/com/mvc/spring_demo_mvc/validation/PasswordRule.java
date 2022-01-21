package com.mvc.spring_demo_mvc.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = PasswordRuleValidator.class)
@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordRule {

    //define default password code
    public String value() default "ABC123";

    //define default error message
    public String message() default "Password must contain at least one digit, one lower case letter, one upper case letter, one special character and be at least 8 characters long.";

    //define default groups
    public Class<?>[] groups() default {};

    //define default payload
    Class<? extends Payload>[] payload() default {};


}





