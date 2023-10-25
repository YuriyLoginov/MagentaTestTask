package ru.magenta.distancecalculator.service;

import ru.magenta.distancecalculator.model.DistanceModel;
import ru.magenta.distancecalculator.request.RequestDistance;
import ru.magenta.distancecalculator.entity.City;

import java.util.Set;

public interface DistanceService {
    Set<DistanceModel> calculateDistance(RequestDistance requestDistance);
    DistanceModel calculateByCrowFlight(City fromCity, City toCiti);
    DistanceModel calculateByDistanceMatrix(City fromCity, City toCity);
}
