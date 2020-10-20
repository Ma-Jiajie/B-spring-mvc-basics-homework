package com.thoughtworks.capacity.gtb.mvc.model;

import com.thoughtworks.capacity.gtb.mvc.dateProvider.UserDatabase;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.PARAMETER;

public class UserValidator implements ConstraintValidator<NotSameUserName, String> {

    @Override
    public void initialize(NotSameUserName constraintAnnotation) {}
    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        for(User user: UserDatabase.usersDataProvider().values()) {
            if(username.equals(user.getUsername())) return false;
        }
        return true;
    }
}

@Documented
@Constraint(validatedBy = UserValidator.class)
@Target({METHOD, FIELD})
@Retention(RUNTIME)
@interface NotSameUserName {
    String message() default "用户已存在";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
    @Retention(RUNTIME)
    @Documented
    @interface List {
        NotSameUserName[] value();
    }
}