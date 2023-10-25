package ru.magenta.distancecalculator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.magenta.distancecalculator.model.CityModel;
import ru.magenta.distancecalculator.repository.CityRepository;
import ru.magenta.distancecalculator.service.CityService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public List<CityModel> getAllCities() {
        return cityRepository.findAll()
                .stream()
                .map(city -> new CityModel(city.getId(), city.getName()))
                .collect(Collectors.toList());
    }
}
