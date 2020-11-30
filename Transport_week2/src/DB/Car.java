package DB;

import Interfaces.Transport;

public class Car implements Transport {

private Long id;
    private String name;
    private String model;
    private String carcase_type;
    private int maxSpeed;
    private double engineVolume;
    private int price;
    private int year;

    public Car() {}

    public Car(Long id, String name, String model, String carcase_type, int maxSpeed, double engineVolume, int price, int year) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.carcase_type = carcase_type;
        this.maxSpeed = maxSpeed;
        this.engineVolume = engineVolume;
        this.price = price;
        this.year = year;
    }

    public Car(String name, String model, String carcase_type, int maxSpeed, double engineVolume, int price, int year) {
        this.name = name;
        this.model = model;
        this.carcase_type = carcase_type;
        this.maxSpeed = maxSpeed;
        this.engineVolume = engineVolume;
        this.price = price;
        this.year = year;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCarcase_type() {
        return carcase_type;
    }

    public void setCarcase_type(String carcase_type) {
        this.carcase_type = carcase_type;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(double engineVolume) {
        this.engineVolume = engineVolume;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTransportFullName() {
        return this.name + " " + this.getModel();
    }

    @Override
    public String getTransportDescription() {
        return this.carcase_type + ", from " + this.year + " year, max speed " + this.maxSpeed + "km/h, " + this.engineVolume + " liters";
    }

    @Override
    public int getTransportPrice() {
        return this.price;
    }
}
