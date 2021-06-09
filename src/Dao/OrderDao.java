package Dao;

import Model.Order;

import java.sql.Connection;
import java.sql.Statement;

public class OrderDao extends Dao{
    public OrderDao(){}

    public void create(Order order) throws Exception{
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        System.out.println("insert into orders values("+ order.getId() + "," + order.getBlood().getId() + "," + order.getEmployee().getId() +
                "," + order.getService().getCode() + ",'" + order.getServiceStatus() + "'," + order.getStatus() + "," +
                order.getResult() + ",'" + order.getAnalyzer() + "')");
        statement.executeUpdate("insert into orders values("+ order.getId() + "," + order.getBlood().getId() + "," + order.getEmployee().getId() +
                "," + order.getService().getCode() + ",'" + order.getServiceStatus() + "'," + order.getStatus() + "," +
                order.getResult() + ",'" + order.getAnalyzer() + "')");

        connection.close();
    }

}
