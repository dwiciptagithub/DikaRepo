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
import models.Country;
import models.Location;

/**
 *
 * @author Vino
 */
public class LocationDAO {
    private Connection connection;
    
    public LocationDAO (Connection connection){
        this.connection = connection;
    }
    public List<Location> getAll() {
        List<Location> locations = new ArrayList<>();
        String query = "SELECT * FROM LOCATION";
        try {
            ResultSet resultSet = connection
                    .prepareStatement(query)
                    .executeQuery();
            while (resultSet.next()) {
                Location location = new Location(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6));
                location.setId(resultSet.getInt(1));
                location.setStreet_address(resultSet.getString(2));
                location.setPostal_code(resultSet.getString(3));
                location.setCity(resultSet.getString(4));
                location.setState_province(resultSet.getString(5));
                location.setCountry(resultSet.getString(6));
                locations.add(location);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return locations;
    }

    public boolean insert(Location location) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO LOCATION(id, street_address, postal_code, city, state_province, country) VALUES(?,?,?,?,?,?)");
            preparedStatement.setInt(1, location.getId());
            preparedStatement.setString(2, location.getStreet_address());
            preparedStatement.setString(3, location.getPostal_code());
            preparedStatement.setString(4, location.getCity());
            preparedStatement.setString(5, location.getState_province());
            preparedStatement.setString(6, location.getCountry());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public Location getById(int id){  
        String query = "SELECT * FROM LOCATION where id = ?";
            Location location = new Location();
         try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);      
            ResultSet rs = preparedStatement.executeQuery();            
            
             while (rs.next()) {
                 location.setId(rs.getInt(1));
                 location.setStreet_address(rs.getString(2));  
                 location.setPostal_code(rs.getString(3));  
                 location.setCity(rs.getString(4));  
                 location.setState_province(rs.getString(5));  
                 location.setCountry(rs.getString(6));  
             }
        } catch (SQLException e) {
            e.printStackTrace();
        }   
        return location;
    }
    
    public boolean delete(int id){
        try{
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM LOCATION WHERE location.id =?");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }
    
    public boolean update(int id, Location location) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE LOCATION SET street_address=?, postal_code=?, city=?, state_province=?, country=? WHERE id=?");
            preparedStatement.setString(1, location.getStreet_address());
            preparedStatement.setString(2, location.getPostal_code());
            preparedStatement.setString(3, location.getCity());
            preparedStatement.setString(4, location.getState_province());
            preparedStatement.setString(5, location.getCountry());
            preparedStatement.setInt(6, id);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
        Scanner scanner = new Scanner(System.in);
}
