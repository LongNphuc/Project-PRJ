/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author user
 */
public class Rating {

    private String idFilm, nameFilm, markReport, numReport;

    public Rating(String markReport, String numReport) {
        this.markReport = markReport;
        this.numReport = numReport;
    }

    public Rating(String idFilm, String nameFilm, String markReport, String numReport) {
        this.idFilm = idFilm;
        this.nameFilm = nameFilm;
        this.markReport = markReport;
        this.numReport = numReport;
    }

    public String getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(String idFilm) {
        this.idFilm = idFilm;
    }

    public String getNameFilm() {
        return nameFilm;
    }

    public void setNameFilm(String nameFilm) {
        this.nameFilm = nameFilm;
    }

    public String getMarkReport() {
        return markReport;
    }

    public void setMarkReport(String markReport) {
        this.markReport = markReport;
    }

    public String getNumReport() {
        return numReport;
    }

    public void setNumReport(String numReport) {
        this.numReport = numReport;
    }

}
