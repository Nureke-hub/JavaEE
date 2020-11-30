package db;

import db.classes.Admin;
import db.classes.Languages;
import db.classes.News;
import db.classes.Publications;

import javax.xml.crypto.Data;
import java.sql.Statement;
import java.sql.*;
import java.util.ArrayList;

public class Database {
    private static Connection connection;
    //    jdbc:postgresql://host:port/database
    private static String url = "jdbc:postgresql://rogue.db.elephantsql.com:5432/euybhiqw";
    private static String user = "euybhiqw";
    private static String password = "1AlMKIZ-6RSwNscUAxdg8p9SRCqkzwiA";
    private static Statement statement;

    static {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //auth
    public static boolean authentificate(String username, String password) throws Exception{
        String query = "select * from admin where username = ? and password = ?";
        try{
            PreparedStatement prt = connection.prepareStatement(query);
            prt.setString(1, username);
            prt.setString(2, password);
            ResultSet resultSet = prt.executeQuery();
            resultSet.next();
            if(resultSet.getRow()!=0){
                return true;
            }
            return false;
        }catch (Exception e){
            throw e;
        }
    }

    // private methods
    private static ResultSet executeQuery(String query) throws Exception{
        try {
            Statement statement = connection.createStatement();
            return  statement.executeQuery(query);
        } catch (Exception e) {
            throw e;
        }
    }
    private static void deleteFrom(String query, Long id) throws Exception{
        try {
            PreparedStatement prt = connection.prepareStatement(query);
            prt.setLong(1, id);
            prt.executeUpdate();
        }catch (Exception e){
            throw e;
        }
    }

    // get Object
    public static Publications getPublicationObject(Long id) throws Exception{
        String query = "select * from publications where id = ?";
        try{
            PreparedStatement prt = connection.prepareStatement(query);
            prt.setLong(1, id);
            ResultSet resultSet = prt.executeQuery();
            resultSet.next();
            return new Publications(
                    resultSet.getLong("id"),
                    resultSet.getString("name"),
                    resultSet.getString("description"),
                    resultSet.getDouble("rating"));
        }catch (Exception e){
            throw e;
        }
    }
    public static News getNewObject(Long id) throws Exception{
        String query = "select * from news where id = ?";
        try{
            PreparedStatement prt = connection.prepareStatement(query);
            prt.setLong(1, id);
            ResultSet resultSet = prt.executeQuery();
            resultSet.next();
            System.out.println(resultSet.getRow()  + " =======");
            System.out.println(resultSet.getLong("publication_id"));
            System.out.println(resultSet.getLong("language_id"));
            return new News(
                    resultSet.getLong("id"),
                    resultSet.getString("title"),
                    resultSet.getString("short_content"),
                    resultSet.getString("content"),
                    resultSet.getDate("post_date"),
                    resultSet.getString("picture_url"),
                    getLanguageObject(resultSet.getLong("language_id")),
                    getPublicationObject(resultSet.getLong("publication_id")));

        }catch (Exception e){
            throw e;
        }
    }
    public static Languages getLanguageObject(Long id) throws Exception{
        String query = "select * from languages where id = ?";
        try{
            PreparedStatement prt = connection.prepareStatement(query);
            prt.setLong(1, id);
            ResultSet resultSet = prt.executeQuery();
            resultSet.next();
            System.out.println(resultSet.getRow());
            return new Languages(
                    resultSet.getLong("id"),
                    resultSet.getString("name"),
                    resultSet.getString("code"));
        }catch (Exception e){
            throw e;
        }
    }
    public static Languages getLanguageId(String code) throws Exception{
        String query = "select * from languages where code = ?";
        try{
            PreparedStatement prt = connection.prepareStatement(query);
            prt.setString(1, code);
            ResultSet resultSet = prt.executeQuery();
            resultSet.next();
            return new Languages(
                    resultSet.getLong("id"),
                    resultSet.getString("name"),
                    resultSet.getString("code"));
        }catch (Exception e){
            throw e;
        }
    }

    // get All
    public static ArrayList<Publications> allPublications() throws Exception{
        String query = "select * from publications";
        try{
            ResultSet resultSet = executeQuery(query);
            ArrayList<Publications> publications = new ArrayList<>();
            while (resultSet.next()){
                publications.add(new Publications(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getDouble("rating")));
            }
            return publications;
        }catch (Exception e){
            throw e;
        }
    }
    public static ArrayList<News> allNews() throws Exception{
        String query = "select * from news";
        try{
            ResultSet resultSet = executeQuery(query);
            ArrayList<News> news = new ArrayList<>();
            while (resultSet.next()){
                news.add(new News(
                        resultSet.getLong("id"),
                        resultSet.getString("title"),
                        resultSet.getString("short_content"),
                        resultSet.getString("content"),
                        resultSet.getDate("post_date"),
                        resultSet.getString("picture_url"),
                        getLanguageObject(resultSet.getLong("language_id")),
                        getPublicationObject(resultSet.getLong("publication_id"))));
            }

            return news;
        }catch (Exception e){
            throw e;
        }
    }
    public static ArrayList<Languages> allLanguages() throws Exception{
        String query = "select * from languages";
        try{
            ResultSet resultSet = executeQuery(query);
            ArrayList<Languages> languages = new ArrayList<>();
            while (resultSet.next()){
                languages.add(new Languages(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("code")));
            }
            return languages;
        }catch (Exception e){
            throw e;
        }
    }

    // get By
    public static ArrayList<News> newsByLang(Long id) throws Exception{
        String query = "select * from news where language_id = ?";
        try{
            PreparedStatement prt = connection.prepareStatement(query);
            ArrayList<News> news = new ArrayList<>();
            prt.setLong(1, id);
            ResultSet resultSet = prt.executeQuery();

            while (resultSet.next()){
                news.add(new News(
                        resultSet.getLong("id"),
                        resultSet.getString("title"),
                        resultSet.getString("short_content"),
                        resultSet.getString("content"),
                        resultSet.getDate("post_date"),
                        resultSet.getString("picture_url"),
                        getLanguageObject(resultSet.getLong("language_id")),
                        getPublicationObject(resultSet.getLong("publication_id"))));
            }

            return news;

        }catch (Exception e){
            throw e;
        }
    }

    // get ID
    public static Long languageId(String code){
        return null;
    }

    // delete
    public static void deletePublication(Long id) throws Exception{
        try {
            deleteFrom("delete from publications where id = ?", id);
        }catch (Exception e){
            throw e;
        }
    }
    public static void deleteNew(Long id) throws Exception{
        try {
            deleteFrom("delete from news where id = ?", id);
        }catch (Exception e){
            throw e;
        }
    }
    public static void deleteLanguages(Long id) throws Exception{
        try {
            deleteFrom("delete from languages where id = ?", id);
        }catch (Exception e){
            throw e;
        }
    }

    //add
    public static void addPublication(Publications publication) throws Exception{
        try {
            String query = "insert into publications(name,description,rating) values (?,?,?)";
            PreparedStatement prt = connection.prepareStatement(query);
            prt.setString(1,publication.getName());
            prt.setString(2,publication.getDescription());
            prt.setDouble(3,publication.getRating());
            prt.executeUpdate();
        }catch (Exception e){
            throw e;
        }
    }
    public static void addNew(News news) throws Exception{
        try {
            String query = "insert into news(title,short_content,content,picture_url,language_id,publication_id) values (?,?,?,?,?,?)";
            PreparedStatement prt = connection.prepareStatement(query);
            prt.setString(1,news.getTitle());
            prt.setString(2,news.getShort_content());
            prt.setString(3,news.getContent());
            prt.setString(4,news.getPicture_url());
            prt.setLong(5,news.getLanguage().getId());
            prt.setLong(6,news.getPublication().getId());
            prt.executeUpdate();
        }catch (Exception e){
            throw e;
        }
    }
    public static void addLanguage(Languages language) throws Exception{
        try {
            String query = "insert into languages(name,code) values (?,?)";
            PreparedStatement prt = connection.prepareStatement(query);
            prt.setString(1,language.getName());
            prt.setString(2,language.getCode());
            prt.executeUpdate();
        }catch (Exception e){
            throw e;
        }
    }

    //update
    public static void updatePublication(Long id, Publications publication) throws Exception{
        String query = "update publications " +
                "set name = ? " +
                ",description = ? " +
                ",rating = ? " +
                "where id = ?";
        try {
            PreparedStatement prt = connection.prepareStatement(query);
            prt.setString(1,publication.getName());
            prt.setString(2,publication.getDescription());
            prt.setDouble(3,publication.getRating());
            prt.setLong(4,id);
            prt.executeUpdate();
        }catch (Exception e){
            throw e;
        }
    }
    public static void updateNew(Long id, News news) throws Exception{
        String query = "update news " +
                "set title = ? " +
                ", short_content = ? " +
                ", content = ? " +
                ", picture_url = ? " +
                ", language_id = ? " +
                ", publication_id = ? " +
                "where id = ?";
        try {
            PreparedStatement prt = connection.prepareStatement(query);
            prt.setString(1,news.getTitle());
            prt.setString(2,news.getShort_content());
            prt.setString(3,news.getContent());
            prt.setString(4,news.getPicture_url());
            prt.setLong(5,news.getLanguage().getId());
            prt.setLong(6,news.getPublication().getId());
            prt.setLong(7,id);
            prt.executeUpdate();
        }catch (Exception e){
            throw e;
        }
    }
    public static void updateLanguage(Long id, Languages language) throws Exception{
        String query = "update languages set name = ?, code = ? where id = ?";
        try {
            PreparedStatement prt = connection.prepareStatement(query);
            prt.setString(1,language.getName());
            prt.setString(2,language.getCode());
            prt.setLong(3,id);
            prt.executeUpdate();
        }catch (Exception e){
            throw e;
        }
    }


    public static void main(String[] args) {
        try {
            System.out.println(Database.getNewObject(8L));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
