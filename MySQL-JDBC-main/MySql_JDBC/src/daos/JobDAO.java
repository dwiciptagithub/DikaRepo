/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import models.Job;

/**
 *
 * @author Vino
 */
public class JobDAO {
    private Connection connection;
    
    public JobDAO (Connection connection){
        this.connection = connection;
    }
    
    public List<Job> getAll() {
        List<Job> jobs = new ArrayList<>();
        String query = "SELECT * FROM JOB";
        try {
            ResultSet resultSet = connection
                    .prepareStatement(query)
                    .executeQuery();
            while (resultSet.next()) {
                Job job = new Job(resultSet.getString(1), resultSet.getString(2), resultSet.getDouble(3), resultSet.getDouble(4));
                job.setId(resultSet.getString(1));
                job.setTittle(resultSet.getString(2));
                job.setMin_salary(resultSet.getDouble(3));
                job.setMax_salary(resultSet.getDouble(4));
                jobs.add(job);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jobs;
    }

    public boolean insert(Job job) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO JOB(id, title, min_salary, max_salary) VALUES(?,?,?,?)");
            preparedStatement.setString(1, job.getId());
            preparedStatement.setString(2, job.getTittle());
            preparedStatement.setDouble(3, job.getMin_salary());
            preparedStatement.setDouble(4, job.getMax_salary());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public Job getById(String id){  
        String query = "SELECT * FROM JOB where id = ?";
            Job job = new Job();
         try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);      
            ResultSet rs = preparedStatement.executeQuery();            
            
             while (rs.next()) {
                job.setId(rs.getString(1));
                job.setTittle(rs.getString(2));
                job.setMin_salary(rs.getDouble(3));
                job.setMax_salary(rs.getDouble(4));
                  
             }
        } catch (SQLException e) {
            e.printStackTrace();
        }   
        return job;
    }
    
    public boolean delete(String id){
        try{
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM JOB WHERE job.id =?");
        preparedStatement.setString(1, id);
        preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }
    
    public boolean update(String id, Job job) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE JOB SET title=?, min_salary=?, max_salary=? WHERE id=?");
            preparedStatement.setString(1, job.getTittle());
            preparedStatement.setDouble(2, job.getMin_salary());
            preparedStatement.setDouble(3, job.getMax_salary());
            preparedStatement.setString(4, id);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
        Scanner scanner = new Scanner(System.in);
}
