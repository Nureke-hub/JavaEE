package DB;

import DB.Classes.City;
import DB.Classes.Club;
import DB.Classes.League;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class DBManager {
    private static Connection connection;
    //jdbc:postgresql://host:port/database
    private static String url = "jdbc:postgresql://rogue.db.elephantsql.com:5432/hnatxoit";
    private static String user = "hnatxoit";
    private static String password = "X5SSAUuvcCrxqXhhnwX2Xe4dee72ZzDm";

    static {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static ArrayList<League> listOfLeagues(){
        ArrayList<League> leagues = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("" +
                    "SELECT * FROM league");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                leagues.add(new League(
                        resultSet.getLong("league_id"),
                        resultSet.getString("name"),
                        resultSet.getString("description")
                ));
            }
            preparedStatement.close();
            return leagues;
        }catch (Exception e){
            e.printStackTrace();
        }

        return leagues;
    }

    public static ArrayList<Club> getLeagueClubs(Long leagueId){
        ArrayList<Club> clubs = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("" +
                    "SELECT cl.club_id, cl.name AS club_name, cl.description, cl.founded_year, cl.city_id, ct.name AS city_name, ct.league_id " +
                    "FROM club cl " +
                    "INNER JOIN city ct ON cl.club_id = ct.city_id " +
                    "WHERE ct.league_id = ?");
            preparedStatement.setLong(1, leagueId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                clubs.add(new Club(
                        resultSet.getLong("club_id"),
                        resultSet.getString("club_name"),
                        resultSet.getString("description"),
                        resultSet.getInt("founded_year"),
                        new City(
                                resultSet.getLong("city_id"),
                                resultSet.getString("city_name")
                        )
                ));
            }
            preparedStatement.close();
            return clubs;
        }catch (Exception e){
            e.printStackTrace();
        }
        return clubs;
    }



}
