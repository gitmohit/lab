package lab.mohit.designPattern.observer.impl;

import lab.mohit.designPattern.observer.iface.IDisplayElement;
import lab.mohit.designPattern.observer.iface.IObservable;
import lab.mohit.designPattern.observer.iface.IObserver;

public class CurrentConditionDisplay implements IObserver, IDisplayElement {
    private float temperature;
    private float humidity;
    private float pressure;
    private IObservable weatherData;

    public CurrentConditionDisplay(IObservable weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }
    @Override
    public void display() {
        System.out.println("Weatherstation has boradcasted the temperature = " + temperature + " humidity = " + humidity + " pressure = " + pressure);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }
}
