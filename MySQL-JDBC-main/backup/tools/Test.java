/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import daos.CountryDAO;
import daos.LocationDAO;
import daos.RegionDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import models.Country;
import models.Location;
import models.Region;

/**
 *
 * @author DevidBa
 */
public class Test {

    public static void main(String[] args) {
       // System.out.println("Dev");
        
//        String nama = "Dev";
//        System.out.println(nama);
//        
//        DbConnection connection = new DbConnection();
       // System.out.println(connection.getConncetion());
        
//        RegionDAO rdao = new RegionDAO(connection.getConncetion());
        
        //getAll
//        List<Region> regions = rdao.getAll();
//        for (Region region : regions) {
//            System.out.println(region.getRegionId());
//            System.out.println(region.getRegionName());
//        }
//        
//       Region region = new Region(0, "Nan Jauh Dimato");
//        System.out.println(rdao.insert(region));
        
//      getbyID
//        Region r = rdao.getById(1);
//        System.out.println(r.getRegionName());


//      Delete
//        System.out.println(rdao.delete(6));
        
        
        DbConnection connection = new DbConnection();
        RegionDAO rdao = new RegionDAO(connection.getConncetion());
        CountryDAO cdao = new CountryDAO(connection.getConncetion());
        LocationDAO ldao = new LocationDAO(connection.getConncetion());
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
            } case 4 : {
                
            } case 5 : {
                
            } case 6 : {
                
            }
        }
    }
}
