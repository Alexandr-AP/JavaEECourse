package by.internetbanking.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcMysqlUtil {

    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/new_ferma";
    public static final String JDBC_USER = "root";
    public static final String JDBC_PASSWORD = "root";

    private Connection connection = null;
    private Statement statement = null;

    public boolean checkMysqlJdbcDriver() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public Connection getConnection() {
        if (connection == null) {
            if (!checkMysqlJdbcDriver()) {
                return null;
            }
            try {
                connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return connection;
    }

    public Statement getStatement() {
        if (statement == null) {
            try {
                statement = getConnection().createStatement();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return statement;
    }

    public void closeStatement() {
        try {
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void closeStatementAndConnection() {
        closeStatement();
        closeConnection();
    }
}
