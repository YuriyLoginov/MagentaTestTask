package ru.magenta.distancecalculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.magenta.distancecalculator.entity.City;
import ru.magenta.distancecalculator.service.impl.CityServiceImpl;

import java.util.List;

@RestController
public class CityController {

    private final CityServiceImpl cityService;

    @Autowired
    public CityController(CityServiceImpl cityService) {
        this.cityService = cityService;
    }


    @GetMapping(value = "/city")
    public List<City> getAllCities() {
        List<City> city = cityService.getAllCities();
        return city;
    }
}
