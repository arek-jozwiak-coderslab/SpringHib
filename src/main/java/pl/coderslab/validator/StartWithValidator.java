package pl.coderslab.validator;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
public class StartWithValidator implements ConstraintValidator<StartWith, String> {
    @Override
    public void initialize(StartWith constraintAnnotation) {
    }
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.startsWith("A");
    }
}