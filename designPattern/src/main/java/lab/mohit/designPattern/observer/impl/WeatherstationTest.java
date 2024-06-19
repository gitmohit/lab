package lab.mohit.designPattern.observer.impl;

import lab.mohit.designPattern.observer.iface.IObserver;

public class WeatherstationTest {
    public static void main(String[] args) throws InterruptedException {
        WeatherData weatherStation = new WeatherData();
        IObserver currentConditionDisplay = new CurrentConditionDisplay(weatherStation);
        weatherStation.setMeasurements(80, 65, 30.4f);
        Thread.sleep(1000);
        weatherStation.setMeasurements(70, 55, 28.4f);
        Thread.sleep(1000);
        weatherStation.setMeasurements(60, 45, 31.4f);
    }
}
