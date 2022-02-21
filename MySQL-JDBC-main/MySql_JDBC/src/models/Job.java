/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;

/**
 *
 * @author Vino
 */
public class Job {
    private String id;
    private String tittle;
    private Double min_salary;
    private Double max_salary;
    
     public Job(){
         
     }

    public Job(String id, String tittle, Double min_salary, Double max_salary) {
        this.id = id;
        this.tittle = tittle;
        this.min_salary = min_salary;
        this.max_salary = max_salary;
    }

    public String getId() {
        return id;
    }

    public String getTittle() {
        return tittle;
    }

    public Double getMin_salary() {
        return min_salary;
    }

    public Double getMax_salary() {
        return max_salary;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public void setMin_salary(Double min_salary) {
        this.min_salary = min_salary;
    }

    public void setMax_salary(Double max_salary) {
        this.max_salary = max_salary;
    }

    @Override
    public String toString() {
        return "Job{" + "id=" + id + ", tittle=" + tittle + ", min_salary=" + min_salary + ", max_salary=" + max_salary + '}';
    }
     
}
