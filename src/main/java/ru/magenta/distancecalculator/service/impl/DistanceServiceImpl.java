package ru.magenta.distancecalculator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.magenta.distancecalculator.DTO.DistanceDTO;
import ru.magenta.distancecalculator.DTO.RequestDistanceDTO;
import ru.magenta.distancecalculator.entity.City;
import ru.magenta.distancecalculator.enums.CalculatedType;
import ru.magenta.distancecalculator.repository.DistanceRepository;
import ru.magenta.distancecalculator.service.DistanceService;
import ru.magenta.distancecalculator.utils.CrowFlightCalculator;

import java.util.List;

@Service
public class DistanceServiceImpl implements DistanceService {

    private final DistanceRepository distanceRepository;

    @Autowired
    public DistanceServiceImpl(DistanceRepository distanceRepository) {
        this.distanceRepository = distanceRepository;
    }

    @Override
    public List<DistanceDTO> calculateDistance(RequestDistanceDTO requestDistanceDTO) {

        return null;
    }

    @Override
    public DistanceDTO calculateByCrowFlight(City fromCity, City toCiti) {
        return new DistanceDTO(fromCity.getName(), toCiti.getName(), CalculatedType.CROW_FLIGHT.name(),
                CrowFlightCalculator.calculate(toCiti.getLatitude(), fromCity.getLatitude(),
                toCiti.getLongitude(), fromCity.getLongitude()));
    }

    @Override
    public DistanceDTO calculateByDistanceMatrix(City fromCity, City toCity) {
        return new DistanceDTO(fromCity.getName(), toCity.getName(), CalculatedType.DISTANCE_MATRIX.name(),
                distanceRepository.findDistanceByFromCityAndToCity(fromCity, toCity).getDistance());
    }
}
