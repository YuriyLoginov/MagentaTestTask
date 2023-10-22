package ru.magenta.distancecalculator.DTO;

import lombok.Value;

import java.io.Serializable;
@Value
public class DistanceDTO implements Serializable {
    String fromCityName;
    String toCityName;
    String calculatedType;
    Long distance;
}