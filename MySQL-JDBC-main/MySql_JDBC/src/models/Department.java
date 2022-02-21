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
public class Department {
     private int departmentId;
     private String departmentName;
     private int departmentManager;
     private int departmentLocation;
     
     public Department(){
        
    }

    public Department(int departmentId, String departmentName, int departmentManager, int departmentLocation) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentManager = departmentManager;
        this.departmentLocation = departmentLocation;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public int getDepartmentManager() {
        return departmentManager;
    }

    public int getDepartmentLocation() {
        return departmentLocation;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setDepartmentManager(int departmentManager) {
        this.departmentManager = departmentManager;
    }

    public void setDepartmentLocation(int departmentLocation) {
        this.departmentLocation = departmentLocation;
    }

    
}
