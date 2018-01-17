package pl.coderslab.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import pl.coderslab.entity.Unit;
import pl.coderslab.repository.UnitRepository;

public class UnitConverter implements Converter<String, Unit> {
    @Autowired
    private UnitRepository publisherDao;

    @Override
    public Unit convert(String source) {
        return publisherDao.findOne(Long.parseLong(source));

    }
}