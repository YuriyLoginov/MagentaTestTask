package ru.magenta.distancecalculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.magenta.distancecalculator.DTO.CityDto;
import ru.magenta.distancecalculator.service.impl.CityServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CitiesController {

    private final CityServiceImpl cityService;

    @Autowired
    public CitiesController(CityServiceImpl cityService) {
        this.cityService = cityService;
    }

    @GetMapping(value = "/getAllCities")
    public List<CityDto> getAllCities() {
        return cityService.getAllCities();
    }
}
