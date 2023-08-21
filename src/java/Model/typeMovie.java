/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author user
 */
public class typeMovie {
    int id;
    String name;

    public typeMovie(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String convertType(int type) {
        switch (type) {
            case 2:
                return "Phim Bộ";
            case 1:
                return "Phim Lẻ";
            case 3:
                return "Phim Chiếu Rạp";
        }
        return "";
    }
    
    
}
