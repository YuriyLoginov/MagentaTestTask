package ru.magenta.distancecalculator.service;

import ru.magenta.distancecalculator.DTO.CityDto;
import ru.magenta.distancecalculator.entity.City;

import java.util.List;

public interface CityService {
    List<CityDto> getAllCities();
}
