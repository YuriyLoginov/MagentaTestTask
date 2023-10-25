package ru.magenta.distancecalculator.model;

import lombok.Value;

import java.io.Serializable;
@Value
public class CityModel implements Serializable {
    Long id;
    String name;
}