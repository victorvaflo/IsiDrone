/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import action.ActionEditProduct;
import action.ActionItems;
import action.ActionLogin;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import manager.MEditProduct;
import util.Const;

/**
 *
 * @author ynzodasi
 */
@WebServlet(name = "editProduct", urlPatterns = {"/editProduct"})
public class EditProduct extends HttpServlet {

    public EditProduct() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String product_id = request.getParameter("product");
        if(product_id!= null){
        if(!product_id.trim().isEmpty()){
            int pr_id = Integer.parseInt(product_id);
            if(pr_id > 0){
            ActionEditProduct.getProductById(request, response,pr_id);
            
             }
            
        }
        } 
         request.getRequestDispatcher(Const.PATH_PAGE_EDIT_PRODUCT).forward(request, response);
    }
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recupere les infos modifier produits
        
    String nom = request.getParameter("nom");
    int categorie = Integer.parseInt(request.getParameter("categorie"));
    String description = request.getParameter("description");
    double prix = Double.parseDouble(request.getParameter("prix"));
    String numero_de_serie = request.getParameter("numero_de_serie");
    int quantite_en_stock = Integer.parseInt(request.getParameter("quantite_en_stock"));
    int produit_actif = Integer.parseInt(request.getParameter("produit_actif"));
    int produit_id = Integer.parseInt(request.getParameter("produit_id"));
    
    
    ActionEditProduct.editProductById(request, response,nom,categorie,description,prix,numero_de_serie,quantite_en_stock,produit_actif,produit_id);
    if(request.getParameter("action2").equals("modifier")){
//       ActionItems.editProduct(request, response);
        response.sendRedirect("listProducts"); 
        
            }
    }
}
