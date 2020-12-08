package com.ai.schedule.bean.search;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ElementType.FIELD})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = Threshold.ThresholdValidator.class)
public @interface Threshold {

    String message() default "threshold invalid";

    class ThresholdValidator implements ConstraintValidator<Threshold, Float> {

        @Override
        public boolean isValid(Float value, ConstraintValidatorContext context) {
            return value >= 0 && value <= 1;
        }
    }
}
