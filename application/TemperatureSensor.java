package application;

import java.util.Random;

public class TemperatureSensor implements Sensor{
    private boolean sensorStatus;

    public TemperatureSensor() {
        this.sensorStatus = false;
    }

    @Override
    public boolean isOn() {
        return this.sensorStatus;
    }

    @Override
    public void setOn() {
        this.sensorStatus = true;
    }

    @Override
    public void setOff() {
        this.sensorStatus = false;
    }

    @Override
    public int read() {
        if(this.isOn()){
            return new Random().nextInt(61) - 30;
        } else {
            throw new IllegalStateException("Temperature Sensor is NOT on");
        }
    }
}
