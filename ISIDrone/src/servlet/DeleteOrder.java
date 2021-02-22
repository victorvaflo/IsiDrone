/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import action.ActionOrder;
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
@WebServlet(name = "DeleteOrder", urlPatterns = {"/deleteOrder"})
public class DeleteOrder extends HttpServlet {

    public DeleteOrder() {
        super();
    }
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.setAttribute("orderId", request.getParameter("order_id"));
            request.getRequestDispatcher(Const.PATH_PAGE_DELETEORDER).forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ActionOrder.deleteOrder(request);
        request.getRequestDispatcher(Const.PATH_PAGE_DELETEORDER).forward(request, response);
    }

}
