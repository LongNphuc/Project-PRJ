/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Project;

import Model.Account;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String acc = req.getParameter("acc");
        String pass = req.getParameter("pass");
        Account account = new Account(acc, pass);
        String id = account.getAccept(req.getParameter("acc"), req.getParameter("pass"));
        if (!id.equals("null")) {
            req.getSession().setAttribute("mess2", id);
            req.getSession().setAttribute("account", account);
            req.getSession().setAttribute("acc", account.getAcc());
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("Login.jsp").forward(req, resp);
        }
    }

}
//if(req.getParameter("acc") != null) {
//            Account a = new Account();
//            String id = a.getAccept(req.getParameter("acc"), req.getParameter("pass"));

////        }
