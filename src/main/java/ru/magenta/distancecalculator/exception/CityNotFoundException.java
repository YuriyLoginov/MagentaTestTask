package ru.magenta.distancecalculator.exception;

public class CityNotFoundException extends NullPointerException {
    public CityNotFoundException(String s) {
        super(s);
    }
}
