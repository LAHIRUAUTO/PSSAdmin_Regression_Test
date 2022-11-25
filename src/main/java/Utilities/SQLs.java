package Utilities;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLs {

    DatabaseConnector databaseConnector;
    public SQLs () {
        databaseConnector =new DatabaseConnector();
    }

    public String getuserName () throws SQLException {
        String query = "select * from t_user where user_id = 19687";
        ResultSet queryResult = DatabaseConnector.runSQL.executeQuery(query);
        queryResult.next();
        String userName = queryResult.getString("login_name");
        System.out.println(queryResult.getString("login_name"));
        return userName;
    }
}
