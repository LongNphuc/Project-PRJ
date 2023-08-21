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
import Model.National;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;


/**
 *
 * @author user
 */
public class Servlet3 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        if (req.getParameter("updateActor") != null) {
            Film f = new Film();
            ArrayList<Actor> listAct = f.getListActorByIDAct(req.getParameter("id"));
            ArrayList<National> listNat = f.getNationList();
            req.setAttribute("listAct", listAct);
            req.setAttribute("listNat", listNat);
            req.getRequestDispatcher("EditActor.jsp").forward(req, resp);
        }
        if (req.getParameter("deleteActor") != null) {
            Film f = new Film();
            String mess= "";
            boolean check = f.deleteActorById(req.getParameter("deleteActor"));
            if(check) {
                mess = "Delete Actor have id: " + req.getParameter("deleteActor") +" success!";
            }else {
                mess = "Delete Actor have id: " + req.getParameter("deleteActor") +" FAILED!";
            }
            ArrayList<Actor> listActor = f.getListActor();
            req.setAttribute("listActor", listActor);
            req.setAttribute("mess", mess);
            req.getRequestDispatcher("displayActor.jsp").forward(req, resp);
        }
        if (req.getParameter("hid") != null) {
            Film f = new Film();
            String mess="";
            boolean flag = f.updateActorByID(req.getParameter("id"), req.getParameter("name"), req.getParameter("natId"), req.getParameter("year"), req.getParameter("description"), req.getParameter("fid"));
            if (flag) {
                mess = "Update Actor " + req.getParameter("name") + " have id: " + req.getParameter("id") + " success!";
            } else {
                mess = "Update Actor " + req.getParameter("name") + " have id: " + req.getParameter("id") + " FAILED!";
            }
            ArrayList<Actor> listActor = f.getListActor();
            req.setAttribute("listActor", listActor);
            req.setAttribute("mess", mess);
            req.getRequestDispatcher("displayActor.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        if (req.getParameter("addCate") != null) {
            Film f = new Film();
            boolean check = f.addCate(req.getParameter("addCate"));
            ArrayList<Category> cateList = f.getCateList();
            req.setAttribute("cateList", cateList);
            req.getRequestDispatcher("displayCateInfor.jsp").forward(req, resp);
        }
        if (req.getParameter("addNat") != null) {
            Film f = new Film();
            boolean check = f.addCountry(req.getParameter("addNat"));
            ArrayList<National> natList = f.getNationList();
            req.setAttribute("nationList", natList);
            req.getRequestDispatcher("displayNational.jsp").forward(req, resp);
        }
        
        
    }

}
