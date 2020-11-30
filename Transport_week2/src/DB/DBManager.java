package DB;
import Interfaces.Transport;
import java.util.ArrayList;

public class DBManager {
    public static ArrayList<Transport> transports = new ArrayList<>();
    static Long id = 4L;
    static {
        transports.add(new Truck(1L, "KAMAZ", "5490 NEO", 25000, 12000, 3000));
        transports.add(new Car(2L,"Audi", "RS5", "Fast Back", 300, 4.4, 36150, 2014));
        transports.add(new Bus(3L,"Mercedes", "eCitaro", 56, 85000));
    }

    public static void addTransport(Transport transport){
        if(transport instanceof Car){
            Car car = (Car)transport;
            car.setId(id);
            transports.add(transport);
        }else if(transport instanceof Bus){
            Bus bus = (Bus)transport;
            bus.setId(id);
            transports.add(bus);
        }else if(transport instanceof Truck){
            Truck truck = (Truck)transport;
            truck.setId(id);
            transports.add(truck);
        }
        id++;
    }

    public static Transport getTransport (Long id){
        try{
            for (Transport t: transports) {
                if (t.getId() == id) {
                    return t;
                }
            }
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return new Car();
    }

    public static ArrayList<Transport> getAllTransports(){
        return transports;
    }

    public static void deleteTransport(Long id){
        for (Transport t: transports) {
            if(t.getId() == id){
                transports.remove(t);
                break;
            }
        }
    }
}
