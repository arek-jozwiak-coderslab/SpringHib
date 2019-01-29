package pl.coderslab.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.entity.Category;
import pl.coderslab.repository.CategoryRepository;

public class CategoryConverter implements Converter<String, Category> {


    private CategoryRepository categoryRepository;

    @Autowired
    public void setTeamService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public Category convert(String source) {
        return categoryRepository.findOne(Long.parseLong(source));
    }
}