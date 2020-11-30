package DB;

import java.sql.*;
import java.util.ArrayList;

public class DBManager {
    private static Connection connection;
    //jdbc:postgresql://host:port/database
    private static String url = "jdbc:postgresql://rogue.db.elephantsql.com:5432/mzacjute";
    private static String user = "mzacjute";
    private static String password = "jyiaqColPpzpTGisDKr7vjVtZQvonq0I";

    static {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static boolean addStudent(Student student){
        Boolean added = false;
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO student (name, surname, middlename, birthdate, iin, is_grant, specialty)" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)" +
                    "");
            statement.setString(1, student.getName());
            statement.setString(2, student.getSurname());
            statement.setString(3, student.getMiddleName());
            statement.setDate(4, (Date) student.getBirthdate());
            statement.setString(5, student.getIin());
            statement.setBoolean(6,  student.isGrant());
            statement.setString(7, student.getSpeciality());
            statement.executeUpdate();
            added = true;
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return added;
    }

    private static ArrayList<Student> addStudentsFromResultSetToArrayList(ResultSet resultSet){
        ArrayList<Student> students = new ArrayList<>();
        try {
            while (resultSet.next()){
                students.add(new Student(
                        resultSet.getLong("id_student"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("middlename"),
                        resultSet.getDate("birthdate"),
                        resultSet.getString("iin"),
                        resultSet.getBoolean("is_grant"),
                        resultSet.getString("specialty")
                ));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return students;
    }

    public static int sizeOfTable(){
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT count(*) FROM student");
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return resultSet.getInt("count");
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    public static int sizeOfFilteredStudents(String name, String surname, String iin, boolean isGrant){
        ResultSet resultSet;
        PreparedStatement statement;
        try{
            if(name != null && surname != null && iin != null){
                statement = connection.prepareStatement("" +
                        "SELECT count(*)" +
                        "FROM student "+
                        "WHERE name ~* ? AND surname ~* ? AND iin ~* ? AND is_grant = ? ");
                statement.setString(1, name);
                statement.setString(2, surname);
                statement.setString(3, iin);
                statement.setBoolean(4, isGrant);
            }else if(name != null && surname != null && iin == null){
                statement = connection.prepareStatement( "" +
                        "SELECT count(*)" +
                        "FROM student "+
                        "WHERE name ~* ? AND surname ~* ? AND is_grant = ? ");
                statement.setString(1, name);
                statement.setString(2, surname);
                statement.setBoolean(3, isGrant);
            }else if(name != null && surname == null && iin != null){
                statement = connection.prepareStatement("" +
                        "SELECT count(*) " +
                        "FROM student "+
                        "WHERE name ~* ? AND iin ~* ? AND is_grant = ? ");
                statement.setString(1, name);
                statement.setString(2, iin);
                statement.setBoolean(3, isGrant);
            }else if(name == null && surname != null && iin != null){
                statement = connection.prepareStatement("" +
                        "SELECT count(*) " +
                        "FROM student "+
                        "WHERE surname ~* ? AND iin ~* ? AND is_grant = ? ");
                statement.setString(1, surname);
                statement.setString(2, iin);
                statement.setBoolean(3, isGrant);
            }else if(name != null && surname == null && iin == null){
                statement = connection.prepareStatement("" +
                        "SELECT count(*) " +
                        "FROM student "+
                        "WHERE name ~* ? AND is_grant = ? ");
                statement.setString(1, name);
                statement.setBoolean(2, isGrant);
            }else if(name == null && surname == null && iin != null){
                statement = connection.prepareStatement("" +
                        "SELECT count(*) " +
                        "FROM student "+
                        "WHERE iin ~* ? AND is_grant = ? ");
                statement.setString(1, iin);
                statement.setBoolean(2, isGrant);
            }else if(name == null && surname != null && iin == null){
                statement = connection.prepareStatement("" +
                        "SELECT count(*) " +
                        "FROM student "+
                        "WHERE surname ~* ? AND is_grant = ? ");
                statement.setString(1, surname);
                statement.setBoolean(2, isGrant);
            }else{
                statement = connection.prepareStatement( "" +
                        "SELECT count(*)" +
                        "FROM student "+
                        "WHERE is_grant = ?");
                statement.setBoolean(1, isGrant);
            }
            resultSet = statement.executeQuery();
            resultSet.next();
            return resultSet.getInt("count");
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    public static ArrayList<Student> getAllStudents(int from, int limit){
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM student OFFSET " + from + " LIMIT " + limit);
            ResultSet resultSet = statement.executeQuery();
            return addStudentsFromResultSetToArrayList(resultSet);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ArrayList<Student>();
    }

    public static ArrayList<Student> findAllStudentsFilteredPaged(String name, String surname, String iin, boolean isGrant, int fromIndex, int size){
        ArrayList<Student> students = new ArrayList<>();
        ResultSet resultSet;
        PreparedStatement statement;
        try{

            statement = connection.prepareStatement("" +
                    "SELECT *" +
                    "FROM student "+
                    "WHERE name=? AND surname ~* ? AND iin ~* ? AND is_grant = ? " +
                    "OFFSET "+ fromIndex + " " +
                    "FETCH FIRST "+ size +" ROWS ONLY");
            statement.setString(1, name);
            statement.setString(2, surname);
            statement.setString(3, iin);
            statement.setBoolean(4, isGrant);

            if(name != null && surname != null && iin != null){
                statement = connection.prepareStatement("" +
                        "SELECT *" +
                        "FROM student "+
                        "WHERE name=? AND surname ~* ? AND iin ~* ? AND is_grant = ? " +
                        "OFFSET "+ fromIndex + " " +
                        "FETCH FIRST "+ size +" ROWS ONLY");
                statement.setString(1, name);
                statement.setString(2, surname);
                statement.setString(3, iin);
                statement.setBoolean(4, isGrant);
            }else if(name != null && surname != null && iin == null){
                statement = connection.prepareStatement( "" +
                        "SELECT *" +
                        "FROM student "+
                        "WHERE name ~* ? AND surname ~* ? AND is_grant = ? " +
                        "OFFSET "+ fromIndex + " " +
                        "FETCH FIRST "+ size +" ROWS ONLY");
                statement.setString(1, name);
                statement.setString(2, surname);
                statement.setBoolean(3, isGrant);
            }else if(name != null && surname == null && iin != null){
                statement = connection.prepareStatement("" +
                        "SELECT * " +
                        "FROM student "+
                        "WHERE name ~* ? AND iin ~* ? AND is_grant = ? " +
                        "OFFSET "+ fromIndex + " " +
                        "FETCH FIRST "+ size +" ROWS ONLY");
                statement.setString(1, name);
                statement.setString(2, iin);
                statement.setBoolean(3, isGrant);
            }else if(name == null && surname != null && iin != null){
                statement = connection.prepareStatement("" +
                        "SELECT * " +
                        "FROM student "+
                        "WHERE surname ~* ? AND iin ~* ? AND is_grant = ? " +
                        "OFFSET "+ fromIndex + " " +
                        "FETCH FIRST "+ size +" ROWS ONLY");
                statement.setString(1, surname);
                statement.setString(2, iin);
                statement.setBoolean(3, isGrant);
            }else if(name != null && surname == null && iin == null){
                statement = connection.prepareStatement("" +
                        "SELECT * " +
                        "FROM student "+
                        "WHERE name ~* ? AND is_grant = ? " +
                        "OFFSET "+ fromIndex + " " +
                        "FETCH FIRST "+ size +" ROWS ONLY");
                statement.setString(1, name);
                statement.setBoolean(2, isGrant);
            }else if(name == null && surname == null && iin != null){
                statement = connection.prepareStatement("" +
                        "SELECT * " +
                        "FROM student "+
                        "WHERE iin ~* ? AND is_grant = ? " +
                        "OFFSET "+ fromIndex + " " +
                        "FETCH FIRST "+ size +" ROWS ONLY");
                statement.setString(1, iin);
                statement.setBoolean(2, isGrant);
            }else if(name == null && surname != null && iin == null){
                statement = connection.prepareStatement("" +
                        "SELECT * " +
                        "FROM student "+
                        "WHERE surname ~* ? AND is_grant = ? " +
                        "OFFSET "+ fromIndex + " " +
                        "FETCH FIRST "+ size +" ROWS ONLY");
                statement.setString(1, surname);
                statement.setBoolean(2, isGrant);
            }else{
                statement = connection.prepareStatement( "" +
                        "SELECT * " +
                        "FROM student "+
                        "WHERE is_grant = ? " +
                        "OFFSET "+ fromIndex + " " +
                        "FETCH FIRST "+ size +" ROWS ONLY");
                statement.setBoolean(1, isGrant);
            }
            resultSet = statement.executeQuery();
            students = addStudentsFromResultSetToArrayList(resultSet);
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return students;
    }

    public static Student getStudent(Long id){
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM student " +
                    "WHERE id_student = ?");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return new Student(
                    resultSet.getLong("id_student"),
                    resultSet.getString("name"),
                    resultSet.getString("surname"),
                    resultSet.getString("middlename"),
                    resultSet.getDate("birthdate"),
                    resultSet.getString("iin"),
                    resultSet.getBoolean("is_grant"),
                    resultSet.getString("specialty")
            );
        }catch (Exception e){
            e.printStackTrace();
        }
        return new Student();
    }

    public static Boolean updateStudent(Student student){
        Boolean updated = false;
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "UPDATE student set " +
                    "name = ?, " +
                    "surname = ?, " +
                    "middlename = ?, " +
                    "birthdate = ?, " +
                    "iin = ?, " +
                    "is_grant = ?," +
                    "specialty = ?" +
                    "WHERE id_student = ?");
            statement.setString(1, student.getName());
            statement.setString(2, student.getSurname());
            statement.setString(3, student.getMiddleName());
            statement.setDate(4, (Date)student.getBirthdate());
            statement.setString(5, student.getIin());
            statement.setBoolean(6,  student.isGrant());
            statement.setString(7, student.getSpeciality());
            statement.setLong(8, student.getId());
            statement.executeUpdate();
            updated = true;
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return updated;
    }

    public static boolean deleteStudent(Long id){
        boolean deleted = false;
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "DELETE FROM student " +
                    "WHERE id_student = ?");
            statement.setLong(1, id);
            statement.executeUpdate();
            deleted = true;
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return deleted;
    }


}
