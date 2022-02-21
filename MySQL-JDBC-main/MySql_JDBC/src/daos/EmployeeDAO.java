/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import models.Employee;

/**
 *
 * @author Vino
 */
public class EmployeeDAO {
     private Connection connection;
    
    public EmployeeDAO (Connection connection){
        this.connection = connection;
    }
    
    public List<Employee> getAll() {
        List<Employee> employees = new ArrayList<>();
        String query = "SELECT * FROM EMPLOYEE";
        try {
            ResultSet resultSet = connection
                    .prepareStatement(query)
                    .executeQuery();
            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getInt(1));
                employee.setFirst_name(resultSet.getString(2));
                employee.setLast_name(resultSet.getString(3));
                employee.setEmail(resultSet.getString(4));
                employee.setPhone_number(resultSet.getString(5));
                employee.setHire_date(resultSet.getString(6));
                employee.setJob(resultSet.getString(7));
                employee.setSalary(resultSet.getDouble(8));
                employee.setCommission_pct(resultSet.getDouble(9));
                employee.setManager(resultSet.getInt(10));
                employee.setDepartment(resultSet.getInt(11));
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    
    public boolean insert(Employee employee) {
        try {
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            Date str = employee.getHire_date();
//            
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO EMPLOYEE(id, first_name, last_name, email, phone_number, hire_date, job, salary, comission_pct, manager, department) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            preparedStatement.setInt(1, employee.getId());
            preparedStatement.setString(2, employee.getFirst_name());
            preparedStatement.setString(3, employee.getLast_name());
            preparedStatement.setString(4, employee.getEmail());
            preparedStatement.setString(5, employee.getPhone_number());
            preparedStatement.setString(6, employee.getHire_date());
            preparedStatement.setString(7, employee.getJob());
            preparedStatement.setDouble(8, employee.getSalary());
            preparedStatement.setDouble(9, employee.getCommission_pct());
            preparedStatement.setInt(10, employee.getManager());
            preparedStatement.setInt(11, employee.getDepartment());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public Employee getById(int id){  
//        List<Region> regions = new ArrayList<>();
        String query = "SELECT * FROM EMPLOYEE where id = ?";
            Employee employee = new Employee();
         try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);      
            ResultSet rs = preparedStatement.executeQuery();            
            
             while (rs.next()) {
                 employee.setId(rs.getInt(1));
                 employee.setFirst_name(rs.getString(2));
                 employee.setLast_name(rs.getString(3));
                 employee.setEmail(rs.getString(4));
                 employee.setPhone_number(rs.getString(5));
                 employee.setHire_date(rs.getString(6));
                 employee.setJob(rs.getString(7));
                 employee.setSalary(rs.getDouble(8));
                 employee.setCommission_pct(rs.getDouble(9));
                 employee.setManager(rs.getInt(10));
                 employee.setDepartment(rs.getInt(11));
                 
             }
        } catch (SQLException e) {
            e.printStackTrace();
        }   
        return employee;
    }
    
    public boolean delete(int id){
        try{
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM employee WHERE employee.id =?");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }
    
    public boolean update(int id, Employee employee) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE EMPLOYEE SET first_name=?, last_name=?, email=?, phone_number=?, hire_date=?, job=?, salary=?, comission_pct=?, manager=?, department=? WHERE id=?");
            preparedStatement.setString(1, employee.getFirst_name());
            preparedStatement.setString(2, employee.getLast_name());
            preparedStatement.setString(3, employee.getEmail());
            preparedStatement.setString(4, employee.getPhone_number());
            preparedStatement.setString(5, employee.getHire_date());
            preparedStatement.setString(6, employee.getJob());
            preparedStatement.setDouble(7, employee.getSalary());
            preparedStatement.setDouble(8, employee.getCommission_pct());
            preparedStatement.setInt(9, employee.getManager());
            preparedStatement.setInt(10, employee.getDepartment());
            preparedStatement.setInt(11, id);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
        Scanner scanner = new Scanner(System.in);
}
