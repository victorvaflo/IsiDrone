/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.Const;

/**
 *
 * @author aelmeski
 */
@WebServlet(name = "HistoriqueC", urlPatterns = {"/historiqueC"})
public class HistoriqueC extends HttpServlet {

    public HistoriqueC() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         request.getRequestDispatcher(Const.PATH_HISTORIQUE_COMMANDE).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("Home");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
