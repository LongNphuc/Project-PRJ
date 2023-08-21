/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import dal.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Actor extends DBContext{
    private int idActor, idNational, birthYear;
    private String nameActor, description, image, filmID;
    Connection cnn = connection;
    ResultSet rs;
    PreparedStatement stm;
    public Actor() {

        connect();
    }

    public Actor(int idActor, String nameActor, int idNational, int birthYear, String description, String image, String filmID) {
        connect();
        this.idActor = idActor;
        this.idNational = idNational;
        this.birthYear = birthYear;
        this.nameActor = nameActor;
        this.description = description;
        this.image= image;
        this.filmID = filmID;
    }

    public String getFilmID() {
        return filmID;
    }

    public void setFilmID(String filmID) {
        this.filmID = filmID;
    }
    

    public int getIdActor() {
        return idActor;
    }

    public void setIdActor(int idActor) {
        this.idActor = idActor;
    }
    

    public int getIdNational() {
        return idNational;
    }

    public void setIdNational(int idNational) {
        this.idNational = idNational;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getNameActor() {
        return nameActor;
    }

    public void setNameActor(String nameActor) {
        this.nameActor = nameActor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    public void connect() {
        if (cnn != null) {
            System.out.println("Connect succ!");
        } else {
            System.out.println("Failed!");
        }
    }
    public String convertNation(int nationId, String name) {
        switch (nationId) {
            case 1:
                return "America";
            case 2:
                return "VietNam";
            case 3:
                return "France";
            case 4:
                return "Japan";
            case 5:
                return "Korean";
            case 6:
                return "UKingdom";
            case 7:
                return "China";
            case 8:
                return "Canada";
            case 9:
                return "Hồng Kông";
            case 10:
                return "Thai Land";
        }
        return name;
    }
    
    
    public String getImageActorByName(String name){
        try{
            String sliSQL = "select * from Actor where Actor.Name like ?";
            stm = connection.prepareStatement(sliSQL);
            stm.setString(1, "%" + name + "%");
            rs = stm.executeQuery();
            while(rs.next()) {
                String image =  rs.getString(6);
                return image;
            }
        }catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }return "null";
    }
    
    
}
