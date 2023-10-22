package ru.magenta.distancecalculator.DTO;

import lombok.Value;
import ru.magenta.distancecalculator.entity.City;
import ru.magenta.distancecalculator.entity.Distance;

import java.io.Serializable;
import java.util.List;

@Value
public class RequestFileDTO implements Serializable {
    List<City> cities;
    List<Distance> distances;
}
