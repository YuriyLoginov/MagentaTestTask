package ru.magenta.distancecalculator.request;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.magenta.distancecalculator.entity.City;
import ru.magenta.distancecalculator.enums.CalculatedType;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class RequestDistance implements Serializable {
    List<CalculatedType> calculatedTypes;
    List<City> fromCitiesList;
    List<City> toCitiesList;
}