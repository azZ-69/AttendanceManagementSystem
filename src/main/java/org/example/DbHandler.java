package org.example;

import org.example.models.ModelAttendance;
import org.example.models.ModelClass;
import org.example.models.ModelUser;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbHandler {

    //Table Names
    public static final String TABLE_USER = "user";
    public static final String TABLE_CLASS = "class";
    public static final String TABLE_ATTENDANCE = "attendance";

    //Column Names
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_ClassNAME = "classname";
    public static final String COLUMN_UserID = "userid";
    public static final String COLUMN_ClassID = "classid";



    public static Connection connect(){

        Connection connect = null;

        String url = "jdbc:sqlite:src/main/resources/database/.attenadacncemanagementDbdb";

        try {
            connect = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return connect;
    }
    public static int getUserIdFromUser(Connection connection, String username) {
        String query = "SELECT * FROM "+ TABLE_USER + " WHERE " + COLUMN_USERNAME + " = " + username;
        List<ModelUser> modelUser = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                int id = resultSet.getInt(COLUMN_ID);

                ModelUser modelUser1 = new ModelUser(id,"","");
                modelUser.add(modelUser1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return modelUser.get(0).getId();
    }
    public List<ModelClass> getAllClass(Connection conn,String classname){

        String query = "SELECT * FROM "+ TABLE_CLASS + " WHERE "+COLUMN_ClassNAME + " like %" + classname + "%";

        List<ModelClass> modelClass = new ArrayList<>();

        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                int id = resultSet.getInt(COLUMN_ID);
                String name = resultSet.getString(COLUMN_ClassNAME);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return modelClass;

    }

    public static void addUser(ModelUser modeUser, Connection connection){

        String sql = "INSERT INTO " + TABLE_USER + "("+ COLUMN_USERNAME + "," + COLUMN_PASSWORD  +") " +
                "VALUES(?,?)";

        try{
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, modeUser.getUsername());
            pstmt.setString(2, modeUser.getPassword());
            pstmt.executeUpdate();

            pstmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void addClass(ModelClass modelClass, Connection connection){

        String sql = "INSERT INTO " + TABLE_CLASS + "("+ COLUMN_ClassNAME  +") " +
                "VALUES(?)";

        try{
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, modelClass.getClassName());
            pstmt.executeUpdate();

            pstmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public static void addAttendance(ModelAttendance modelAttendance, Connection connection){

        String sql = "INSERT INTO " + TABLE_ATTENDANCE + "(" + COLUMN_UserID + COLUMN_ClassID + ")" + "VALUES (?,?)";


        try{
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, modelAttendance.getUserId());
            pstmt.setString(2, modelAttendance.getClassId());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }





}
