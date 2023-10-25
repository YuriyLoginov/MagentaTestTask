package ru.magenta.distancecalculator.utils;

public class CrowFlightCalculator {

    private static final int R = 6371;

    public static Double calculate(double latitudeTo, double latitudeFrom,
                                 double longitudeTo, double longitudeFrom) {
        double d = Math.sin(degreesToRadian(latitudeTo) / 2) * Math.sin(degreesToRadian(latitudeFrom) / 2) +
                Math.cos(latitudeTo) * Math.cos(latitudeFrom) *
                        Math.cos(degreesToRadian(longitudeTo) - degreesToRadian(longitudeFrom));
        return Math.cos(d) * R;
    }

    private static double degreesToRadian(double degrees) {
        return degrees * (Math.PI / 180);
    }
}
