package application;

public class Program {

    public static void main(String[] args) {
        Sensor standardSensor = new StandardSensor(13);
        Sensor temperatureSensor1 = new TemperatureSensor();
        Sensor temperatureSensor2 = new TemperatureSensor();

        AverageSensor averageSensor = new AverageSensor();
        averageSensor.addSensor(standardSensor);
        averageSensor.addSensor(temperatureSensor1);
        averageSensor.addSensor(temperatureSensor2);

        averageSensor.setOn();
        System.out.println("temperature in region, " + averageSensor.read() + " degrees Celsius");
        System.out.println("temperature in region, " + averageSensor.read() + " degrees Celsius");
        System.out.println("temperature in region, " + averageSensor.read() + " degrees Celsius");

        System.out.println("readings: " + averageSensor.readings());
        
    }
//    OUTPUT:
//    temperature in region 3 degrees Celsius
//    temperature in region 7 degrees Celsius
//    temperature in region -5 degrees Celsius
//    readings: [3, 7, -5]


}
