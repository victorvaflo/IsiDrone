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
import action.ActionItems;

/**
 *
 * @author istreich
 */
@WebServlet(name = "newProductsAdmin", urlPatterns = {"/newProductsAdmin"})

public class NewProducts extends HttpServlet {

     public NewProducts() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
         
		
            request.getRequestDispatcher(Const.PATH_PAGE_PRODUCTSADMIN).forward(request, response);

                
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                
            ActionItems.addProducts(request, response);
            request.getRequestDispatcher(Const.PATH_PAGE_PRODUCTSADMIN).forward(request, response);
                
//		String name = request.getParameter("name");
//		String category = request.getParameter("category");
//		String description = request.getParameter("description");
//		String price = request.getParameter("price");
//		String serial = request.getParameter("serial");
//		String stock = request.getParameter("stock");
//		String image = request.getParameter("image");
//		String isActive = request.getParameter("isActive");
	 
	}
}
