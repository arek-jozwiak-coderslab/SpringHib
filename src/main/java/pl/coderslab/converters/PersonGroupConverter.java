package pl.coderslab.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import pl.coderslab.dao.PersonGroupDao;
import pl.coderslab.entity.PersonGroup;

public class PersonGroupConverter implements Converter<String, PersonGroup> {
    @Autowired
    private PersonGroupDao personGroupDao;

    @Override
    public PersonGroup convert(String source) {
        return  personGroupDao.findById(Integer.parseInt(source));

    }
}