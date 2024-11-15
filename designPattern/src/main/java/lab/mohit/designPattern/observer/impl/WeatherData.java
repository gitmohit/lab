package lab.mohit.designPattern.observer.impl;

import lab.mohit.designPattern.observer.iface.IObservable;
import lab.mohit.designPattern.observer.iface.IObserver;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements IObservable {
    private List<IObserver> observers;
    private float temperature;
    private float humidity;
    private float pressure;


    public WeatherData() {
        this.observers = new ArrayList<>();
    }

    @Override
    public boolean registerObserver(IObserver observer) {
        observers.add(observer);
        return true;
    }

    @Override
    public boolean removeObserver(IObserver observer) {
        int index = observers.indexOf(observer);
        if (index >= 0) {
            observers.remove(index);
            return true;
        }
        return false;
    }

    @Override
    public void notifyObserver() {
        for(IObserver observer : observers) {
            observer.update(temperature, humidity, pressure);
        }
    }

    public void setMeasurements(float temperature, float humidity, float pressue) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressue;
        measurementsChanged();
    }

    private void measurementsChanged() {
        notifyObserver();
    }

}
