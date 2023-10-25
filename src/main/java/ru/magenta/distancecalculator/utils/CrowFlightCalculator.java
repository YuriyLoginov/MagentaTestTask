package ru.magenta.distancecalculator.utils;

public class CrowFlightCalculator {

    private static final int R = 6371;

    // cos(d) = sin(φА)·sin(φB) + cos(φА)·cos(φB)·cos(λА − λB)
    public static Long calculate(int latitudeTo, int latitudeFrom,
                                 int longitudeTo, int longitudeFrom) {
        double d = Math.sin(degreesToRadian(latitudeTo) / 2) * Math.sin(degreesToRadian(latitudeFrom) / 2) +
                Math.cos(latitudeTo) * Math.cos(latitudeFrom) *
                        Math.cos(degreesToRadian(longitudeTo) - degreesToRadian(longitudeFrom));
        return Math.round(d) * R;
    }

    private static double degreesToRadian(int degrees) {
        return degrees * (Math.PI / 180);
    }
}
