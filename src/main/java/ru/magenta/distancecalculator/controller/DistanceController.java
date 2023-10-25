package ru.magenta.distancecalculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.magenta.distancecalculator.model.DistanceModel;
import ru.magenta.distancecalculator.request.RequestDistance;
import ru.magenta.distancecalculator.service.impl.DistanceServiceImpl;

import java.util.Set;

@RestController
@RequestMapping("/distance")
public class DistanceController {

    private final DistanceServiceImpl distanceService;

    @Autowired
    public DistanceController(DistanceServiceImpl distanceService) {
        this.distanceService = distanceService;
    }

    @PostMapping("/calculate")
    public Set<DistanceModel> calculated(@RequestBody RequestDistance requestDistance) {
        return distanceService.calculateDistance(requestDistance);
    }
}
