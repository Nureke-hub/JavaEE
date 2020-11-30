package DB.Managers;
import DB.Classes.Post;
import DB.Classes.User;

import java.sql.*;
import java.util.ArrayList;

public class DBManager {
    private static Connection connection;
    //jdbc:postgresql://host:port/database
    private static String url = "jdbc:postgresql://rogue.db.elephantsql.com:5432/hnatxoit";
    private static String user = "hnatxoit";
    private static String password = "X5SSAUuvcCrxqXhhnwX2Xe4dee72ZzDm";
    private static Statement statement;
    public static String photo ="https://www.timeshighereducation.com/sites/default/files/default_images/default-avatar_1.png";

    static {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static User returnUser(ResultSet resultSet){
        User user = null;
        try {
            if(resultSet.next()){
                user = new User(
                        resultSet.getLong("id"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("full_name"),
                        resultSet.getDate("birth_date"),
                        resultSet.getString("picture_url")
                );
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

    public static User getUser(String email){
        User user = null;
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM users WHERE email = ?");
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            user = returnUser(resultSet);
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

    public static User getUser(Long id){
        User user = new User();
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM users WHERE id = ?");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            user = returnUser(resultSet);
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }


    public static boolean addUser(User u){
        int col = 0;
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO users(email, password, full_name, birth_date, picture_url) " +
                    "VALUES (?, ?, ?, ?, ?)");
            statement.setString(1, u.getEmail());
            statement.setString(2, u.getPassword());
            statement.setString(3, u.getFull_name());
            statement.setDate(4, u.getBirth_date());
            statement.setString(5, u.getPicture_url());
            col = statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return col > 0;
    }

    public static void updateProfile(String email, String full_name, java.sql.Date date, Long id){
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "UPDATE users SET email = ?, full_name = ?, birth_date = ?  " +
                    "WHERE id = ?");
            statement.setString(1, email);
            statement.setString(2, full_name);
            statement.setDate(3, date);
            statement.setLong(4, id);
            System.out.println("HEEEEY ");
            statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void updateUrl(String url, Long id){
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "UPDATE users SET picture_url = ? " +
                    "WHERE id = ?");
            statement.setString(1, url);
            statement.setLong(2, id);
            System.out.println("HEEEEY ");
            statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void updatePassword(String password, Long id){
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "UPDATE users SET password = ? " +
                    "WHERE id = ?");
            statement.setString(1, password);
            statement.setLong(2, id);
            System.out.println("HEEEEY ");
            statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static boolean addPost(Post p){
        int line = 0;
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO posts(title, short_content, content, author_id) " +
                    "VALUES (?, ?, ?, ?)");
            statement.setString(1, p.getTitle());
            statement.setString(2, p.getShort_content());
            statement.setString(3, p.getContent());
            statement.setLong(4, p.getUser().getId());
            line = statement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return line > 0;
    }

    private static ArrayList<Post> returnPosts(ResultSet resultSet){
        ArrayList<Post> posts = new ArrayList<>();
        try {
            while (resultSet.next()){
                posts.add(new Post(
                        resultSet.getLong("id"),
                        resultSet.getString("title"),
                        resultSet.getString("short_content"),
                        resultSet.getString("content"),
                        resultSet.getDate("post_date"),
                        getUser(resultSet.getLong("author_id"))
                ));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return posts;
    }

    public static ArrayList<Post> getMyPosts(Long id){
        ArrayList<Post> posts = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM posts " +
                    "WHERE author_id = ? " +
                    "ORDER BY post_date DESC ");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            posts = returnPosts(resultSet);
        }catch (Exception e){
            e.printStackTrace();
        }
        return posts;
    }

    public static Post getPost(Long id){
        Post p = new Post();
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT p.id, p.title, p.short_content, p.content, p.post_date, p.author_id " +
                    "FROM posts p " +
                    "INNER JOIN users u ON u.id = p.author_id " +
                    "WHERE p.id = ?");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                p = new Post(
                    resultSet.getLong("id"),
                    resultSet.getString("title"),
                    resultSet.getString("short_content"),
                    resultSet.getString("content"),
                    resultSet.getDate("post_date"),
                    getUser(resultSet.getLong("author_id"))
                );
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return p;
    }

    public static void deletePost(Long id){
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "DELETE FROM posts p " +
                    "WHERE p.id = ?");
            statement.setLong(1 ,id);
            statement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void editPost(Long id, String title,String short_content, String content) {
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "UPDATE posts " +
                    "SET title = ?, short_content = ?, content = ? " +
                    "WHERE id = ?");
            statement.setString(1, title);
            statement.setString(2, short_content);
            statement.setString(3, content);
            statement.setLong(4, id);
            statement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static ArrayList<Post> getAllPosts(){
        ArrayList<Post> posts = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM posts " +
                    "ORDER BY post_date DESC ");
            ResultSet resultSet = statement.executeQuery();
            posts = returnPosts(resultSet);
        }catch (Exception e){
            e.printStackTrace();
        }
        return posts;
    }

    private static ArrayList<User> returnFriendUsers(ResultSet resultSet){
        ArrayList<User> users = new ArrayList<>();
        try {
            while (resultSet.next()){
                users.add(new User(
                        resultSet.getLong("id"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("full_name"),
                        resultSet.getDate("birth_date"),
                        resultSet.getString("picture_url")
                ));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return users;
    }

    public static ArrayList<User> getMyFriends(Long id){
        ArrayList<User> myFriends = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM users u " +
                    "INNER JOIN friends f ON u.id = f.friend_id "+
                    "WHERE f.user_id = ?"
            );

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            myFriends = returnFriendUsers(resultSet);
        }catch (Exception e){
            e.printStackTrace();
        }
        return myFriends;
    }

    public static ArrayList<User> getFriendRequests(Long id){
        ArrayList<User> friends_requests = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM users u " +
                    "INNER JOIN friends_requests fr ON u.id = fr.request_sender_id " +
                    "WHERE fr.user_id = ?"
            );

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            friends_requests = returnFriendUsers(resultSet);
        }catch (Exception e){
            e.printStackTrace();
        }
        return friends_requests;
    }

