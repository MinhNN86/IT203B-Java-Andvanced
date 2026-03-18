package Session08.Ex02.facade;


import Session08.Ex02.device.*;
import Session08.Ex02.sensor.*;

public class SmartHomeFacade {

    private Light light;
    private Fan fan;
    private AirConditioner airConditioner;
    private TemperatureSensor sensor;

    public SmartHomeFacade() {

        light = new Light();
        fan = new Fan();
        airConditioner = new AirConditioner();

        OldThermometer oldThermometer = new OldThermometer();
        sensor = new ThermometerAdapter(oldThermometer);
    }

    public void leaveHome() {

        light.turnOff();
        fan.turnOff();
        airConditioner.turnOff();
    }

    public void sleepMode() {

        light.turnOff();
        airConditioner.setTemperature(28);
        fan.setLowSpeed();
    }

    public void getCurrentTemperature() {

        double temp = sensor.getTemperatureCelsius();

        System.out.println("Nhiệt độ hiện tại: "
                + String.format("%.1f", temp) + "°C");
    }
}