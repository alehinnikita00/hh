package Dao;

import Model.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ServiceDao extends Dao{

    public ServiceDao(){
    }
    public void create(Service service) throws Exception{
        Connection connection = super.getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate("insert into services values ("+
                                    service.getCode() + ", '" + service.getName() + "'," +
                (float) service.getCost() + ", 1,  1)");
        super.closeConnection(connection);
    }
    public List<Service> getAll() throws Exception{
        List<Service> services = new ArrayList<>();

        Connection connection = super.getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from services");
        while (rs.next()){
            Service service = new Service(rs.getInt("code"), rs.getString("name")
                                          ,rs.getFloat("cost"));
            services.add(service);
        }
        super.closeConnection(connection);
        return services;
    }
    public void Update(Service service) throws Exception{
        Connection connection = super.getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate("update services set name = " + service.getName()
                                + ", cost = " + service.getCost() + " where code == " + service.getCost());
        super.closeConnection(connection);
    }
    public Service getByCode(int code) throws Exception{
        Service service = new Service();
        Connection connection = super.getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from services where code =" + code);
        while (rs.next()){
            service = new Service(rs.getInt("code"), rs.getString("name")
                    ,rs.getFloat("cost"));
        }
        connection.close();
        return service;
    }

}
