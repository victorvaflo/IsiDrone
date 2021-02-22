/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import action.ActionCategory;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import manager.MCategory;
import util.Const;

/**
 *
 * @author istreich
 */
@WebServlet(name = "DeleteCategorie", urlPatterns = {"/deleteCategorie"})
public class DeleteCategorie extends HttpServlet {

    public DeleteCategorie() {
        super();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ActionCategory.getCategoryById(request, response);

        request.getRequestDispatcher(Const.PATH_PAGE_DELETEPOPUP).forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            if(request.getParameter("action").equals("oui")){
                ActionCategory.deleteCategory(request, response);
                request.setAttribute("msg",request.getParameter("action") );
                request.getRequestDispatcher(Const.PATH_PAGE_DELETEPOPUP).forward(request, response);
            }else{
                
                request.getRequestDispatcher("listCategories").forward(request, response);
            }

    }
}
