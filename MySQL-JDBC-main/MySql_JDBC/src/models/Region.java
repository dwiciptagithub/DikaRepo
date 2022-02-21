/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author DevidBa
 */
public class Region {
    private int regionId;
    private String regionName;
    private int regionCount;

    public Region() {
    }

    public Region(int regionId, String regionName, int regionCount) {
        this.regionId = regionId;
        this.regionName = regionName;
        this.regionCount = regionCount;
    }

    public int getRegionId() {
        return regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public int getRegionCount() {
        return regionCount;
    }

    public void setRegionCount(int regionCount) {
        this.regionCount = regionCount;
    }

    @Override
    public String toString() {
        return "Region{" + "regionId=" + regionId + ", regionName=" + regionName + ", regionCount=" + regionCount + '}';
    }

   

      
}