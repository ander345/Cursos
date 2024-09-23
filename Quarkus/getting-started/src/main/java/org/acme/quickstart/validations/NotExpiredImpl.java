package org.acme.quickstart.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class NotExpiredImpl implements ConstraintValidator<NotExpired, LocalDate> {

    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {

        if (value == null) return true;

        LocalDate now = LocalDate.now();

        return ChronoUnit.YEARS.between(now, value) > 0;
    }
}
