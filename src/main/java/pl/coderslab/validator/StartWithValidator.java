package pl.coderslab.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StartWithValidator implements ConstraintValidator<StartWith, String> {

    private String start;
    private String end;

    @Override
    public void initialize(StartWith constraintAnnotation) {
        this.start = constraintAnnotation.value();
        this.end = constraintAnnotation.value2();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        return value.startsWith(start) && value.endsWith(end);
    }
}