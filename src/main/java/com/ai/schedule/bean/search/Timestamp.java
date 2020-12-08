package com.ai.schedule.bean.search;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.function.Supplier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ElementType.FIELD})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = Timestamp.ThresholdValidator.class)
public @interface Timestamp {

    String message() default "timestamp invalid";

    @Slf4j
    class ThresholdValidator implements ConstraintValidator<Timestamp, String> {

        private static final ThreadLocal<SimpleDateFormat> simpleDateFormat =
                ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

        @Override
        public boolean isValid(String value, ConstraintValidatorContext context) {
            if(StringUtils.isBlank(value)){
                return false;
            }
            try {
                simpleDateFormat.get().parse(value);
                return true;
            } catch (ParseException e) {
                log.error(e.getMessage(), e);
                return false;
            }
        }
    }
}
