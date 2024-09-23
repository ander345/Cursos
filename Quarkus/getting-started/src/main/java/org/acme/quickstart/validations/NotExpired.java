package org.acme.quickstart.validations;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE
, ElementType.CONSTRUCTOR, ElementType.PARAMETER , ElementType.TYPE_USE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {NotExpiredImpl.class})
public @interface NotExpired {
    String message() default "Not Expired beer";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
