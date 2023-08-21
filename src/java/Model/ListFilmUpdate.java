/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class ListFilmUpdate {

    private static ArrayList<Film> filmList = new ArrayList<>();

    public ListFilmUpdate() {
    }

    public static ArrayList<Film> getFilmList() {
        return filmList;
    }

    public static void setFilmList(ArrayList<Film> filmList) {
        ListFilmUpdate.filmList = filmList;
    }

    public static void addFilm(Film film) {
        filmList.add(film);
    }
}
