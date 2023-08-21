/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author user
 */
public class National {
    private int idNation;
    private String nameNation;

    public National() {
    }

    public National(int idNation, String nameNation) {
        this.idNation = idNation;
        this.nameNation = nameNation;
    }

    public int getIdNation() {
        return idNation;
    }

    public void setIdNation(int idNation) {
        this.idNation = idNation;
    }

    public String getNameNation() {
        return nameNation;
    }

    public void setNameNation(String nameNation) {
        this.nameNation = nameNation;
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
    
    
    
    
}
