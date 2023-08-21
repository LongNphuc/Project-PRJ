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
 * @author LongNP
 */
public class Comments extends DBContext {

    private String cmmtId, filmId, cmmt, acc;
    Connection cnn = connection;
    ResultSet rs;
    PreparedStatement stm;

    public Comments(String acc, String cmmt) {
        this.acc = acc;
        this.cmmt= cmmt;
        connect();
    }

    public Comments() {
        connect();
    }

    public void connect() {
        if (cnn != null) {
            System.out.println("Connect succ!");
        } else {
            System.out.println("Failed!");
        }
    }

    public String getAcc() {
        return acc;
    }

    public void setAcc(String acc) {
        this.acc = acc;
    }
    

    public String getCmmtId() {
        return cmmtId;
    }

    public void setCmmtId(String cmmtId) {
        this.cmmtId = cmmtId;
    }

    public String getFilmId() {
        return filmId;
    }

    public void setFilmId(String filmId) {
        this.filmId = filmId;
    }

    public String getCmmt() {
        return cmmt;
    }

    public void setCmmt(String cmmt) {
        this.cmmt = cmmt;
    }

    public ArrayList<Comments> getListCmmt(String filmId) {
        ArrayList<Comments> data = new ArrayList<>();
        System.out.println(filmId);
        try {
            String sql = "SELECT Account.acc, Comments.message\n"
                    + "FROM Account\n"
                    + "JOIN Comments ON CONCAT(',', Account.CmmtId, ',') LIKE CONCAT('%,', Comments.CmmtId, ',%')\n"
                    + "WHERE Comments.FilmId = ?;";
            stm = connection.prepareStatement(sql);
            stm.setString(1, filmId);
            rs = stm.executeQuery();
            while (rs.next()) {
                String acc= rs.getString(1);
                String cmmt = rs.getString(2);
                data.add(new Comments(acc, cmmt));
            }
        } catch (Exception e) {
            System.out.println("ListCmmt: " + e.getMessage());
        }return data;
    }
    
    public boolean addmmt(String filmId, String cmmt) {
        try{
            String sql = "insert into Comments(FilmId,Message) values(?,?)";
            stm = connection.prepareStatement(sql);
            stm.setString(1, filmId);
            stm.setString(2, cmmt);
            stm.execute();
            return true;
        }catch(Exception e) {
            e.printStackTrace();
        }return false;
    }
    public ArrayList<Comments> getListCmmt() {
        ArrayList<Comments> data = new ArrayList<>();
        try {
            String sql ="select * from Comments";
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                String acc= rs.getString(1);
                String cmmt = rs.getString(2);
                data.add(new Comments(acc, cmmt));
            }
        } catch (Exception e) {
            System.out.println("ListCmmt: " + e.getMessage());
        }return data;
    }
    

}
