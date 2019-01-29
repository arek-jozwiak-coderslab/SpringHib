package pl.coderslab.validator;

import pl.coderslab.entity.Article;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CategoryLimitValidator implements ConstraintValidator<CategoryLimit, Article> {

    private int start;


    @Override
    public void initialize(CategoryLimit constraintAnnotation) {
        this.start = Integer.parseInt(constraintAnnotation.value());
    }

    @Override
    public boolean isValid(Article value, ConstraintValidatorContext context) {
        if (value.getCategories().size() > start) {
            //only for assigned error message to the specified field in form
//            context.disableDefaultConstraintViolation();
//            context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
//                    .addPropertyNode("categories").addConstraintViolation();
            return false;
        }
        return true;
    }
}