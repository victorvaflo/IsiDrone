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
import manager.MItem;
import util.Const;

/**
 *
 * @author aelmeski
 */
@WebServlet(name = "SupressionProduit", urlPatterns = {"/supressionProduit"})
public class SupressionProduit extends HttpServlet {

   public SupressionProduit() {
        super();
   }
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

       if (req.getParameter("action").equals("oui")){
         int id= Integer.parseInt(req.getParameter("id"));
         MItem.deletItem(id);
         resp.sendRedirect("listProducts");
       
      }else if (req.getParameter("action").equals("non")){
         resp.sendRedirect("listProducts");
      }
     
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       processRequest(req,resp);
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     processRequest(request,response);
      //request.getRequestDispatcher(Const.PATH_PAGE_POPUP).forward(request, response);
     
        
    }



}
