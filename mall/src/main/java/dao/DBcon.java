package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBcon {
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mariadb://localhost:3306/mall", "root", "1234");
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
