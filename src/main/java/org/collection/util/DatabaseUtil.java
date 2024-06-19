package org.collection.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
    public static final String DB_NAME = "ExpenditureDB";
    public static final String USERNAME = "sa";
    public static final String PASSWORD = "123123qwe";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        return getConnection(DB_NAME, USERNAME, PASSWORD);
    }

    public static Connection getConnection(String dbName, String username, String password) throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String dbURL = "jdbc:sqlserver://localhost:1433;database=%s;username=%s;password=%s;encrypt=true;trustServerCertificate=true;";
        Connection conn = DriverManager.getConnection(String.format(dbURL, dbName, username, password));
        return conn;
    }
}