    public static void deleteFriend(Long user_id, Long friend_id){
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "DELETE FROM friends " +
                    "WHERE user_id = ? AND friend_id = ?");
            statement.setLong(1, user_id);
            statement.setLong(2, friend_id);
            statement.executeUpdate();

            statement.setLong(1, friend_id);
            statement.setLong(2, user_id);
            statement.executeUpdate();

            statement = connection.prepareStatement("" +
                    "INSERT INTO friends_requests(user_id, request_sender_id) " +
                    "VALUES (?, ?)");
            statement.setLong(1, user_id);
            statement.setLong(2, friend_id);
            System.out.println(statement.toString());
            statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void confirmFriendRequest(Long user_id, Long request_sender_id){
        try {
            PreparedStatement statement  = connection.prepareStatement("" +
                    "INSERT INTO friends(user_id, friend_id) " +
                    "VALUES (?, ?)"
            );
            statement.setLong(1, user_id);
            statement.setLong(2, request_sender_id);
            statement.executeUpdate();

            statement.setLong(1, request_sender_id);
            statement.setLong(2, user_id);
            statement.executeUpdate();

            statement = connection.prepareStatement("" +
                    "DELETE FROM friends_requests " +
                    "WHERE user_id = ? AND request_sender_id = ?");
            statement.setLong(1, user_id);
            statement.setLong(2, request_sender_id);
            statement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void rejectFriendRequest(Long user_id, Long request_sender_id){
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "DELETE FROM friends_requests " +
                    "WHERE user_id = ? AND request_sender_id = ?");
            statement.setLong(1, user_id);
            statement.setLong(2, request_sender_id);
            statement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static ArrayList<User> getFilterFriends(Long id, String search_text){
        ArrayList<User> users = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM users u " +
                    "INNER JOIN friends f ON u.id = f.friend_id "+
                    "WHERE u.full_name ~* ? AND f.user_id = ?"
            );
            statement.setString(1, search_text);
            statement.setLong(2, id);
            ResultSet resultSet = statement.executeQuery();
            users = returnFriendUsers(resultSet);
        }catch (Exception e){
            e.printStackTrace();
        }
        return users;
    }

    public static ArrayList<User> getMyRequests(Long id, String search_text){
        ArrayList<User> users = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM users u " +
                    "INNER JOIN friends_requests fr ON u.id = fr.user_id " +
                    "WHERE u.full_name ~* ? AND fr.request_sender_id = ?"
            );
            statement.setString(1, search_text);
            statement.setLong(2, id);
            ResultSet resultSet = statement.executeQuery();
            users = returnFriendUsers(resultSet);
        }catch (Exception e){
            e.printStackTrace();
        }
        return users;
    }

    public static ArrayList<User> getFilterFriendRequests(Long id, String search_text){
        ArrayList<User> users = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM users u " +
                    "INNER JOIN friends_requests fr ON u.id = fr.request_sender_id " +
                    "WHERE u.full_name ~* ? AND fr.user_id = ?"
            );
            statement.setString(1, search_text);
            statement.setLong(2, id);
            ResultSet resultSet = statement.executeQuery();
            users = returnFriendUsers(resultSet);
        }catch (Exception e){
            e.printStackTrace();
        }
        return users;
    }

    public static ArrayList<User> getAllUsers(String search_text){
        ArrayList<User> users = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM users u " +
                    "WHERE u.full_name ~* ?"
            );
            statement.setString(1, search_text);
            ResultSet resultSet = statement.executeQuery();
            users = returnFriendUsers(resultSet);
        }catch (Exception e ){
            e.printStackTrace();
        }
        return users;
    }

    public static void addToFriend(Long my_id, Long user_id){
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO friends_requests(user_id, request_sender_id) " +
                    "VALUES (?, ?)");
            statement.setLong(1, user_id);
            statement.setLong(2, my_id);
            statement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void deleteMyRequest(Long my_id, Long user_id){
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "DELETE FROM friends_requests " +
                    "WHERE user_id = ? AND request_sender_id = ?");
            statement.setLong(1, user_id);
            statement.setLong(2, my_id);
            statement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static ArrayList<User> getUsersByBirthDate(Long id){
        ArrayList<User> users = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM users " +
                    "WHERE id != ? " +
                    "ORDER BY birth_date ASC");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            users = returnFriendUsers(resultSet);
        }catch (Exception e){
            e.printStackTrace();
        }
        return users;
    }

}
