package Dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dao {
    private String nameOfType;

    private Dao(String name){
        this.nameOfType = name;
    }

    public Dao() {
    }

/*
    public Connection getConnection() throws Exception{
        Connection connection = DriverManager.getConnection("jdbc:sqlserver://192.168.101.9:1433;databaseName=st2;user=Студент;password=1");
        return connection;
    }*/
    public Connection getConnection() throws Exception{
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/st2", "root", "");
        return connection;
    }
    public void closeConnection(Connection connection) throws Exception{
        connection.close();
    }
}
