package ru.magenta.distancecalculator.DTO;

import lombok.Value;
import ru.magenta.distancecalculator.entity.City;
import ru.magenta.distancecalculator.enums.CalculatedType;

import java.io.Serializable;
import java.util.List;

@Value
public class RequestDistanceDTO implements Serializable {
    List<CalculatedType> calculatedTypes;
    List<City> fromCitiesList;
    List<City> toCitiesList;
}
