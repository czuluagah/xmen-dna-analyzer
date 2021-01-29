package com.xmen.dnasentinel.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target(TYPE)
@Constraint(validatedBy = DNASequenceValidator.class)
@Documented
public @interface DNASequenceValid {

    String message() default "Not Human or Mutant Sequence DNA maybe Alien";


    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
