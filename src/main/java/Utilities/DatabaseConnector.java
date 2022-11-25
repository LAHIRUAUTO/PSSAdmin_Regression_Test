package Utilities;

import java.io.FileNotFoundException;
import java.sql.*;

public class DatabaseConnector extends GenericUtils {


    static String dbUrl = FileReaderManager.getInstance().getConfigReader().getDBUrl();
    static String dbUsername = FileReaderManager.getInstance().getConfigReader().getDBUsername();
    static String dbPassword = FileReaderManager.getInstance().getConfigReader().getDBPassword();
    static Connection dbConnection;

    static {
        try {
            dbConnection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    static Statement runSQL;

    static {
        try {
            runSQL = dbConnection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }





}
