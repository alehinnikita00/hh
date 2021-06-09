package Dao;

import Model.Patient;
import Model.Social;
import Model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class PatientDao extends Dao{
    public PatientDao() {
    }
    public void create(Patient patient) throws Exception{
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate("insert into patients values('" + patient.getGuid() +"','" + patient.getEin() + "','"+
                patient.getPass_series() + "','" + patient.getPass_number() + "','" + patient.getSocial().getNumber() + "','"
        + patient.getEmail() + "','" + patient.getPhone() + "',null,'" + patient.getUa() + "'," + patient.getUser().getId() + ")");
        connection.close();
    }
    public Patient getByUserId(int id) throws Exception{
        Patient patient = null;
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        UserDao userDao = new UserDao();
        User user = userDao.getById(id);
        SocialDao socialDao = new SocialDao();
        ResultSet rs = statement.executeQuery("select * from patients where user_id ="+ user.getId());
        while (rs.next()){
            patient = new Patient(rs.getString("guid"), user, socialDao.getOneByNumber(rs.getString("social")),
                    rs.getString("ein"), rs.getString("pass_s"), rs.getString("pass_n"),
                    rs.getString("email"), rs.getString("phone"), rs.getString("ua"));
        }
        connection.close();
        return patient;
    }
    public Patient getByUserGuid(String guid) throws Exception{
        Patient patient = null;
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        UserDao userDao = new UserDao();
        SocialDao socialDao = new SocialDao();
        ResultSet rs = statement.executeQuery("select * from patients where guid ='"+guid+"'");
        while (rs.next()){
            User user = userDao.getById(rs.getInt("user_id"));
            patient = new Patient(guid, user, socialDao.getOneByNumber(rs.getString("social")),
                    rs.getString("ein"), rs.getString("pass_s"), rs.getString("pass_n"),
                    rs.getString("email"), rs.getString("phone"), rs.getString("ua"));
        }
        connection.close();
        return patient;
    }
}
