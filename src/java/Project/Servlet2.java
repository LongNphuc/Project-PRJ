/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Project;

import Model.Account;
import Model.Actor;
import Model.Category;
import Model.Comments;
import Model.Film;
import Model.ListFilmUpdate;
import Model.National;
import Model.Rating;
import Model.typeMovie;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author user
 */
public class Servlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String searchID = req.getParameter("searchID");
        String searchIdforInfor = req.getParameter("searchIDForInfor");
        String searchFilmByActor = req.getParameter("actor");
        Film flm = new Film();
        ArrayList<Film> listFilm = new ArrayList<>();
        ArrayList<Rating> listRating = new ArrayList<>();
        ArrayList<Actor> listActor = new ArrayList<>();
        ArrayList<National> listNation = new ArrayList<>();
        ArrayList<Category> listCate = new ArrayList<>();
        ArrayList<typeMovie> listType = new ArrayList<>();
        if (req.getParameter("actor") != null) {
            listFilm = flm.getListFilm(searchFilmByActor, -2);
            String mess = "The Films relation by: " + "'" + searchFilmByActor + "'";
            req.getSession().setAttribute("mess1", mess);
            req.getSession().setAttribute("listFilm", listFilm);
            resp.sendRedirect("displayListFilm.jsp");
            return;
        } else if (req.getParameter("searchIDForInfor") != null) {
            listFilm = flm.getListFilm(searchIdforInfor, -3);
            listRating = flm.getListRating(searchIdforInfor);
            listNation = flm.getNationList();
            listType = flm.getTypeList();
            listCate = flm.getCateList();
            req.getSession().setAttribute("listType", listType);
            req.getSession().setAttribute("listCate", listCate);
            req.getSession().setAttribute("listNation", listNation);
            req.getSession().setAttribute("listFilm", listFilm);
            req.getSession().setAttribute("listRating", listRating);
            resp.sendRedirect("EditFilm.jsp");
        } else if (req.getParameter("deleteFilmByID") != null) {
            boolean flagR = flm.deleteRatingById(req.getParameter("deleteFilmByID"));
            boolean flagF = flm.deleteFIlmById(req.getParameter("deleteFilmByID"));
            String mess = "";
            String name = req.getParameter("name");
            String id = req.getParameter("deleteFilmByID");
            if (flagF == true && flagR == true) {
                mess = "Delete film with name " + name + " have id: " + id + " successful!";
                ArrayList<Film> listUpdate = ListFilmUpdate.getFilmList();
                Iterator<Film> iterator = listUpdate.iterator();
                while (iterator.hasNext()) {
                    Film fl = iterator.next();
                    if (fl.getId() == Integer.parseInt(req.getParameter("deleteFilmByID"))) {
                        iterator.remove();
                        break;
                    }
                }
                ListFilmUpdate.setFilmList(listUpdate);
            } else {
                if (flagF == false) {
                    mess = "Delete Film with name " + name + " have id: " + id + " failed!";
                } else if (flagR == false) {
                    mess = "Delete Rating Film with name " + name + " have id: " + id + " failed!";
                } else {
                    mess = "Delete Film and Rating with name " + name + " have id: " + id + " failed!";
                }
            }
            req.setAttribute("mess", mess);
            req.getRequestDispatcher("index.jsp").forward(req, resp);

        } else {
            String mess3 = "";
            HttpSession session = req.getSession();
            Account account = (Account) session.getAttribute("account");
            System.out.println("mess2:" + req.getSession().getAttribute("mess2"));
            System.out.println("acc: " + account.getAcc());
            if (account == null) {
                resp.sendRedirect("Login.jsp");
            } else {
                if (req.getParameter("cmmt") != null) {
                    Comments c = new Comments();
                    String IDF = (String) req.getSession().getAttribute("IDF");
                    boolean check = c.addmmt(IDF, req.getParameter("cmmt"));
                    if(check) {
                        ArrayList<Comments> data2 = c.getListCmmt();
                        boolean check2 = account.updateCmmtForAcc(account.getAcc(), String.valueOf(data2.size()));
                    }
                }
                if (req.getParameter("star") != null) {
                    int mark = Integer.parseInt(req.getParameter("star"));
                    flm.UpdateRatingById(searchID, mark);
                    account.updateDanhGia(searchID, account.getAcc());
                }
                if (req.getParameter("searchID") != null) {
                    if (req.getSession().getAttribute("mess2").equals("0")) {
                        boolean check = account.checkDanhGia(searchID, account.getAcc());
                        if (check) {
                            mess3 = "none";
                        } else {
                            mess3 = "block";
                        }
                    } else {
                        mess3 = "none";
                    }
                    listFilm = flm.getListFilm(searchID, -3);
                    listRating = flm.getListRating(searchID);
                    listActor = flm.getListActorByIDfilm(searchID);
                }
                System.out.println("mess3:" + mess3);
                req.getSession().setAttribute("IDF", searchID);
                req.getSession().setAttribute("mess3", mess3);
                req.getSession().setAttribute("listActor", listActor);
                req.getSession().setAttribute("listFilm", listFilm);
                req.getSession().setAttribute("listRating", listRating);
                resp.sendRedirect("displayFilm.jsp");
                return;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        if (req.getParameter("film") != null) {
            ArrayList<National> listNation = new ArrayList<>();
            ArrayList<Category> listCate = new ArrayList<>();
            ArrayList<typeMovie> listType = new ArrayList<>();
            ArrayList<Rating> listRate = new ArrayList<>();
            Film flm = new Film();
            listNation = flm.getNationList();
            listType = flm.getTypeList();
            listCate = flm.getCateList();
            req.getSession().setAttribute("listType", listType);
            req.getSession().setAttribute("listCate", listCate);
            req.getSession().setAttribute("listNation", listNation);
            req.getRequestDispatcher("addFilm.jsp").forward(req, resp);
        } else if (req.getParameter("actor") != null) {
            Film flm = new Film();
            ArrayList<Film> listFilm = flm.getListFilm();
            ArrayList<National> listNation = flm.getNationList();
            req.getSession().setAttribute("listNation", listNation);
            req.getSession().setAttribute("listFilm", listFilm);
            req.getRequestDispatcher("addActor.jsp").forward(req, resp);
        }

    }

}
