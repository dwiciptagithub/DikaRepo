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
import models.Region;

/**
 *
 * @author DevidBa
 */
public class RegionDAO {

    private Connection connection;

    public RegionDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Region> getAll() {
        List<Region> regions = new ArrayList<>();
        String query = "SELECT * FROM REGION";
        try {
            ResultSet resultSet = connection
                    .prepareStatement(query)
                    .executeQuery();
            while (resultSet.next()) {
                Region region = new Region(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3));
                region.setRegionId(resultSet.getInt(1));
                region.setRegionName(resultSet.getString(2));
                region.setRegionCount(resultSet.getInt(3));
                regions.add(region);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return regions;
    }

    public boolean insert(Region region) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO REGION(id, name, count) VALUES(?,?,?)");
            preparedStatement.setInt(1, region.getRegionId());
            preparedStatement.setString(2, region.getRegionName());
            preparedStatement.setInt(3, region.getRegionCount());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public Region getById(int id){  
//        List<Region> regions = new ArrayList<>();
        String query = "SELECT * FROM REGION where id = ?";
            Region region = new Region();
         try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);      
            ResultSet rs = preparedStatement.executeQuery();            
            
             while (rs.next()) {
                 region.setRegionId(rs.getInt(1));
                 region.setRegionName(rs.getString(2));
                 
             }
        } catch (SQLException e) {
            e.printStackTrace();
        }   
        return region;
    }
    
    public boolean delete(int id){
        try{
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM region WHERE region.id =?");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }
    
    public boolean update(int id, Region region) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE REGION SET name=? WHERE id=?");
            preparedStatement.setString(1, region.getRegionName());
            preparedStatement.setInt(2, id);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
        Scanner scanner = new Scanner(System.in);
}
