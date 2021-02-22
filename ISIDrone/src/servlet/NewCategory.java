/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import action.ActionCategory;
import action.ActionItems;
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
 * @author dlunhu
 */
@WebServlet(name = "newCategory", urlPatterns = {"/newCategory"})
public class NewCategory extends HttpServlet {

    public NewCategory() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(Const.PATH_PAGE_NEWCATEGORIES).forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ActionCategory.addCategory(request, response);
        request.getRequestDispatcher(Const.PATH_PAGE_NEWCATEGORIES).forward(request, response);
    }
}
