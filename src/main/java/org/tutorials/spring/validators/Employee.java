package org.tutorials.spring.validators;

import javax.validation.Constraint;
import java.lang.annotation.*;

/**
 * Created by mahsom on 3/26/16.
 */

@Documented
@Constraint(validatedBy = EmployeeValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Employee {

    String message() default "Manager and Employee must work for the some company";

    int min() default 0;
    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}
