package Wheels;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static final String url = "jdbc:sqlite:rentals.db";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(url);
    }
}
