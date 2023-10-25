package ru.magenta.distancecalculator.service;

import ru.magenta.distancecalculator.DTO.DistanceDTO;
import ru.magenta.distancecalculator.DTO.RequestDistanceDTO;
import ru.magenta.distancecalculator.entity.City;

import java.util.List;

public interface DistanceService {
    List<DistanceDTO> calculateDistance(RequestDistanceDTO requestDistanceDTO);
    DistanceDTO calculateByCrowFlight(City fromCity, City toCiti);
    DistanceDTO calculateByDistanceMatrix(City fromCity, City toCity);
}
