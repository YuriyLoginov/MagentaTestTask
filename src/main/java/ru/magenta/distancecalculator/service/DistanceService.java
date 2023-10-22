package ru.magenta.distancecalculator.service;

import ru.magenta.distancecalculator.DTO.DistanceDTO;
import ru.magenta.distancecalculator.DTO.RequestDTO;
import ru.magenta.distancecalculator.entity.City;
import ru.magenta.distancecalculator.entity.Distance;

import java.util.List;

public interface DistanceService {
    List<DistanceDTO> calculateDistance(RequestDTO requestDTO);
    DistanceDTO calculateByCrowFlight(City fromCity, City toCiti);
    DistanceDTO calculateByDistanceMatrix(City fromCity, City toCity);
}
