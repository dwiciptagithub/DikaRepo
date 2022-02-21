/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import daos.CountryDAO;
import daos.DepartmentDAO;
import daos.EmployeeDAO;
import daos.JobDAO;
import daos.LocationDAO;
import daos.RegionDAO;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import models.Country;
import models.Department;
import models.Employee;
import models.Job;
import models.Location;
import models.Region;

/**
 *
 * @author DevidBa
 */
public class Test {

    public static void main(String[] args) {
        DbConnection connection = new DbConnection();
        RegionDAO rdao = new RegionDAO(connection.getConncetion());
        CountryDAO cdao = new CountryDAO(connection.getConncetion());
        LocationDAO ldao = new LocationDAO(connection.getConncetion());
        DepartmentDAO ddao = new DepartmentDAO(connection.getConncetion());
        EmployeeDAO edao = new EmployeeDAO(connection.getConncetion());
        JobDAO jdao = new JobDAO(connection.getConncetion());
        System.out.println("===========PILIH TABEL==============");
        System.out.println("1.Region\n" +
                "2.Country\n" +
                "3.Location\n" +
                "4.Departement\n" +
                "5.Job\n" +
                "6.Employee");
        System.out.println("=====================================");
        Scanner input = new Scanner(System.in);
        System.out.println("Masukan No Tabel yang dipilih : ");
        int inputan = input.nextInt();
        
        switch(inputan){
            case 1 : {
                System.out.println("========TABEL REGION=========");
                 System.out.println("1.Show Data\n" +
                "2.Insert\n" +
                "3.Update\n" +
                "4.Delete");
        System.out.println("=====================================");
        Scanner input2 = new Scanner(System.in);
        System.out.println("Masukan pilihan : ");    
        int inputan2 = input2.nextInt();
        
        //Region
            switch(inputan2){
                case 1 : {
                    for (Region region : rdao.getAll()){
                        System.out.println("Id:"+ region.getRegionId() + "Nama:" + region.getRegionName()
                                + "Count:" + region.getRegionCount());
                        }
                    System.out.println("========TABEL REGION=========");
                 System.out.println("1.Show Data\n" +
                                    "2.Insert\n" +
                                    "3.Update\n" +
                                    "4.Delete");
                 System.out.println("=====================================");
                    Scanner input3 = new Scanner(System.in);
                    System.out.println("Masukan pilihan : ");    
                    int inputan3 = input3.nextInt();
                        switch (inputan3){
                            case 1 : {
                                 for (Region region : rdao.getAll()){
                                 System.out.println("Id:"+ region.getRegionId() 
                                 + "Nama:" + region.getRegionName()
                                 + "Count:" + region.getRegionCount());
                                 System.out.println("=====================================");
                                 } break;
                          } case 2 : {
                              Scanner inputId = new Scanner(System.in);
                              Scanner inputName = new Scanner(System.in);
                              Scanner inputCount = new Scanner(System.in);
                              System.out.println("Masukan id = ");
                              int id = inputId.nextInt();
                              System.out.println("Masukan name = ");
                              String name  = inputName.nextLine();
                              boolean valid=false;
                              while(valid==false){        
                              if (!name.matches("[a-zA-Z_]+")) {
                                    System.out.println("Invalid name");
                                    System.out.println("Masukan name = ");
                                    inputName.nextLine();
                                }
                              else
                                  valid=true;
                                  break;
                              }
                              System.out.println("Masukan count = ");
                              int count = inputCount.nextInt();
                              Region region = new Region(id, name, count);
                              
                              boolean cek = rdao.insert(region);
                              
                              if (cek){
                                  System.out.println("Data berhasil Tersimpan");
                                  System.out.println("=======================");
                                  for (Region regions : rdao.getAll()){
                                 System.out.println("Id:"+ regions.getRegionId() 
                                 + "Nama:" + regions.getRegionName()
                                 + "Count:" + regions.getRegionCount());
                                 System.out.println("=====================================");
                                 }
                            } break;
                          } case 3 : {
                              Scanner inputid = new Scanner(System.in);
                              Scanner inputname = new Scanner(System.in);
                              Scanner inputcount = new Scanner(System.in);
                              System.out.println("Masukan id yang akan diupdate: ");
                              int id = inputid.nextInt();
                              
                              Region r = rdao.getById(id);
                              System.out.println("==============================");
                              System.out.println("Data sebelum diupdate:");
                              System.out.println("Id:" +r.getRegionId() + "Nama:" + r.getRegionName());
                              System.out.println("==============================");
                              System.out.println("Masukan name baru: ");
                              String name = inputname.nextLine();
                              Region region = new Region(id, name, 0);
                              boolean cek = rdao.update(id, region);
                              
                              if (cek){
                                  System.out.println("Data berhasil Diperbarui");
                                  System.out.println("=======================");
                                  for (Region regions : rdao.getAll()){
                                 System.out.println("Id:"+ regions.getRegionId() 
                                 + "Nama:" + regions.getRegionName()
                                 + "Count:" + regions.getRegionCount());
                                 System.out.println("=====================================");
                                 }
                            } break;
                          } case 4 : {
                            System.out.println("Masukan id yang akan dihapus:");
                            Scanner inputid = new Scanner(System.in);
                            int id = inputid.nextInt();
                            boolean cek = rdao.delete(id);
                            
                            if (cek){
                                  System.out.println("Data berhasil Dihapus");
                                  System.out.println("=======================");
                                  for (Region regions : rdao.getAll()){
                                 System.out.println("Id:"+ regions.getRegionId() 
                                 + "Nama:" + regions.getRegionName()
                                 + "Count:" + regions.getRegionCount());
                                 System.out.println("=====================================");
                                 }
                            } break;
                          }
                        } break;
                } case 2 : {
                    Scanner inputId = new Scanner(System.in);
                              Scanner inputName = new Scanner(System.in);
                              Scanner inputCount = new Scanner(System.in);
                              System.out.println("Masukan id = ");
                              int id = inputId.nextInt();
                              System.out.println("Masukan name = ");
                              String name  = inputName.nextLine();
                              boolean valid=false;
                              while(valid==false){        
                              if (!name.matches("[a-zA-Z_]+")) {
                                    System.out.println("Invalid name");
                                    System.out.println("Masukan name = ");
                                    inputName.nextLine();
                                }
                              else
                                  valid=true;
                                  break;
                              }
                              System.out.println("Masukan count = ");
                              int count = inputCount.nextInt();
                              Region region = new Region(id, name, count);
                              
                              boolean cek = rdao.insert(region);
                              
                              if (cek){
                                  System.out.println("Data berhasil Tersimpan");
                                  System.out.println("=======================");
                                  for (Region regions : rdao.getAll()){
                                 System.out.println("Id:"+ region.getRegionId() 
                                 + "Nama:" + regions.getRegionName()
                                 + "Count:" + regions.getRegionCount());
                                 System.out.println("=====================================");
                                 }
                            } break;    
                } case 3 : {
                     for (Region region : rdao.getAll()){
                        System.out.println("Id:"+ region.getRegionId() + "Nama:" + region.getRegionName()
                                + "Count:" + region.getRegionCount());
                        }
                        Scanner inputid = new Scanner(System.in);
                              Scanner inputname = new Scanner(System.in);
                              Scanner inputcount = new Scanner(System.in);
                              System.out.println("Masukan id yang akan diupdate: ");
                              int id = inputid.nextInt();
                              
                              Region r = rdao.getById(id);
                              System.out.println("==========================");
                              System.out.println("Data sebelum diupdate:");
                              System.out.println("Id:" +r.getRegionId() + "Nama:" + r.getRegionName());
                              System.out.println("==========================");
                              System.out.println("Masukan name baru: ");
                              String name = inputname.nextLine();
                              Region region = new Region(id, name, 0);
                              boolean cek = rdao.update(id, region);
                              
                              if (cek){
                                  System.out.println("Data berhasil Diperbarui");
                                  System.out.println("=======================");
                                  for (Region regions : rdao.getAll()){
                                 System.out.println("Id:"+ regions.getRegionId() 
                                 + "Nama:" + regions.getRegionName()
                                 + "Count:" + regions.getRegionCount());
                                 System.out.println("=====================================");
                                 }
                            } break;
                } case 4 : {
                     for (Region region : rdao.getAll()){
                        System.out.println("Id:"+ region.getRegionId() + "Nama:" + region.getRegionName()
                                + "Count:" + region.getRegionCount());
                        }
                     System.out.println("Masukan id yang akan dihapus:");
                            Scanner inputid = new Scanner(System.in);
                            int id = inputid.nextInt();
                            boolean cek = rdao.delete(id);
                            
                            if (cek){
                                  System.out.println("Data berhasil Dihapus");
                                  System.out.println("=======================");
                                  for (Region regions : rdao.getAll()){
                                 System.out.println("Id:"+ regions.getRegionId() 
                                 + "Nama:" + regions.getRegionName()
                                 + "Count:" + regions.getRegionCount());
                                 System.out.println("=====================================");
                                 }
                            } break;
                     
                }
                    
                }
            }
            
            //Country
            case 2 : {
                System.out.println("========TABEL COUNTRY=========");
                 System.out.println("1.Show Data\n" +
                "2.Insert\n" +
                "3.Update\n" +
                "4.Delete");
                System.out.println("=====================================");
                Scanner input2 = new Scanner(System.in);
                System.out.println("Masukan pilihan : ");    
                int inputan2 = input2.nextInt();
                
                switch(inputan2){
                case 1 : {
                    for (Country country : cdao.getAll()){
                        System.out.println("Id:"+ country.getCountryId()+ "Nama:" + country.getCountryName()
                                + "Region:" + country.getCountryRegion());
                        }
                    System.out.println("========TABEL REGION=========");
                 System.out.println("1.Show Data\n" +
                                    "2.Insert\n" +
                                    "3.Update\n" +
                                    "4.Delete");
                 System.out.println("=====================================");
                    Scanner input3 = new Scanner(System.in);
                    System.out.println("Masukan pilihan : ");    
                    int inputan3 = input3.nextInt();
                        switch (inputan3){
                            case 1 : {
                                 for (Country country : cdao.getAll()){
                                 System.out.println("Id:"+ country.getCountryId()
                                 + "Nama:" + country.getCountryName()
                                 + "Region:" + country.getCountryRegion());
                                 System.out.println("=====================================");
                                 } break;
                          } case 2 : {
                              Scanner inputId = new Scanner(System.in);
                              Scanner inputName = new Scanner(System.in);
                              Scanner inputRegion = new Scanner(System.in);
                              System.out.println("Masukan id = ");
                              String id = inputId.nextLine();
                              boolean valid=false;
                              while(valid==false){        
                              if (!id.matches("[0-9]*")) {
                                    System.out.println("Invalid id! Id harus berupa angka");
                                    System.out.println("Masukan Id = ");
                                    inputId.nextLine();
                                }
                              else
                                  valid=true;
                                  break;
                              }
                              System.out.println("Masukan name = ");
                              String name  = inputName.nextLine();
                              System.out.println("Masukan region = ");
                              int region = inputRegion.nextInt();
                              Country country = new Country(id, name, region);
                              
                              boolean cek = cdao.insert(country);
                              
                              if (cek){
                                  System.out.println("Data berhasil Tersimpan");
                                  System.out.println("=======================");
                                  for (Country countrys : cdao.getAll()){
                                 System.out.println("Id:"+ countrys.getCountryId()
                                 + "Nama:" + countrys.getCountryName()
                                 + "Region:" + countrys.getCountryRegion());
                                 System.out.println("=====================================");
                                 }
                            } break;
                          } case 3 : {
                              Scanner inputid = new Scanner(System.in);
                              Scanner inputname = new Scanner(System.in);
                              Scanner inputregion = new Scanner(System.in);
                              System.out.println("Masukan id yang akan diupdate: ");
                              String id = inputid.nextLine();
                              
                              Country c = cdao.getById(id);
                              System.out.println("==============================");
                              System.out.println("Data sebelum diupdate:");
                              System.out.println("Id:" +c.getCountryId()+ "Nama:" + c.getCountryName() + "Region:" + c.getCountryRegion());
                              System.out.println("==============================");
                              System.out.println("Masukan name baru: ");
                              String name = inputname.nextLine();
                              System.out.println("Masukan region baru: ");
                              int region = inputregion.nextInt();
                              Country country = new Country(id, name, region);
                              boolean cek = cdao.update(id, country);
                              
                            if (cek){
                                  System.out.println("Data berhasil Diperbarui");
                                  System.out.println("=======================");
                                  for (Country countrys : cdao.getAll()){
                                 System.out.println("Id:"+ countrys.getCountryId()
                                 + "Nama:" + countrys.getCountryName()
                                 + "Region:" + countrys.getCountryRegion());
                                 System.out.println("=====================================");
                                 }
                            } break;
                          } case 4 : {
                            System.out.println("Masukan id yang akan dihapus:");
                            Scanner inputid = new Scanner(System.in);
                            String id = inputid.nextLine();
                            boolean cek = cdao.delete(id);
                            
                            if (cek){
                                  System.out.println("Data berhasil Dihapus");
                                  System.out.println("=======================");
                                  for (Country countrys : cdao.getAll()){
                                 System.out.println("Id:"+ countrys.getCountryId()
                                 + "Nama:" + countrys.getCountryName()
                                 + "Region:" + countrys.getCountryRegion());
                                 System.out.println("=====================================");
                                 }
                            } break;
                          }
                        } break;
                } case 2 : {
                    Scanner inputId = new Scanner(System.in);
                              Scanner inputName = new Scanner(System.in);
                              Scanner inputRegion = new Scanner(System.in);
                              System.out.println("Masukan id = ");
                              String id = inputId.nextLine();
                              boolean valid=false;
                              while(valid==false){        
                              if (!id.matches("[0-9]*")) {
                                    System.out.println("Invalid id! Id harus berupa angka");
                                    System.out.println("Masukan Id = ");
                                    inputId.nextLine();
                                }
                              else
                                  valid=true;
                                  break;
                              }
                              System.out.println("Masukan name = ");
                              String name  = inputName.nextLine();
                              System.out.println("Masukan region = ");
                              int region = inputRegion.nextInt();
                              Country country = new Country(id, name, region);
                              
                              boolean cek = cdao.insert(country);
                              
                              if (cek){
                                  System.out.println("Data berhasil Tersimpan");
                                  System.out.println("=======================");
                                  for (Country countrys : cdao.getAll()){
                                 System.out.println("Id:"+ countrys.getCountryId()
                                 + "Nama:" + countrys.getCountryName()
                                 + "Region:" + countrys.getCountryRegion());
                                 System.out.println("=====================================");
                                 }
                            } break;    
                } case 3 : {
                     Scanner inputid = new Scanner(System.in);
                              Scanner inputname = new Scanner(System.in);
                              Scanner inputregion = new Scanner(System.in);
                              System.out.println("Masukan id yang akan diupdate: ");
                              String id = inputid.nextLine();
                              
                              Country c = cdao.getById(id);
                              System.out.println("==============================");
                              System.out.println("Data sebelum diupdate:");
                              System.out.println("Id:" +c.getCountryId()+ "Nama:" + c.getCountryName() + "Region:" + c.getCountryRegion());
                              System.out.println("==============================");
                              System.out.println("Masukan name baru: ");
                              String name = inputname.nextLine();
                              System.out.println("Masukan region baru: ");
                              int region = inputregion.nextInt();
                              Country country = new Country(id, name, region);
                              boolean cek = cdao.update(id, country);
                              
                            if (cek){
                                  System.out.println("Data berhasil Diperbarui");
                                  System.out.println("=======================");
                                  for (Country countrys : cdao.getAll()){
                                 System.out.println("Id:"+ countrys.getCountryId()
                                 + "Nama:" + countrys.getCountryName()
                                 + "Region:" + countrys.getCountryRegion());
                                 System.out.println("=====================================");
                                 }
                            } break;
                } case 4 : {
                     
                     System.out.println("Masukan id yang akan dihapus:");
                            Scanner inputid = new Scanner(System.in);
                            String id = inputid.nextLine();
                            boolean cek = cdao.delete(id);
                            
                            if (cek){
                                  System.out.println("Data berhasil Dihapus");
                                  System.out.println("=======================");
                                  for (Country countrys : cdao.getAll()){
                                 System.out.println("Id:"+ countrys.getCountryId()
                                 + "Nama:" + countrys.getCountryName()
                                 + "Region:" + countrys.getCountryRegion());
                                 System.out.println("=====================================");
                                 }
                            } break;
                    }    
                }
            } 
            
            //Location
              case 3 : {
                System.out.println("========TABEL LOCATION=========");
                 System.out.println("1.Show Data\n" +
                "2.Insert\n" +
                "3.Update\n" +
                "4.Delete");
                System.out.println("=====================================");
                Scanner input2 = new Scanner(System.in);
                System.out.println("Masukan pilihan : ");    
                int inputan2 = input2.nextInt();
                
                switch(inputan2){
                case 1 : {
                    for (Location location : ldao.getAll()){
                        System.out.println("Id:"+ location.getId()+ "Street Address:" + location.getStreet_address()
                                + "Postal Code:" + location.getPostal_code()
                                + "City:" + location.getCity()
                                + "State Province:" + location.getState_province()
                                + "Country" + location.getCountry());
                        }
                 System.out.println("========TABEL LOCATION=========");
                 System.out.println("1.Show Data\n" +
                                    "2.Insert\n" +
                                    "3.Update\n" +
                                    "4.Delete");
                 System.out.println("=====================================");
                    Scanner input3 = new Scanner(System.in);
                    System.out.println("Masukan pilihan : ");    
                    int inputan3 = input3.nextInt();
                        switch (inputan3){
                            case 1 : {
                                 for (Location location : ldao.getAll()){
                                System.out.println("Id:"+ location.getId()+ "Street Address:" + location.getStreet_address()
                                + "Postal Code:" + location.getPostal_code()
                                + "City:" + location.getCity()
                                + "State Province:" + location.getState_province()
                                + "Country" + location.getCountry());
                                } break;
                          } case 2 : {
                              Scanner inputId = new Scanner(System.in);
                              Scanner inputStreetAddress = new Scanner(System.in);
                              Scanner inputPostalCode = new Scanner(System.in);
                              Scanner inputCity = new Scanner(System.in);
                              Scanner inputStateProvince = new Scanner(System.in);
                              Scanner inputCountry = new Scanner(System.in);
                              System.out.println("Masukan id = ");
                              int id = inputId.nextInt();
                              System.out.println("Masukan Alamat = ");
                              String street  = inputStreetAddress.nextLine();
                              System.out.println("Masukan Kode Pos = ");
                              String postal = inputPostalCode.nextLine();
                              System.out.println("Masukan Kota = ");
                              String city = inputCity.nextLine();
                              System.out.println("Masukan Provinsi Negara= ");
                              String state = inputStateProvince.nextLine();
                              System.out.println("Masukan Negara= ");
                              String country = inputCountry.nextLine();
                              Location location = new Location(id, street, postal, city, state, country);
                              
                              boolean cek = ldao.insert(location);
                              
                              if (cek){
                                  System.out.println("Data berhasil Tersimpan");
                                  System.out.println("=======================");
                                 for (Location locations : ldao.getAll()){
                                System.out.println("Id:"+ locations.getId()+ "Street Address:" + locations.getStreet_address()
                                + "Postal Code:" + locations.getPostal_code()
                                + "City:" + locations.getCity()
                                + "State Province:" + locations.getState_province()
                                + "Country" + locations.getCountry());
                                }
                            } break;
                          } case 3 : {
                              Scanner inputId = new Scanner(System.in);
                              Scanner inputStreetAddress = new Scanner(System.in);
                              Scanner inputPostalCode = new Scanner(System.in);
                              Scanner inputCity = new Scanner(System.in);
                              Scanner inputStateProvince = new Scanner(System.in);
                              Scanner inputCountry = new Scanner(System.in);
                              System.out.println("Masukan id yang akan diupdate: ");
                              int id = inputId.nextInt();
                              
                              Location l = ldao.getById(id);
                              System.out.println("==============================");
                              System.out.println("Data sebelum diupdate:");
                              System.out.println("Id" + l.getId() + "Alamat" + l.getStreet_address()
                                                + "Kode Pos" + l.getPostal_code()
                                                + "Kota:" + l.getCity()
                                                + "Provinsi Negara" + l.getState_province()
                                                + "Negara" + l.getCountry());
                              System.out.println("==============================");
                              System.out.println("Masukan Alamat baru: ");
                              String address = inputStreetAddress.nextLine();
                              System.out.println("Masukan Kode Pos baru baru: ");
                              String postal = inputPostalCode.nextLine();
                              System.out.println("Masukan Kota baru baru: ");
                              String city = inputCity.nextLine();
                              System.out.println("Masukan Provinsi Pos baru baru: ");
                              String state = inputStateProvince.nextLine();
                              System.out.println("Masukan Negara baru: ");
                              String country = inputCountry.nextLine();
                              Location location = new Location(id, address, postal, city, state, country);
                              boolean cek = ldao.update(id, location);
                              
                            if (cek){
                                  System.out.println("Data berhasil Diperbarui");
                                  System.out.println("=======================");
                                 for (Location locations : ldao.getAll()){
                                System.out.println("Id:"+ locations.getId()+ "Street Address:" + locations.getStreet_address()
                                + "Postal Code:" + locations.getPostal_code()
                                + "City:" + locations.getCity()
                                + "State Province:" + locations.getState_province()
                                + "Country" + locations.getCountry());
                                }
                            } break;
                          } case 4 : {
                            System.out.println("Masukan id yang akan dihapus:");
                            Scanner inputid = new Scanner(System.in);
                            int id = inputid.nextInt();
                            boolean cek = ldao.delete(id);
                            
                            if (cek){
                                  System.out.println("Data berhasil Dihapus");
                                  System.out.println("=======================");
                                  for (Location locations : ldao.getAll()){
                                System.out.println("Id:"+ locations.getId()+ "Street Address:" + locations.getStreet_address()
                                + "Postal Code:" + locations.getPostal_code()
                                + "City:" + locations.getCity()
                                + "State Province:" + locations.getState_province()
                                + "Country" + locations.getCountry());
                                }
                            } break;
                          }
                        } break;
                } case 2 : {
                    Scanner inputId = new Scanner(System.in);
                              Scanner inputStreetAddress = new Scanner(System.in);
                              Scanner inputPostalCode = new Scanner(System.in);
                              Scanner inputCity = new Scanner(System.in);
                              Scanner inputStateProvince = new Scanner(System.in);
                              Scanner inputCountry = new Scanner(System.in);
                              System.out.println("Masukan id = ");
                              int id = inputId.nextInt();
                              System.out.println("Masukan Alamat = ");
                              String street  = inputStreetAddress.nextLine();
                              System.out.println("Masukan Kode Pos = ");
                              String postal = inputPostalCode.nextLine();
                              System.out.println("Masukan Kota = ");
                              String city = inputCity.nextLine();
                              System.out.println("Masukan Provinsi Negara= ");
                              String state = inputStateProvince.nextLine();
                              System.out.println("Masukan Negara= ");
                              String country = inputCountry.nextLine();
                              Location location = new Location(id, street, postal, city, state, country);
                              
                              boolean cek = ldao.insert(location);
                              
                              if (cek){
                                  System.out.println("Data berhasil Tersimpan");
                                  System.out.println("=======================");
                                 for (Location locations : ldao.getAll()){
                                System.out.println("Id:"+ locations.getId()+ "Street Address:" + locations.getStreet_address()
                                + "Postal Code:" + locations.getPostal_code()
                                + "City:" + locations.getCity()
                                + "State Province:" + locations.getState_province()
                                + "Country" + locations.getCountry());
                                }
                            } break;    
                } case 3 : {
                     Scanner inputId = new Scanner(System.in);
                              Scanner inputStreetAddress = new Scanner(System.in);
                              Scanner inputPostalCode = new Scanner(System.in);
                              Scanner inputCity = new Scanner(System.in);
                              Scanner inputStateProvince = new Scanner(System.in);
                              Scanner inputCountry = new Scanner(System.in);
                              System.out.println("Masukan id yang akan diupdate: ");
                              int id = inputId.nextInt();
                              
                              Location l = ldao.getById(id);
                              System.out.println("==============================");
                              System.out.println("Data sebelum diupdate:");
                              System.out.println("Id" + l.getId() + "Alamat" + l.getStreet_address()
                                                + "Kode Pos" + l.getPostal_code()
                                                + "Kota:" + l.getCity()
                                                + "Provinsi Negara" + l.getState_province()
                                                + "Negara" + l.getCountry());
                              System.out.println("==============================");
                              System.out.println("Masukan Alamat baru: ");
                              String address = inputStreetAddress.nextLine();
                              System.out.println("Masukan Kode Pos baru baru: ");
                              String postal = inputPostalCode.nextLine();
                              System.out.println("Masukan Kota baru baru: ");
                              String city = inputCity.nextLine();
                              System.out.println("Masukan Provinsi Pos baru baru: ");
                              String state = inputStateProvince.nextLine();
                              System.out.println("Masukan Negara baru: ");
                              String country = inputCountry.nextLine();
                              Location location = new Location(id, address, postal, city, state, country);
                              boolean cek = ldao.update(id, location);
                              
                            if (cek){
                                  System.out.println("Data berhasil Diperbarui");
                                  System.out.println("=======================");
                                 for (Location locations : ldao.getAll()){
                                System.out.println("Id:"+ locations.getId()+ "Street Address:" + locations.getStreet_address()
                                + "Postal Code:" + locations.getPostal_code()
                                + "City:" + locations.getCity()
                                + "State Province:" + locations.getState_province()
                                + "Country" + locations.getCountry());
                                }
                            } break;
                } case 4 : {
                     
                     System.out.println("Masukan id yang akan dihapus:");
                            Scanner inputid = new Scanner(System.in);
                            int id = inputid.nextInt();
                            boolean cek = ldao.delete(id);
                            
                            if (cek){
                                  System.out.println("Data berhasil Dihapus");
                                  System.out.println("=======================");
                                  for (Location locations : ldao.getAll()){
                                System.out.println("Id:"+ locations.getId()+ "Street Address:" + locations.getStreet_address()
                                + "Postal Code:" + locations.getPostal_code()
                                + "City:" + locations.getCity()
                                + "State Province:" + locations.getState_province()
                                + "Country" + locations.getCountry());
                                }
                            } break;
                    }    
                }
            } 
              //DEPARTMENT
              case 4 : {
                System.out.println("========TABEL DEPARTMENT=========");
                 System.out.println("1.Show Data\n" +
                "2.Insert\n" +
                "3.Update\n" +
                "4.Delete");
                System.out.println("=====================================");
                Scanner input2 = new Scanner(System.in);
                System.out.println("Masukan pilihan : ");    
                int inputan2 = input2.nextInt();
                
                switch(inputan2){
                case 1 : {
                    for (Department department : ddao.getAll()){
                        System.out.println("Id:"+ department.getDepartmentId()+ "name:" + department.getDepartmentName()
                                + "Manager:" + department.getDepartmentManager()
                                + "Location:" + department.getDepartmentLocation());
                        }
                 System.out.println("========TABEL DEPARTMENT=========");
                 System.out.println("1.Show Data\n" +
                                    "2.Insert\n" +
                                    "3.Update\n" +
                                    "4.Delete");
                 System.out.println("=====================================");
                    Scanner input3 = new Scanner(System.in);
                    System.out.println("Masukan pilihan : ");    
                    int inputan3 = input3.nextInt();
                        switch (inputan3){
                            case 1 : {
                                 for (Department department : ddao.getAll()){
                                System.out.println("Id:"+ department.getDepartmentId()+ "Name:" + department.getDepartmentName()
                                + "Manager:" + department.getDepartmentManager()
                                + "Location:" + department.getDepartmentLocation());
                                } break;
                          } case 2 : {
                              Scanner inputId = new Scanner(System.in);
                              Scanner inputName = new Scanner(System.in);
                              Scanner inputManager = new Scanner(System.in);
                              Scanner inputLocation = new Scanner(System.in);
                              System.out.println("Masukan id = ");
                              int id = inputId.nextInt();
                              System.out.println("Masukan Nama = ");
                              String name  = inputName.nextLine();
                              boolean valid=false;
                              while(valid==false){        
                              if (!name.matches("[a-zA-Z_]+")) {
                                    System.out.println("Invalid name, nama tidak boleh angka!");
                                    System.out.println("Masukan nama = ");
                                    inputName.nextLine();
                                }
                              else
                                  valid=true;
                                  break;
                              }
                              System.out.println("Masukan Manajer = ");
                              int manager = inputManager.nextInt();
                              System.out.println("Masukan Lokasi = ");
                              int location = inputLocation.nextInt();
                              Department department = new Department(id, name, manager, location);
                              
                              boolean cek = ddao.insert(department);
                              
                              if (cek){
                                  System.out.println("Data berhasil Tersimpan");
                                  System.out.println("=======================");
                                  for (Department departments : ddao.getAll()){
                                System.out.println("Id:"+ departments.getDepartmentId()+ "Name:" + departments.getDepartmentName()
                                + "Manager:" + departments.getDepartmentManager()
                                + "Location:" + departments.getDepartmentLocation());
                                }
                            } break;
                          } case 3 : {
                              Scanner inputId = new Scanner(System.in);
                              Scanner inputName = new Scanner(System.in);
                              Scanner inputManager = new Scanner(System.in);
                              Scanner inputLocation = new Scanner(System.in);
                              System.out.println("Masukan id yang akan diupdate: ");
                              int id = inputId.nextInt();
                              
                              Department d = ddao.getById(id);
                              System.out.println("==============================");
                              System.out.println("Data sebelum diupdate:");
                              System.out.println("Id" + d.getDepartmentId()+ "Nama" + d.getDepartmentName()
                                                + "Manajer" + d.getDepartmentManager()
                                                + "Lokasi:" + d.getDepartmentLocation());
                              System.out.println("==============================");
                              System.out.println("Masukan Nama baru: ");
                              String name = inputName.nextLine();
                              System.out.println("Masukan manajer baru: ");
                              int manager = inputManager.nextInt();
                              System.out.println("Masukan lokasi baru: ");
                              int location = inputLocation.nextInt();
                              Department department = new Department(id, name, manager, location);
                              boolean cek = ddao.update(id, department);
                              
                            if (cek){
                                  System.out.println("Data berhasil Diperbarui");
                                  System.out.println("=======================");
                                 for (Department departments : ddao.getAll()){
                                System.out.println("Id:"+ departments.getDepartmentId()+ "Name:" + departments.getDepartmentName()
                                + "Manager:" + departments.getDepartmentManager()
                                + "Location:" + departments.getDepartmentLocation());
                                }
                            } break;
                          } case 4 : {
                            System.out.println("Masukan id yang akan dihapus:");
                            Scanner inputid = new Scanner(System.in);
                            int id = inputid.nextInt();
                            boolean cek = ddao.delete(id);
                            
                            if (cek){
                                  System.out.println("Data berhasil Dihapus");
                                  System.out.println("=======================");
                                  for (Department departments : ddao.getAll()){
                                System.out.println("Id:"+ departments.getDepartmentId()+ "Name:" + departments.getDepartmentName()
                                + "Manager:" + departments.getDepartmentManager()
                                + "Location:" + departments.getDepartmentLocation());
                                }
                            } break;
                          }
                        } break;
                } case 2 : {
                    Scanner inputId = new Scanner(System.in);
                              Scanner inputName = new Scanner(System.in);
                              Scanner inputManager = new Scanner(System.in);
                              Scanner inputLocation = new Scanner(System.in);
                              System.out.println("Masukan id = ");
                              int id = inputId.nextInt();
                              System.out.println("Masukan Nama = ");
                              String name  = inputName.nextLine();
                               boolean valid=false;
                              while(valid==false){        
                              if (!name.matches("[a-zA-Z_]+")) {
                                    System.out.println("Invalid name, nama tidak boleh angka!");
                                    System.out.println("Masukan nama = ");
                                    inputName.nextLine();
                                }
                              else
                                  valid=true;
                                  break;
                              }
                              System.out.println("Masukan Manajer = ");
                              int manager = inputManager.nextInt();
                              System.out.println("Masukan Lokasi = ");
                              int location = inputLocation.nextInt();
                              Department department = new Department(id, name, manager, location);
                              
                              boolean cek = ddao.insert(department);
                              
                              if (cek){
                                  System.out.println("Data berhasil Tersimpan");
                                  System.out.println("=======================");
                                  for (Department departments : ddao.getAll()){
                                System.out.println("Id:"+ departments.getDepartmentId()+ "Name:" + departments.getDepartmentName()
                                + "Manager:" + departments.getDepartmentManager()
                                + "Location:" + departments.getDepartmentLocation());
                                }
                            } break;    
                } case 3 : {
                     Scanner inputId = new Scanner(System.in);
                              Scanner inputName = new Scanner(System.in);
                              Scanner inputManager = new Scanner(System.in);
                              Scanner inputLocation = new Scanner(System.in);
                              System.out.println("Masukan id yang akan diupdate: ");
                              int id = inputId.nextInt();
                              
                              Department d = ddao.getById(id);
                              System.out.println("==============================");
                              System.out.println("Data sebelum diupdate:");
                              System.out.println("Id" + d.getDepartmentId()+ "Nama" + d.getDepartmentName()
                                                + "Manajer" + d.getDepartmentManager()
                                                + "Lokasi:" + d.getDepartmentLocation());
                              System.out.println("==============================");
                              System.out.println("Masukan Nama baru: ");
                              String name = inputName.nextLine();
                              System.out.println("Masukan manajer baru: ");
                              int manager = inputManager.nextInt();
                              System.out.println("Masukan lokasi baru: ");
                              int location = inputLocation.nextInt();
                              Department department = new Department(id, name, manager, location);
                              boolean cek = ddao.update(id, department);
                              
                            if (cek){
                                  System.out.println("Data berhasil Diperbarui");
                                  System.out.println("=======================");
                                 for (Department departments : ddao.getAll()){
                                System.out.println("Id:"+ departments.getDepartmentId()+ "Name:" + departments.getDepartmentName()
                                + "Manager:" + departments.getDepartmentManager()
                                + "Location:" + departments.getDepartmentLocation());
                                }
                            } break;
                } case 4 : {
                     
                     System.out.println("Masukan id yang akan dihapus:");
                            Scanner inputid = new Scanner(System.in);
                            int id = inputid.nextInt();
                            boolean cek = ddao.delete(id);
                            
                            if (cek){
                                  System.out.println("Data berhasil Dihapus");
                                  System.out.println("=======================");
                                  for (Department departments : ddao.getAll()){
                                System.out.println("Id:"+ departments.getDepartmentId()+ "Name:" + departments.getDepartmentName()
                                + "Manager:" + departments.getDepartmentManager()
                                + "Location:" + departments.getDepartmentLocation());
                                }
                            } break;
                    }    
                }
            }
              
              //JOB
              case 5 : {
                System.out.println("========TABEL JOB=========");
                 System.out.println("1.Show Data\n" +
                "2.Insert\n" +
                "3.Update\n" +
                "4.Delete");
                System.out.println("=====================================");
                Scanner input2 = new Scanner(System.in);
                System.out.println("Masukan pilihan : ");    
                int inputan2 = input2.nextInt();
                
                switch(inputan2){
                case 1 : {
                    for (Job job : jdao.getAll()){
                        System.out.println("Id:"+ job.getId()+ "Tittle:" + job.getTittle()
                                + "Min salary:" + job.getMin_salary()
                                + "Max salary:" + job.getMax_salary());
                        }
                 System.out.println("========TABEL JOB=========");
                 System.out.println("1.Show Data\n" +
                                    "2.Insert\n" +
                                    "3.Update\n" +
                                    "4.Delete");
                 System.out.println("=====================================");
                    Scanner input3 = new Scanner(System.in);
                    System.out.println("Masukan pilihan : ");    
                    int inputan3 = input3.nextInt();
                        switch (inputan3){
                            case 1 : {
                                for (Job job : jdao.getAll()){
                                System.out.println("Id:"+ job.getId()+ "Tittle:" + job.getTittle()
                                + "Min salary:" + job.getMin_salary()
                                + "Max salary:" + job.getMax_salary());
                                } break;
                          } case 2 : {
                              Scanner inputId = new Scanner(System.in);
                              Scanner inputTittle = new Scanner(System.in);
                              Scanner inputMin = new Scanner(System.in);
                              Scanner inputMax = new Scanner(System.in);
                              System.out.println("Masukan id = ");
                              String id = inputId.nextLine();
                              boolean valid=false;
                              while(valid==false){        
                              if (!id.matches("[a-zA-Z_]+")) {
                                    System.out.println("Invalid id, id tidak boleh angka!");
                                    System.out.println("Masukan id = ");
                                    inputId.nextLine();
                                }
                              else
                                  valid=true;
                                  break;
                              }
                              System.out.println("Masukan Tittle = ");
                              String tittle  = inputTittle.nextLine();
                              System.out.println("Masukan Min salary = ");
                              double min = inputMin.nextDouble();
                              System.out.println("Masukan Max salary = ");
                              double max = inputMax.nextDouble();
                              Job job = new Job(id, tittle, min, max);
                              
                              boolean cek = jdao.insert(job);
                              
                              if (cek){
                                  System.out.println("Data berhasil Tersimpan");
                                  System.out.println("=======================");
                                  for (Job jobs : jdao.getAll()){
                                  System.out.println("Id:"+ jobs.getId()+ "Tittle:" + jobs.getTittle()
                                                    + "Min salary:" + jobs.getMin_salary()
                                                    + "Max salary:" + jobs.getMax_salary());
                                        }
                                  } break;
                          } case 3 : {
                              Scanner inputId = new Scanner(System.in);
                              Scanner inputTittle = new Scanner(System.in);
                              Scanner inputMin = new Scanner(System.in);
                              Scanner inputMax = new Scanner(System.in);
                              System.out.println("Masukan id yang akan diupdate: ");
                              String id = inputId.nextLine();
                              
                              Job j = jdao.getById(id);
                              System.out.println("==============================");
                              System.out.println("Data sebelum diupdate:");
                              System.out.println("Id" + j.getId()+ "Tittle" + j.getTittle()
                                                + "Min salary" + j.getMin_salary()
                                                + "Max salary:" + j.getMax_salary());
                              System.out.println("==============================");
                              System.out.println("Masukan Tittle baru: ");
                              String tittle = inputTittle.nextLine();
                              System.out.println("Masukan Min salary baru: ");
                              double min = inputMin.nextDouble();
                              System.out.println("Masukan Max salary baru: ");
                              double max = inputMax.nextDouble();
                              Job job = new Job(id, tittle, min, max);
                              boolean cek = jdao.update(id, job);
                              
                            if (cek){
                                  System.out.println("Data berhasil Diperbarui");
                                  System.out.println("=======================");
                                 for (Job jobs : jdao.getAll()){
                                  System.out.println("Id:"+ jobs.getId()+ "Tittle:" + jobs.getTittle()
                                                    + "Min salary:" + jobs.getMin_salary()
                                                    + "Max salary:" + jobs.getMax_salary());
                                        }
                            } break;
                          } case 4 : {
                            System.out.println("Masukan id yang akan dihapus:");
                            Scanner inputid = new Scanner(System.in);
                            String id = inputid.nextLine();
                            boolean cek = jdao.delete(id);
                            
                            if (cek){
                                  System.out.println("Data berhasil Dihapus");
                                  System.out.println("=======================");
                                  for (Job jobs : jdao.getAll()){
                                  System.out.println("Id:"+ jobs.getId()+ "Tittle:" + jobs.getTittle()
                                                    + "Min salary:" + jobs.getMin_salary()
                                                    + "Max salary:" + jobs.getMax_salary());
                                        }
                            } break;
                          }
                        } break;
                } case 2 : {
                    Scanner inputId = new Scanner(System.in);
                              Scanner inputTittle = new Scanner(System.in);
                              Scanner inputMin = new Scanner(System.in);
                              Scanner inputMax = new Scanner(System.in);
                              System.out.println("Masukan id = ");
                              String id = inputId.nextLine();
                              boolean valid=false;
                              while(valid==false){        
                              if (!id.matches("[a-zA-Z_]+")) {
                                    System.out.println("Invalid id, id tidak boleh angka!");
                                    System.out.println("Masukan id = ");
                                    inputId.nextLine();
                                }
                              else
                                  valid=true;
                                  break;
                              }
                              System.out.println("Masukan Tittle = ");
                              String tittle  = inputTittle.nextLine();
                              System.out.println("Masukan Min salary = ");
                              double min = inputMin.nextDouble();
                              System.out.println("Masukan Max salary = ");
                              double max = inputMax.nextDouble();
                              Job job = new Job(id, tittle, min, max);
                              
                              boolean cek = jdao.insert(job);
                              
                              if (cek){
                                  System.out.println("Data berhasil Tersimpan");
                                  System.out.println("=======================");
                                  for (Job jobs : jdao.getAll()){
                                  System.out.println("Id:"+ jobs.getId()+ "Tittle:" + jobs.getTittle()
                                                    + "Min salary:" + jobs.getMin_salary()
                                                    + "Max salary:" + jobs.getMax_salary());
                                        }
                                  } break;    
                } case 3 : {
                     Scanner inputId = new Scanner(System.in);
                              Scanner inputTittle = new Scanner(System.in);
                              Scanner inputMin = new Scanner(System.in);
                              Scanner inputMax = new Scanner(System.in);
                              System.out.println("Masukan id yang akan diupdate: ");
                              String id = inputId.nextLine();
                              
                              Job j = jdao.getById(id);
                              System.out.println("==============================");
                              System.out.println("Data sebelum diupdate:");
                              System.out.println("Id" + j.getId()+ "Tittle" + j.getTittle()
                                                + "Min salary" + j.getMin_salary()
                                                + "Max salary:" + j.getMax_salary());
                              System.out.println("==============================");
                              System.out.println("Masukan Tittle baru: ");
                              String tittle = inputTittle.nextLine();
                              System.out.println("Masukan Min salary baru: ");
                              double min = inputMin.nextDouble();
                              System.out.println("Masukan Max salary baru: ");
                              double max = inputMax.nextDouble();
                              Job job = new Job(id, tittle, min, max);
                              boolean cek = jdao.update(id, job);
                              
                            if (cek){
                                  System.out.println("Data berhasil Diperbarui");
                                  System.out.println("=======================");
                                 for (Job jobs : jdao.getAll()){
                                  System.out.println("Id:"+ jobs.getId()+ "Tittle:" + jobs.getTittle()
                                                    + "Min salary:" + jobs.getMin_salary()
                                                    + "Max salary:" + jobs.getMax_salary());
                                        }
                            } break;
                } case 4 : {
                     
                     System.out.println("Masukan id yang akan dihapus:");
                            Scanner inputid = new Scanner(System.in);
                            String id = inputid.nextLine();
                            boolean cek = jdao.delete(id);
                            
                            if (cek){
                                  System.out.println("Data berhasil Dihapus");
                                  System.out.println("=======================");
                                  for (Job jobs : jdao.getAll()){
                                  System.out.println("Id:"+ jobs.getId()+ "Tittle:" + jobs.getTittle()
                                                    + "Min salary:" + jobs.getMin_salary()
                                                    + "Max salary:" + jobs.getMax_salary());
                                        }
                            } break;
                    }    
                }
            } 
              //EMPLOYEE
              case 6 : {
                System.out.println("========TABEL EMPLOYEE=========");
                 System.out.println("1.Show Data\n" +
                "2.Insert\n" +
                "3.Update\n" +
                "4.Delete");
                System.out.println("=====================================");
                Scanner input2 = new Scanner(System.in);
                System.out.println("Masukan pilihan : ");    
                int inputan2 = input2.nextInt();
                
                switch(inputan2){
                case 1 : {
                    for (Employee employee : edao.getAll()){
                        System.out.println("Id:"+ employee.getId()+ "First name:" + employee.getFirst_name()
                                + "Last name:" + employee.getLast_name()
                                + "email:" + employee.getEmail()
                                + "phone number:" + employee.getPhone_number()
                                + "hire date:" + employee.getHire_date()
                                + "job:" + employee.getJob()
                                + "salary:" + employee.getSalary()
                                + "comission pct:" + employee.getCommission_pct()
                                + "manager:" + employee.getManager()
                                + "department:" + employee.getDepartment()
                                );
                        }
                 System.out.println("========TABEL EMPLOYEE=========");
                 System.out.println("1.Show Data\n" +
                                    "2.Insert\n" +
                                    "3.Update\n" +
                                    "4.Delete");
                 System.out.println("=====================================");
                    Scanner input3 = new Scanner(System.in);
                    System.out.println("Masukan pilihan : ");    
                    int inputan3 = input3.nextInt();
                        switch (inputan3){
                            case 1 : {
                                for (Employee employee : edao.getAll()){
                                System.out.println("Id:"+ employee.getId()+ "First name:" + employee.getFirst_name()
                                + "Last name:" + employee.getLast_name()
                                + "email:" + employee.getEmail()
                                + "phone number:" + employee.getPhone_number()
                                + "hire date:" + employee.getHire_date()
                                + "job:" + employee.getJob()
                                + "salary:" + employee.getSalary()
                                + "comission pct:" + employee.getCommission_pct()
                                + "manager:" + employee.getManager()
                                + "department:" + employee.getDepartment()
                                    );
                                } break;
                          } case 2 : {
                              Scanner inputId = new Scanner(System.in);
                              Scanner inputFirstName = new Scanner(System.in);
                              Scanner inputLastName = new Scanner(System.in);
                              Scanner inputEmail = new Scanner(System.in);
                              Scanner inputPhonenumber = new Scanner(System.in);
                              Scanner inputHireDate = new Scanner(System.in);
                              Scanner inputJob = new Scanner(System.in);
                              Scanner inputSalary = new Scanner(System.in);
                              Scanner inputComissionPct = new Scanner(System.in);
                              Scanner inputManager = new Scanner(System.in);
                              Scanner inputDepartment = new Scanner(System.in);
                              System.out.println("Masukan id = ");
                              int id = inputId.nextInt();
                              System.out.println("Masukan First name = ");
                              String firstname  = inputFirstName.nextLine();
                               boolean valid=false;
                              while(valid==false){        
                              if (!firstname.matches("[a-zA-Z_]+")) {
                                    System.out.println("Invalid name");
                                    System.out.println("Masukan First name = ");
                                    inputFirstName.nextLine();
                                }
                              else
                                  valid=true;
                                  break;
                              }
                              System.out.println("Masukan Last name = ");
                              String lastname = inputLastName.nextLine();
                              boolean valid1=false;
                              while(valid1==false){        
                              if (!lastname.matches("[a-zA-Z_]+")) {
                                    System.out.println("Invalid name");
                                    System.out.println("Masukan Last name = ");
                                    inputLastName.nextLine();
                                }
                              else
                                  valid1=true;
                                  break;
                              }
                              System.out.println("Masukan Email = ");
                              String email = inputEmail.nextLine();
                              System.out.println("Masukan Phone number = ");
                              String phonenumber = inputPhonenumber.nextLine();
                              boolean valid3=false;
                              while(valid3==false){        
                              if (!phonenumber.matches("[0-9]*")) {
                                    System.out.println("Invalid phone number");
                                    System.out.println("Masukan Phone number = ");
                                    inputPhonenumber.nextLine();
                                }
                              else
                                  valid3=true;
                                  break;
                              }
                              System.out.println("Masukan Hire date = ");
                              String hiredate = inputHireDate.nextLine();
                              System.out.println("Masukan Job = ");
                              String job = inputJob.nextLine();
                              System.out.println("Masukan Salary = ");
                              double salary = inputSalary.nextDouble();
                              System.out.println("Masukan Comission pct = ");
                              double comissionpct = inputComissionPct.nextDouble();
                              System.out.println("Masukan Manager = ");
                              int manager = inputManager.nextInt();
                              System.out.println("Masukan Department = ");
                              int department = inputDepartment.nextInt();
                              Employee employee = new Employee(id, firstname, lastname, email, phonenumber, hiredate, job, salary, comissionpct, manager, department);
                              
                              boolean cek = edao.insert(employee);
                              
                              if (cek){
                                  System.out.println("Data berhasil Tersimpan");
                                  System.out.println("=======================");
                                  for (Employee employees : edao.getAll()){
                                System.out.println("Id:"+ employees.getId()+ "First name:" + employees.getFirst_name()
                                + "Last name:" + employees.getLast_name()
                                + "email:" + employees.getEmail()
                                + "phone number:" + employees.getPhone_number()
                                + "hire date:" + employees.getHire_date()
                                + "job:" + employees.getJob()
                                + "salary:" + employees.getSalary()
                                + "comission pct:" + employees.getCommission_pct()
                                + "manager:" + employees.getManager()
                                + "department:" + employees.getDepartment()
                                    );
                                }
                                  } break;
                          } case 3 : {
                              Scanner inputId = new Scanner(System.in);
                              Scanner inputFirstName = new Scanner(System.in);
                              Scanner inputLastName = new Scanner(System.in);
                              Scanner inputEmail = new Scanner(System.in);
                              Scanner inputPhonenumber = new Scanner(System.in);
                              Scanner inputHireDate = new Scanner(System.in);
                              Scanner inputJob = new Scanner(System.in);
                              Scanner inputSalary = new Scanner(System.in);
                              Scanner inputComissionPct = new Scanner(System.in);
                              Scanner inputManager = new Scanner(System.in);
                              Scanner inputDepartment = new Scanner(System.in);
                              System.out.println("Masukan id yang akan diupdate: ");
                              int id = inputId.nextInt();
                              
                              Employee e = edao.getById(id);
                              System.out.println("==============================");
                              System.out.println("Data sebelum diupdate:");
                               System.out.println("Id:"+ e.getId()+ "First name:" + e.getFirst_name()
                                + "Last name:" + e.getLast_name()
                                + "email:" + e.getEmail()
                                + "phone number:" + e.getPhone_number()
                                + "hire date:" + e.getHire_date()
                                + "job:" + e.getJob()
                                + "salary:" + e.getSalary()
                                + "comission pct:" + e.getCommission_pct()
                                + "manager:" + e.getManager()
                                + "department:" + e.getDepartment()
                                );
                              System.out.println("==============================");
                              System.out.println("Masukan First name baru: ");
                              String firstname = inputFirstName.nextLine();
                              System.out.println("Masukan Last name baru: ");
                              String lastname = inputLastName.nextLine();
                              System.out.println("Masukan Email baru: ");
                              String email = inputEmail.nextLine();
                              System.out.println("Masukan Phone number baru: ");
                              String phonenumber = inputPhonenumber.nextLine();
                              System.out.println("Masukan Hire date baru: ");
                              String hiredate = inputHireDate.nextLine();
                              System.out.println("Masukan job baru: ");
                              String job = inputJob.nextLine();
                              System.out.println("Masukan Salary baru: ");
                              double salary = inputSalary.nextDouble();
                              System.out.println("Masukan Comission pct baru: ");
                              double comissionpct = inputComissionPct.nextDouble();
                              System.out.println("Masukan Manager baru: ");
                              int manager = inputManager.nextInt();
                              System.out.println("Masukan Department baru: ");
                              int department = inputDepartment.nextInt();
                              Employee employee = new Employee(id, firstname, lastname, email, phonenumber, hiredate, job, salary, comissionpct, manager, department);
                              boolean cek = edao.update(id, employee);
                              
                            if (cek){
                                  System.out.println("Data berhasil Diperbarui");
                                  System.out.println("=======================");
                                 for (Employee employees : edao.getAll()){
                                System.out.println("Id:"+ employees.getId()+ "First name:" + employees.getFirst_name()
                                + "Last name:" + employees.getLast_name()
                                + "email:" + employees.getEmail()
                                + "phone number:" + employees.getPhone_number()
                                + "hire date:" + employees.getHire_date()
                                + "job:" + employees.getJob()
                                + "salary:" + employees.getSalary()
                                + "comission pct:" + employees.getCommission_pct()
                                + "manager:" + employees.getManager()
                                + "department:" + employees.getDepartment()
                                    );
                                }
                            } break;
                          } case 4 : {
                            System.out.println("Masukan id yang akan dihapus:");
                            Scanner inputid = new Scanner(System.in);
                            int id = inputid.nextInt();
                            boolean cek = edao.delete(id);
                            
                            if (cek){
                                  System.out.println("Data berhasil Dihapus");
                                  System.out.println("=======================");
                                  for (Employee employees : edao.getAll()){
                                System.out.println("Id:"+ employees.getId()+ "First name:" + employees.getFirst_name()
                                + "Last name:" + employees.getLast_name()
                                + "email:" + employees.getEmail()
                                + "phone number:" + employees.getPhone_number()
                                + "hire date:" + employees.getHire_date()
                                + "job:" + employees.getJob()
                                + "salary:" + employees.getSalary()
                                + "comission pct:" + employees.getCommission_pct()
                                + "manager:" + employees.getManager()
                                + "department:" + employees.getDepartment()
                                    );
                                }
                            } break;
                          }
                        } break;
                } case 2 : {
                    Scanner inputId = new Scanner(System.in);
                              Scanner inputFirstName = new Scanner(System.in);
                              Scanner inputLastName = new Scanner(System.in);
                              Scanner inputEmail = new Scanner(System.in);
                              Scanner inputPhonenumber = new Scanner(System.in);
                              Scanner inputHireDate = new Scanner(System.in);
                              Scanner inputJob = new Scanner(System.in);
                              Scanner inputSalary = new Scanner(System.in);
                              Scanner inputComissionPct = new Scanner(System.in);
                              Scanner inputManager = new Scanner(System.in);
                              Scanner inputDepartment = new Scanner(System.in);
                              System.out.println("Masukan id = ");
                              int id = inputId.nextInt();
                              System.out.println("Masukan First name = ");
                              String firstname  = inputFirstName.nextLine();
                              boolean valid=false;
                              while(valid==false){        
                              if (!firstname.matches("[a-zA-Z_]+")) {
                                    System.out.println("Invalid name");
                                    System.out.println("Masukan First name = ");
                                    inputFirstName.nextLine();
                                }
                              else
                                  valid=true;
                                  break;
                              } 
                              System.out.println("Masukan Last name = ");
                              String lastname = inputLastName.nextLine();
                              boolean valid1=false;
                              while(valid1==false){        
                              if (!lastname.matches("[a-zA-Z_]+")) {
                                    System.out.println("Invalid name");
                                    System.out.println("Masukan Last name = ");
                                    inputLastName.nextLine();
                                }
                              else
                                  valid1=true;
                                  break;
                              }
                              System.out.println("Masukan Email = ");
                              String email = inputEmail.nextLine();
                              System.out.println("Masukan Phone number = ");
                              String phonenumber = inputPhonenumber.nextLine();
                              boolean valid3=false;
                              while(valid3==false){        
                              if (!phonenumber.matches("[0-9]*")) {
                                    System.out.println("Invalid phone number");
                                    System.out.println("Masukan Phone number = ");
                                    inputPhonenumber.nextLine();
                                }
                              else
                                  valid3=true;
                                  break;
                              }
                              System.out.println("Masukan Hire date = ");
                              String hiredate = inputHireDate.nextLine();
                              System.out.println("Masukan Job = ");
                              String job = inputJob.nextLine();
                              System.out.println("Masukan Salary = ");
                              double salary = inputSalary.nextDouble();
                              System.out.println("Masukan Comission pct = ");
                              double comissionpct = inputComissionPct.nextDouble();
                              System.out.println("Masukan Manager = ");
                              int manager = inputManager.nextInt();
                              System.out.println("Masukan Department = ");
                              int department = inputDepartment.nextInt();
                              Employee employee = new Employee(id, firstname, lastname, email, phonenumber, hiredate, job, salary, comissionpct, manager, department);
                              
                              boolean cek = edao.insert(employee);
                              
                              if (cek){
                                  System.out.println("Data berhasil Tersimpan");
                                  System.out.println("=======================");
                                  for (Employee employees : edao.getAll()){
                                System.out.println("Id:"+ employees.getId()+ "First name:" + employees.getFirst_name()
                                + "Last name:" + employees.getLast_name()
                                + "email:" + employees.getEmail()
                                + "phone number:" + employees.getPhone_number()
                                + "hire date:" + employees.getHire_date()
                                + "job:" + employees.getJob()
                                + "salary:" + employees.getSalary()
                                + "comission pct:" + employees.getCommission_pct()
                                + "manager:" + employees.getManager()
                                + "department:" + employees.getDepartment()
                                    );
                                }
                                  } break;    
                } case 3 : {
                     Scanner inputId = new Scanner(System.in);
                              Scanner inputFirstName = new Scanner(System.in);
                              Scanner inputLastName = new Scanner(System.in);
                              Scanner inputEmail = new Scanner(System.in);
                              Scanner inputPhonenumber = new Scanner(System.in);
                              Scanner inputHireDate = new Scanner(System.in);
                              Scanner inputJob = new Scanner(System.in);
                              Scanner inputSalary = new Scanner(System.in);
                              Scanner inputComissionPct = new Scanner(System.in);
                              Scanner inputManager = new Scanner(System.in);
                              Scanner inputDepartment = new Scanner(System.in);
                              System.out.println("Masukan id yang akan diupdate: ");
                              int id = inputId.nextInt();
                              
                              Employee e = edao.getById(id);
                              System.out.println("==============================");
                              System.out.println("Data sebelum diupdate:");
                               System.out.println("Id:"+ e.getId()+ "First name:" + e.getFirst_name()
                                + "Last name:" + e.getLast_name()
                                + "email:" + e.getEmail()
                                + "phone number:" + e.getPhone_number()
                                + "hire date:" + e.getHire_date()
                                + "job:" + e.getJob()
                                + "salary:" + e.getSalary()
                                + "comission pct:" + e.getCommission_pct()
                                + "manager:" + e.getManager()
                                + "department:" + e.getDepartment()
                                    );
                              System.out.println("==============================");
                              System.out.println("Masukan First name baru: ");
                              String firstname = inputFirstName.nextLine();
                              System.out.println("Masukan Last name baru: ");
                              String lastname = inputLastName.nextLine();
                              System.out.println("Masukan Email baru: ");
                              String email = inputEmail.nextLine();
                              System.out.println("Masukan Phone number baru: ");
                              String phonenumber = inputPhonenumber.nextLine();
                              System.out.println("Masukan Hire date baru: ");
                              String hiredate = inputHireDate.nextLine();
                              System.out.println("Masukan job baru: ");
                              String job = inputJob.nextLine();
                              System.out.println("Masukan Salary baru: ");
                              double salary = inputSalary.nextDouble();
                              System.out.println("Masukan Comission pct baru: ");
                              double comissionpct = inputComissionPct.nextDouble();
                              System.out.println("Masukan Manager baru: ");
                              int manager = inputManager.nextInt();
                              System.out.println("Masukan Department baru: ");
                              int department = inputDepartment.nextInt();
                              Employee employee = new Employee(id, firstname, lastname, email, phonenumber, hiredate, job, salary, comissionpct, manager, department);
                              boolean cek = edao.update(id, employee);
                              
                            if (cek){
                                  System.out.println("Data berhasil Diperbarui");
                                  System.out.println("=======================");
                                 for (Employee employees : edao.getAll()){
                                System.out.println("Id:"+ employees.getId()+ "First name:" + employees.getFirst_name()
                                + "Last name:" + employees.getLast_name()
                                + "email:" + employees.getEmail()
                                + "phone number:" + employees.getPhone_number()
                                + "hire date:" + employees.getHire_date()
                                + "job:" + employees.getJob()
                                + "salary:" + employees.getSalary()
                                + "comission pct:" + employees.getCommission_pct()
                                + "manager:" + employees.getManager()
                                + "department:" + employees.getDepartment()
                                    );
                                }
                            } break;
                } case 4 : {
                     
                     System.out.println("Masukan id yang akan dihapus:");
                            Scanner inputid = new Scanner(System.in);
                            int id = inputid.nextInt();
                            boolean cek = edao.delete(id);
                            
                            if (cek){
                                  System.out.println("Data berhasil Dihapus");
                                  System.out.println("=======================");
                                  for (Employee employees : edao.getAll()){
                                System.out.println("Id:"+ employees.getId()+ "First name:" + employees.getFirst_name()
                                + "Last name:" + employees.getLast_name()
                                + "email:" + employees.getEmail()
                                + "phone number:" + employees.getPhone_number()
                                + "hire date:" + employees.getHire_date()
                                + "job:" + employees.getJob()
                                + "salary:" + employees.getSalary()
                                + "comission pct:" + employees.getCommission_pct()
                                + "manager:" + employees.getManager()
                                + "department:" + employees.getDepartment()
                                    );
                                }
                            } break;
                    }    
                }
            }
        }
    }
}
