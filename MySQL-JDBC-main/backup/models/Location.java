/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Vino
 */
public class Location {
    private int id;
    private String street_address;
    private String postal_code;
    private String city;
    private String state_province;
    private String country;

    public Location(){
        
    }

    public Location(int id, String street_address, String postal_code, String city, String state_province, String country) {
        this.id = id;
        this.street_address = street_address;
        this.postal_code = postal_code;
        this.city = city;
        this.state_province = state_province;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public String getStreet_address() {
        return street_address;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public String getCity() {
        return city;
    }

    public String getState_province() {
        return state_province;
    }

    public String getCountry() {
        return country;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStreet_address(String street_address) {
        this.street_address = street_address;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState_province(String state_province) {
        this.state_province = state_province;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Location{" + "id=" + id + ", street_address=" + street_address + ", postal_code=" + postal_code + ", city=" + city + ", state_province=" + state_province + ", country=" + country + '}';
    }
    
}
