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
import util.Const;

/**
 *
 * @author vvargasf
 */
@WebServlet(name = "EditCategory", urlPatterns = {"/editCategory"})
public class EditCategory extends HttpServlet {

    public EditCategory(){
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ActionCategory.getCategoryById(request, response);
        
        request.getRequestDispatcher(Const.PATH_PAGE_EDITCATEGORY).forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ActionCategory.updateCategory(request, response);       
        request.getRequestDispatcher(Const.PATH_PAGE_EDITCATEGORY).forward(request, response);
    }
}
