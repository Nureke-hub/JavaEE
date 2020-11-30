package DB;

import java.util.ArrayList;

public class DBManager {
    private static ArrayList<Car> cars = new ArrayList<>();
    private static Long id = 5L;

    static {
        cars.add(new Car(1L, "Audi", "RS7", 2018, 34000000));
        cars.add(new Car(2L, "Nissan", "Skyline GTR R34", 2000, 8000000));
        cars.add(new Car(3L, "Toyota", "Supra", 2004, 12000000));
        cars.add(new Car(4L, "Mitsubishi", "Lancer Evolution", 2002, 6000000));
    }

    public static void addCar(Car car){
        car.setId(id);
        cars.add(car);
        id++;
    }

    public static Car getCar(Long id){
        for(Car car: cars){
            if(car.getId() == id){
                return car;
            }
        }
        return new Car();
    }

    public static ArrayList<Car> getAllCars(){
        return cars;
    }

    public static void deleteCar(Long id){
        for(Car car: cars){
            if(car.getId() == id){
                cars.remove(car);
                break;
            }
        }
    }

    public static ArrayList<Car> getCarsByName(String name){
        ArrayList<Car> carsByName = new ArrayList<>();
        for(Car car: cars){
            if(car.getName().toLowerCase().compareTo(name.toLowerCase()) == 0){
                carsByName.add(car);
            }
        }
        return carsByName;
    }

    public static ArrayList<Car> getCarsByModel(String model){
        ArrayList<Car> carsByModel = new ArrayList<>();
        for(Car car: cars){
            if(car.getModel().toLowerCase().compareTo(model.toLowerCase()) == 0){
                carsByModel.add(car);
            }
        }
        return carsByModel;
    }

    public static ArrayList<Car> getCarsByYear(int yearFrom){
        ArrayList<Car> carsByYear = new ArrayList<>();
        for(Car car: cars){
            if(car.getYear() >= yearFrom){
                carsByYear.add(car);
            }
        }
        return carsByYear;
    }

    public static ArrayList<Car> getCarsByPrice(int priceTo){
        ArrayList<Car> carsByPrice = new ArrayList<>();
        for(Car car: cars){
            if(car.getPrice() <= priceTo){
                carsByPrice.add(car);
            }
        }
        return carsByPrice;
    }

}
