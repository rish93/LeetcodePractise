package com.Practise;

import java.lang.annotation.*;
/*



public class TestCustomAnnotation {

    @Enum(enumClass = SignalStatus.class,
            ignoreCase=true,
            message = "Invalid enum type for status")
    private String status;
}


@Documented
@Constraint(validatedBy = EnumValueValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@NotNull(message = "Value cannot be null")
@ReportAsSingleViolation   //from Javax validation
public @interface Enum {
    public abstract String message() default "Invalid value. This is not permitted.";

    public abstract Class<? extends java.lang.Enum<?>> enumClass();

    public abstract boolean ignoreCase() default false;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}


public class EnumValueValidator implements ConstraintValidator<Enum, String>
{
    private Enum annotation;

    @Override
    public void initialize(Enum annotation)
    {
        this.annotation = annotation;
    }




    @Override
    public boolean isValid(String valueForValidation, ConstraintValidatorContext constraintValidatorContext)
    {
        boolean result = false;
        Object[] enumValues = this.annotation.enumClass().getEnumConstants();

        if(enumValues != null) {
            for(Object enumValue:enumValues) {
                if(valueForValidation.equals(enumValue.toString())
                        || (this.annotation.ignoreCase() && valueForValidation.equalsIgnoreCase(enumValue.toString()))) {
                    return  true;
                }
            }
        }
        throw new IbnInboxException("Meta status should be possible enum value"+ "OPEN, TRANSFRRED, IRRELEVANT, CLOSED ");
    }
}

enum SignalStatus {

    Open("OPEN"),
    Closed("CLOSED");

    private String statusValue;

    SignalStatus(String statusValue) {
        this.statusValue = statusValue;
    }

    public String getStatus() {
        return statusValue;
    }
}
*/
