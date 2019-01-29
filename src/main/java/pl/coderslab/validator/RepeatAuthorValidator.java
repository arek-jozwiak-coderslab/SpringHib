package pl.coderslab.validator;

import pl.coderslab.entity.Book;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RepeatAuthorValidator implements ConstraintValidator<RepeatAuthor, Book> {

    @Override
    public void initialize(RepeatAuthor constraintAnnotation) {

    }

    @Override
    public boolean isValid(Book value, ConstraintValidatorContext context) {
        System.out.println(value.getTitle());
        System.out.println(value.getAuthor());
        System.out.println(value.getAuthors());
        if (value.getAuthors().contains(value.getAuthor())) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
                    .addPropertyNode("author").addConstraintViolation();
            return false;
        }
        return true;
    }
}