package application;

import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor{
    private final ArrayList<Sensor> sensorList = new ArrayList<>();
    private ArrayList<Integer> readingList = new ArrayList<>();

    public void addSensor(Sensor toAdd){
        this.sensorList.add(toAdd);
    }

    public List<Integer> readings(){
        return this.readingList;
    }

    @Override
    public boolean isOn() {
        for(Sensor sensor : this.sensorList){
            if(!sensor.isOn()){
                return false;
            }
        }
        return true;
    }

    @Override
    public void setOn() {
        for(Sensor sensor : this.sensorList){
            sensor.setOn();
        }
    }

    @Override
    public void setOff() {
        for(Sensor sensor : this.sensorList){
            sensor.setOff();
        }
    }

    @Override
    public int read() {
        if(!this.isOn() || this.sensorList.isEmpty()){
            throw new IllegalStateException("All sensors NOT on OR there are NO sensors available");
        }
        int average = this.sensorList.stream()
                .mapToInt(Sensor::read)
                .sum()/this.sensorList.size();
        this.readingList.add(average);
        return average;
    }
}
