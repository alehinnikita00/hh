package Dao;

import Model.Insurance;
import Model.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class InsuranceDao extends Dao{
    public InsuranceDao(){

    }
    public void create(Insurance insurance) throws Exception{
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate("insert into insurances values('" + insurance.getInn() +
                "','"+insurance.getName() + "','" + insurance.getBik() + "','" +
                insurance.getRs() + "','" + insurance.getCountry() + "','" + insurance.getAddress() + "')");
        closeConnection(connection);
    }
    public Insurance getByInn(String inn) throws Exception{
        Insurance insurance = null;
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from insurances where inn = '" + inn + "'");
        while (rs.next()){
            insurance = new Insurance(rs.getString("inn"), rs.getString("name"), rs.getString("bik"),
                    rs.getString("ps"), rs.getString("country"), rs.getString("address"));
        }
        connection.close();
        return insurance;
    }
}
