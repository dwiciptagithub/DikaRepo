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

/**
 *
 * @author Vino
 */
public class CountryDAO {
    private Connection connection;
    
    public CountryDAO (Connection connection){
        this.connection = connection;
    }
    
    public List<Country> getAll() {
        List<Country> countrys = new ArrayList<>();
        String query = "SELECT * FROM COUNTRY";
        try {
            ResultSet resultSet = connection
                    .prepareStatement(query)
                    .executeQuery();
            while (resultSet.next()) {
                Country country = new Country(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3));
                country.setCountryId(resultSet.getString(1));
                country.setCountryName(resultSet.getString(2));
                country.setCountryRegion(resultSet.getInt(3));
                countrys.add(country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countrys;
    }

    public boolean insert(Country country) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO COUNTRY(id, name, region) VALUES(?,?,?)");
            preparedStatement.setString(1, country.getCountryId());
            preparedStatement.setString(2, country.getCountryName());
            preparedStatement.setInt(3, country.getCountryRegion());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public Country getById(String id){  
        String query = "SELECT * FROM COUNTRY where id = ?";
            Country country = new Country();
         try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);      
            ResultSet rs = preparedStatement.executeQuery();            
            
             while (rs.next()) {
                 country.setCountryId(rs.getString(1));
                 country.setCountryName(rs.getString(2));
                 country.setCountryRegion(rs.getInt(3));  
             }
        } catch (SQLException e) {
            e.printStackTrace();
        }   
        return country;
    }
    
    public boolean delete(String id){
        try{
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM COUNTRY WHERE country.id =?");
        preparedStatement.setString(1, id);
        preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }
    
    public boolean update(String id, Country country) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE COUNTRY SET name=?, region=? WHERE id=?");
            preparedStatement.setString(1, country.getCountryName());
            preparedStatement.setInt(2, country.getCountryRegion());
            preparedStatement.setString(3, id);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
        Scanner scanner = new Scanner(System.in);
}
