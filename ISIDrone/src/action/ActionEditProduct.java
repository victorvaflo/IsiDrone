package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.MCategory;
import manager.MEditProduct;

public class ActionEditProduct {
	
	public static void getProductById(HttpServletRequest request, HttpServletResponse response,int product_id) {
		request.setAttribute("produit_unique", MEditProduct.getItemById(product_id));
               
	}
        
        public static void editProductById(HttpServletRequest request,HttpServletResponse response,String nom,int categorie,String description,double prix,String numero_de_serie,int quantite_en_stock,int produit_actif,int produit_id){
           request.setAttribute("produit_modifie", MEditProduct.editItemById(nom,categorie,description,prix,numero_de_serie,quantite_en_stock,produit_actif,produit_id)); 
        }
	
	
        
        
        
}
