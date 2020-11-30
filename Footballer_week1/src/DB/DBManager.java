package DB;

import java.util.ArrayList;

public class DBManager {
    private static ArrayList<Footballer> footballers = new ArrayList<>();
    private static Long id = 6L;
    static {
        footballers.add(new Footballer(1L, "Ronaldo", "Cristiano", 30000000, "Juventus", 70000000));
        footballers.add(new Footballer(2L, "Vinicius", "Junior", 6000000, "Real Madrid", 120000000));
        footballers.add(new Footballer(3L, "Ruslan", "Malinovskyi", 4000000, "Atalanta", 15000000));
    }

    public static void addFootballer(Footballer f){
        f.setId(id);
        footballers.add(f);
        id++;
    }

    public static ArrayList<Footballer> getAllFootballers(){
        return footballers;
    }

    public static void deleteFootballer(int index){
        try {
            footballers.remove(index);
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
    }

}