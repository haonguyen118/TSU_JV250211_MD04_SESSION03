package utils;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static final String  Driver = "com.mysql.cj.jdbc.Driver";
    private static final String  Url = "jdbc:mysql://localhost:3306/md04_session03?createDatabaseIfNotExist=true";
    private static final String  User = "root";
    private static final String  Password = "Sanghao8488@";
     public static Connection getConnection() {
         Connection conn = null;
         try {
             Class.forName(Driver);
             conn = DriverManager.getConnection(Url, User, Password);

         }catch (Exception e){
             throw  new RuntimeException(e);
         }
         return conn;
     }
     public static void closeConnection(Connection conn, CallableStatement callSt) {
         if(conn != null) {
             try {
                 conn.close();
             } catch (SQLException e) {
                 e.printStackTrace();
             }
             if(callSt != null) {
                 try {
                     callSt.close();
                 } catch (SQLException e) {
                     e.printStackTrace();
                 }
             }
         }
     }
}
