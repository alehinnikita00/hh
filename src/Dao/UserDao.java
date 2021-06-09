package Dao;

import Model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDao extends Dao{

    public UserDao(){}
    public void createUser(User user) throws Exception{
        Connection connection = super.getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate("insert into users values(" + user.getId() + ",'"+
                                user.getLogin() + "','" + user.getPassword() + "','"+
                                user.getFirst_name() + "', '" + user.getLast_name() + "','" + user.getIp() + "')");
        closeConnection(connection);
    }
    public User getById(int id) throws Exception{
        User user = null;
        Connection connection = super.getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from users where id = " + id);
        while (rs.next()){
            user = new User(id, rs.getString("login"), rs.getString("password"),
                    rs.getString("first_name"), rs.getString("last_name"), rs.getString("ip"));
        }
        connection.close();
        return user;
    }
    public User getByLoginPassword(String login, String password) throws Exception{
        User user = null;
        Connection connection = super.getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from users where login ='" + login + "' and password ='" + password + "'");
        while (rs.next()){
            user = new User(rs.getInt("id"), rs.getString("login"), rs.getString("password"),
                    rs.getString("first_name"), rs.getString("last_name"), rs.getString("ip"));
        }
        connection.close();
        return user;
    }

}
