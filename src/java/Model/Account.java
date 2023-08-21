package Model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import dal.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Account extends DBContext {

    private String acc, pass, id, filmDanhgia, cmmt;
    Connection cnn = connection;
    ResultSet rs;
    PreparedStatement stm;

    public Account(String acc, String pass) {
        this.acc = acc;
        this.pass = pass;
        connect();
    }

    public Account(String acc, String pass, String id, String filmDanhgia, String  cmmt) {
        this.acc = acc;
        this.pass = pass;
        this.id = id;
        this.filmDanhgia = filmDanhgia;
        this.cmmt = cmmt;
        connect();
    }

    public String getAcc() {
        return acc;
    }

    public void setAcc(String acc) {
        this.acc = acc;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private void connect() {

        DBContext db = new DBContext();
        if (db.DbConnect() != null) {
            System.out.println("Connect success!");
        } else {
            System.out.println("Failed");
        }
    }
    public boolean addAccount() {
    try {
            String sql = "insert into Account (acc,pass,idAccept,IDupdateFilm,CmmtId) values (?,?,?,?,?);";
            stm = cnn.prepareStatement(sql);
            stm.setString(1, acc);
            stm.setString(2, pass);
            stm.setString(3, id);
            stm.setString(4, "");
            stm.setString(5, "");
            stm.execute();
            return true;
        } catch (Exception e) {
            System.out.println("add Account error: " + e.getMessage());
            return false;
        }
    }

    public String getAccept(String acc, String pass) {
        try {
            String sliSQL = "  select * from Account where acc = ? and pass = ?";
            stm = connection.prepareStatement(sliSQL);
            stm.setString(1, acc);
            stm.setString(2, pass);
            rs = stm.executeQuery();
            while (rs.next()) {
                return rs.getString(3);
            }
        } catch (Exception e) {
            System.out.println("getUsers: " + e.getMessage());
        }
        return "null";
    }

    public boolean updateDanhGia(String idFilm, String acc) {
        String oldId = getIdFilmHasUsed(acc).trim();
        if (oldId.isEmpty() || oldId.equals("NULL")) {
            oldId = "";
        }
        String idCplt = idFilm + "," + oldId;
        if (idCplt.endsWith(",")) {
            idCplt = idCplt.substring(0, idCplt.length() - 1);
        }
        try {
            String sql = "update Account set IDupdateFilm = ? where acc = ?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, idCplt);
            stm.setString(2, acc);
            rs = stm.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("UpdateDanhGia: " + e.getMessage());
        }
        return false;
    }

    public boolean checkDanhGia(String idFilm, String acc) {
        try {
            String sql = "SELECT * FROM Account WHERE ',' + IDupdateFilm + ',' LIKE ? and acc = ?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, "%," + idFilm + ",%");//'%,2,%'
            stm.setString(2, acc);
            rs = stm.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("checkDanhGia: " + e.getMessage());
        }
        return false;
    }

    public String getIdFilmHasUsed(String acc) {
        try {
            String sql = "select a.IDupdateFilm from Account a where a.acc = ?";
            stm = cnn.prepareStatement(sql);
            stm.setString(1, acc);
            rs = stm.executeQuery();
            while (rs.next()) {
                return rs.getString(1);
            }
        } catch (Exception e) {
            System.out.println("getIdFilmHasUsed: " + e.getMessage());
        }
        return "";
    }
    public String getCmmtId(String acc) {
        try {
            String sql = "select a.CmmtId from Account a where a.acc = ?";
            stm = cnn.prepareStatement(sql);
            stm.setString(1, acc);
            rs = stm.executeQuery();
            while (rs.next()) {
                return rs.getString(1);
            }
        } catch (Exception e) {
            System.out.println("getIdFilmHasUsed: " + e.getMessage());
        }
        return "";
    }
    
    public boolean updateCmmtForAcc(String acc, String idCmt) {
        String oldCmmtId = getCmmtId(acc).trim();
        if (oldCmmtId.isEmpty() || oldCmmtId.equals("NULL")) {
            oldCmmtId = "";
        }
        String idCmmt = idCmt + "," + oldCmmtId;
        if (idCmmt.endsWith(",")) {
            idCmmt = idCmmt.substring(0, idCmmt.length() - 1);
        }
        try{
            String sql = "update Account set CmmtId = ? where acc = ?";
            stm = cnn.prepareStatement(sql);
            stm.setString(1, idCmmt);
            stm.setString(2, acc);
            rs = stm.executeQuery();
            while(rs.next()) {
                return true;
            }
        }catch(Exception e) {
            System.out.println("updateCmmtForAcc: " + e.getMessage());
        }return false;
    }

}
