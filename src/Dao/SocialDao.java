package Dao;

import Model.Insurance;
import Model.Social;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SocialDao extends Dao{
    public SocialDao() {
    }
    public void create(Social social) throws Exception{
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate("insert into socials values('" + social.getNumber() + "', '" +
                                    social.getType() + "','" + social.getInsurance().getInn() + "')");
        connection.close();

    }
    public Social getOneByNumber(String number) throws Exception{
        Social social = null;
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from socials where number = '" + number + "'");
        while (rs.next()){
            InsuranceDao insuranceDao = new InsuranceDao();
            Insurance insurance = insuranceDao.getByInn(rs.getString("insurance_inn"));
            social = new Social(number, rs.getString("type"), insurance);
        }
        connection.close();
        return social;
    }

}
