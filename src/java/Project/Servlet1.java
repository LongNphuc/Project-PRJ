/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Project;

import Model.Actor;
import Model.Category;
import Model.Film;
import Model.ListFilmUpdate;

import Model.National;
import Model.Rating;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author user
 */
public class Servlet1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String message = "";
        String category = req.getParameter("param");
        String typeFilm = req.getParameter("type");
        String search = req.getParameter("search");
        String searchID = req.getParameter("searchID");
        String infor = req.getParameter("value");
        String nationID = req.getParameter("nationId");
        Film flm = new Film();
        ArrayList<Film> listFilm = new ArrayList<>();
        ArrayList<Actor> listActor = new ArrayList<>();
        ArrayList<Category> cateList = new ArrayList<>();
        if (infor == null) {
            if (req.getParameter("param") != null) {
                listFilm = flm.getListFilm(category, 1);
                message = "List Film " + flm.convertCate(Integer.parseInt(category));
            }
            if (req.getParameter("type") != null) {
                listFilm = flm.getListFilm(typeFilm, 0);
                message = "List Film " + flm.convertType(Integer.parseInt(typeFilm));
            }
            if (req.getParameter("search") != null) {
                listFilm = flm.getListFilm(search, -1);
                //
            }
            if (req.getParameter("searchID") != null) {
                listFilm = flm.getListFilm(searchID, -3);
                //
            }
            if (req.getParameter("nationId") != null) {
                listFilm = flm.getListFilm(nationID, 2);
                message = "List Film " + flm.convertNation(Integer.parseInt(nationID));
            }
            req.getSession().setAttribute("mess1", message);
            req.getSession().setAttribute("listFilm", listFilm);
            resp.sendRedirect("displayListFilm.jsp");
            return;
        } else {
            if (infor.equals("1")) {
                listFilm = flm.getListFilm();
                req.setAttribute("listFilm", listFilm);
                req.getRequestDispatcher("displayListFilmForEdit.jsp").forward(req, resp);
            } else if (infor.equals("2")) {
                listActor = flm.getListActor();
                req.setAttribute("listActor", listActor);
                req.getRequestDispatcher("displayActor.jsp").forward(req, resp);
            } else if (infor.equals("3")) { //
                cateList = flm.getCateList();
                req.setAttribute("cateList", cateList);
                req.getRequestDispatcher("displayCateInfor.jsp").forward(req, resp);
                return;
            } else {//
                ArrayList<National> nationList = flm.getNationList();
                req.setAttribute("nationList", nationList);
                req.getRequestDispatcher("displayNational.jsp").forward(req, resp);
            }

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String mess = "";
        String name1 = req.getParameter("name1");
        String name2 = req.getParameter("name2");
        int year = Integer.parseInt(req.getParameter("year"));
        String status = req.getParameter("status");
        int nation = Integer.parseInt(req.getParameter("nation"));
        double mark = 0;
        int num = 0;
        int type = 0;
        int cate = 0;
        int view = 0;
        int duration = 0;
        String actor = req.getParameter("actor");
        String img = req.getParameter("img");
        String director = req.getParameter("director");
        String author = req.getParameter("author");
        String descrription = req.getParameter("description");
        if (req.getParameter("addactor") == null) {
            duration = Integer.parseInt(req.getParameter("duration"));
            view = Integer.parseInt(req.getParameter("views"));
            type = Integer.parseInt(req.getParameter("type"));
            cate = Integer.parseInt(req.getParameter("category"));
            num = Integer.parseInt(req.getParameter("num"));
            if (num == 0) {
                mark = 0;
            } else {
                mark = Double.parseDouble(req.getParameter("mark"));
            }
        }
        if (req.getParameter("updateFilm") != null) {
            ArrayList<Film> listUpdate = new ArrayList<>();
            int id = Integer.parseInt(req.getParameter("id"));
            Film f = new Film(id, name1, name2, status, director, actor, cate, type, nation, year, img, descrription, duration, view, author,"");
            boolean checkF = f.updateFilmByID();
            boolean checkR = f.updateRating(mark, num, id);
            if (checkF == true && checkR == true) {
                mess = "Update film with name " + name2 + " have id: " + id + " successful!";
                listUpdate = f.getListFilmUpdate();
            } else {
                if (!checkF) {
                    mess = "Update film with name " + name2 + " have id: " + id + " failed!";
                } else if (!checkR) {
                    mess = mess = "Update Rating with name " + name2 + " have id: " + id + " failed!";
                } else {
                    mess = mess = "Update film and rating with name " + name2 + " have id: " + id + " failed!";
                }
            }req.setAttribute("updateList", listUpdate);
        } else if (req.getParameter("hidden") != null) {
            Film f = new Film();
            img = "images/" + img;
            ArrayList<Film> listUpdate = new ArrayList<>();
            f = new Film(0, name1, name2, status, director, actor, cate, type, nation, year, img, descrription, duration, view, author,"1");
            boolean checkF = f.addFilm();
            int idF = f.getListFilm().get(f.getListFilm().size() - 1).getId();
            boolean checkR = f.addRating(idF, name2, mark, num);
            if (checkF == true && checkR == true) {
                listUpdate = f.getListFilmUpdate();
                mess = "Add film " + name1 + " successful!";
            } else {
                if (!checkF) {
                    mess = "Add film " + name1 + " failed!";
                } else if (!checkR) {
                    mess = "Add rating " + name1 + " failed!";
                } else {
                    mess = "Add film and rating " + name1 + " failed!";
                }
            }req.setAttribute("updateList", listUpdate);
        } else if (req.getParameter("addactor") != null) {
            Film f = new Film();
            boolean checkA = f.checkActorExist(name1, req.getParameter("film"));
            boolean check;
            if (checkA) {
                mess = "Add Actor " + name1 + " Failed! Name and IDfilm was exist!";
            } else {
                check = f.addActor(name1, nation, year, descrription, img, req.getParameter("film"));
                if (check) {
                    mess = "Add Actor " + name1 + " successful!";
                } else {
                    mess = "Add Actor " + name1 + " Failed!";
                }
            }

        }
        req.setAttribute("mess", mess);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

}
