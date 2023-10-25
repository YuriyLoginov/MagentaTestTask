package ru.magenta.distancecalculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.magenta.distancecalculator.DTO.DistanceDTO;
import ru.magenta.distancecalculator.DTO.RequestDistanceDTO;
import ru.magenta.distancecalculator.service.impl.DistanceServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/distance")
public class DistanceController {

    private final DistanceServiceImpl distanceService;

    @Autowired
    public DistanceController(DistanceServiceImpl distanceService) {
        this.distanceService = distanceService;
    }

    @PostMapping("/calculate")
    public List<DistanceDTO> calculated(@RequestBody RequestDistanceDTO requestDistanceDTO) {
        return distanceService.calculateDistance(requestDistanceDTO);
    }
}
