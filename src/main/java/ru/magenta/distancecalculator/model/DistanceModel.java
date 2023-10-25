package ru.magenta.distancecalculator.model;

import lombok.Value;

import java.io.Serializable;
@Value
public class DistanceModel implements Serializable {
    String fromCityName;
    String toCityName;
    String calculatedType;
    Double distance;
}