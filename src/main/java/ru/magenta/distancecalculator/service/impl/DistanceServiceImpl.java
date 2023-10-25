package ru.magenta.distancecalculator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.magenta.distancecalculator.model.DistanceModel;
import ru.magenta.distancecalculator.request.RequestDistance;
import ru.magenta.distancecalculator.entity.City;
import ru.magenta.distancecalculator.enums.CalculatedType;
import ru.magenta.distancecalculator.repository.DistanceRepository;
import ru.magenta.distancecalculator.service.DistanceService;
import ru.magenta.distancecalculator.utils.CrowFlightCalculator;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DistanceServiceImpl implements DistanceService {

    private final DistanceRepository distanceRepository;

    @Autowired
    public DistanceServiceImpl(DistanceRepository distanceRepository) {
        this.distanceRepository = distanceRepository;
    }

    @Override
    public Set<DistanceModel> calculateDistance(RequestDistance requestDistance) {
        return calculateTypeHandler(requestDistance);
    }

    @Override
    public DistanceModel calculateByCrowFlight(City fromCity, City toCity) {
        return new DistanceModel(fromCity.getName(), toCity.getName(), CalculatedType.CROW_FLIGHT.name(),
                CrowFlightCalculator.calculate(toCity.getLatitude(), fromCity.getLatitude(),
                toCity.getLongitude(), fromCity.getLongitude()));
    }

    @Override
    public DistanceModel calculateByDistanceMatrix(City fromCity, City toCity) {
        return new DistanceModel(fromCity.getName(), toCity.getName(), CalculatedType.DISTANCE_MATRIX.name(),
                distanceRepository.findDistanceByFromCityAndToCity(fromCity, toCity).getDistance());
    }

    private Set<DistanceModel> calculateTypeHandler(RequestDistance requestDistance) {
        List<CalculatedType> calculatedTypes = requestDistance.getCalculatedTypes();
        Set<City> fromCity = new HashSet<>(requestDistance.getFromCitiesList());
        Set<City> toCity = new HashSet<>(requestDistance.getToCitiesList());
        Set<DistanceModel> distanceModels = new HashSet<>();
        if (calculatedTypes.contains(CalculatedType.ALL)) {
            distanceModels.addAll(calculateCrowFlightHandler(fromCity, toCity));
            distanceModels.addAll(calculateDistanceMatrixHandler(fromCity, toCity));
            return distanceModels;
        }
        if (calculatedTypes.contains(CalculatedType.CROW_FLIGHT) &&
                calculatedTypes.contains(CalculatedType.DISTANCE_MATRIX)) {
            distanceModels.addAll(calculateCrowFlightHandler(fromCity, toCity));
            distanceModels.addAll(calculateDistanceMatrixHandler(fromCity, toCity));
            return distanceModels;
        } else if (calculatedTypes.contains(CalculatedType.CROW_FLIGHT)) {
            return calculateCrowFlightHandler(fromCity, toCity);
        } else if (calculatedTypes.contains(CalculatedType.DISTANCE_MATRIX)) {
            return calculateDistanceMatrixHandler(fromCity, toCity);
        }
        return null;
    }

    private Set<DistanceModel> calculateDistanceMatrixHandler(Set<City> fromCity, Set<City> toCity) {
        return fromCity.stream()
                .flatMap(from -> toCity.stream()
                        .map(to -> calculateByDistanceMatrix(from, to)))
                .collect(Collectors.toSet());
    }

    private Set<DistanceModel> calculateCrowFlightHandler(Set<City> fromCity, Set<City> toCity) {
        return fromCity.stream()
                .flatMap(from -> toCity.stream()
                        .map(to -> calculateByCrowFlight(from, to)))
                .collect(Collectors.toSet());
    }
}
