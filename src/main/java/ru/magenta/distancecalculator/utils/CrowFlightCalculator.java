package ru.magenta.distancecalculator.utils;

import org.springframework.stereotype.Component;

@Component
public class CrowFlightCalculator {

    private static final int R = 6371;

    public static Double calculate(double latitudeTo, double latitudeFrom,
                                   double longitudeTo, double longitudeFrom) {
        double d = Math.sin(degreesToRadian(latitudeFrom - latitudeTo) / 2) * Math.sin(degreesToRadian(latitudeFrom - latitudeTo) / 2) +
                Math.cos(degreesToRadian(latitudeTo)) * Math.cos(degreesToRadian(latitudeFrom)) *
                        Math.sin(degreesToRadian(longitudeFrom - longitudeTo) / 2) * Math.sin(degreesToRadian(longitudeFrom - longitudeTo) / 2);
        return R * (2 * Math.atan2(Math.sqrt(d), Math.sqrt(1 - d)));
    }

    private static double degreesToRadian(double degrees) {
        return degrees * (Math.PI / 180);
    }
}
