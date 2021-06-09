package Dao;

import Model.Blood;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class BloodDao extends Dao{
    public BloodDao(){

    }
    public void create (Blood blood) throws Exception{
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate("insert into bloods values("+ blood.getId() + ", '" + blood.getPatient().getGuid() +
                "', '" + blood.getbarcode() + "','" + blood.getDate() + "')");
        connection.close();
    }
    public Blood getOneById(int id) throws Exception{
        Blood blood = null;
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from bloods where id =" + id);
        PatientDao patientDao = new PatientDao();
        while (rs.next()){
            blood = new Blood(id, patientDao.getByUserGuid(rs.getString("patient")), rs.getString("barcode"),
                                rs.getDate("date"));
        }
        connection.close();
        return blood;
    }


}
