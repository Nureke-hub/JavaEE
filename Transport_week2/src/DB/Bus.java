package DB;

import Interfaces.Transport;

public class Bus implements Transport {
    private Long id;
    private String name;
    private String model;
    private int passengerPlaces;
    private int price;

    public Bus() {}

    public Bus(Long id, String name, String model, int passengerPlaces, int price) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.passengerPlaces = passengerPlaces;
        this.price = price;
    }

    public Bus(String name, String model, int passengerPlaces, int price) {
        this.name = name;
        this.model = model;
        this.passengerPlaces = passengerPlaces;
        this.price = price;
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

    public int getPassengerPlaces() {
        return passengerPlaces;
    }

    public void setPassengerPlaces(int passengerPlaces) {
        this.passengerPlaces = passengerPlaces;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String getTransportFullName() {
        return this.name + " " + this.getModel();
    }

    @Override
    public String getTransportDescription() {
        return "This bus can transport " + this.passengerPlaces + " passengers";
    }

    @Override
    public int getTransportPrice() {
        return this.price;
    }
}
