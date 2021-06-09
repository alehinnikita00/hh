package Dao;

import Model.Employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao extends Dao{
    public EmployeeDao(){}

    public void create(Employee employee) throws Exception{
        Connection connection = super.getConnection();
        Statement statement = connection.createStatement();
        UserDao userDao = new UserDao();
        userDao.createUser(employee.getUser());
        statement.executeUpdate("insert into employees values(" + employee.getId() + ",'" +
                                employee.getLastEnter() + "','" + employee.getType() +"'," + employee.getUser().getId() + ")");
        if(employee.getServices() != null){
            for (int i = 0; i  < employee.getServices().stream().count(); i++){
                statement.executeUpdate("insert into employeeServices values(" + employee.getId() + ","
                        + employee.getServices().get(i).getCode()+ ")");
            }
        }
        connection.close();
    }
    public Employee getOneById(int id) throws Exception{
        Employee employee = null;
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from employees where id =" + id);

        UserDao userDao = new UserDao();
        while (rs.next()){
            employee = new Employee(id, rs.getString("type"), rs.getDate("lastEnter"), userDao.getById(rs.getInt("user_id")));
        }
        connection.close();
        return employee;
    }
    public List<Employee> getAllOrderLastEnter() throws Exception{
        List<Employee> employees = new ArrayList<>();
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from employees order by lastEnter");

        UserDao userDao = new UserDao();

        while (rs.next()){
            employees.add( new Employee(rs.getInt("id"), rs.getString("type"),
                    rs.getDate("lastEnter"), userDao.getById(rs.getInt("user_id"))));
        }
        connection.close();
        return employees;
    }
    public void update(Employee employee) throws Exception{
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate("update employees set lastEnter='" + employee.getLastEnter() + "' where id = " + employee.getId());
        connection.close();
    }
}
