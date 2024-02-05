package com.inworn.test.cashaccount.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;
import java.util.regex.Pattern;

public class PhoneValidator implements ConstraintValidator<Phone, String> {

    public static Pattern pattern = Pattern.compile("^\\+?[1-9]\\d{10,14}$");

    private String message;

    @Override
    public void initialize(final Phone constraintAnnotation) {
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(final String phone, final ConstraintValidatorContext context) {

        boolean isValid = false;

        if (Objects.nonNull(phone)) {
            isValid = pattern.matcher(phone).matches();
        }

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(message).addConstraintViolation();
        }

        return isValid;
    }
}
