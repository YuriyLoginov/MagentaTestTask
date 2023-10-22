package ru.magenta.distancecalculator.DTO;

import lombok.Value;

import java.io.Serializable;
@Value
public class CityDto implements Serializable {
    Long id;
    String name;
}