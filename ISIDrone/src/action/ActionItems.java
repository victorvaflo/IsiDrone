package action;

import com.sun.net.httpserver.HttpServer;
import entities.Item;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.MItem;

public class ActionItems {
    
	public static void getItems(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("items", MItem.getItems(ActionCategory.getSelectedCategory(request, response)));
	}

	public static void getItemById(int id, HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("item", MItem.getItemById(id));
	}
        
        public static void getItemsSearch(String motInput,HttpServletRequest request,HttpServletResponse response){
            request.setAttribute("items", MItem.getItemsBySearch(motInput));
            
        }
        
        public static void addProducts(HttpServletRequest request, HttpServletResponse response) {
            
            System.out.println("NOMBRE"+request.getParameter("name"));
            if(MItem.addItems(new Item(-1,
                                    Integer.parseInt(request.getParameter("category")),
                                    request.getParameter("name"),
                                    request.getParameter("description"),
                                    Double.parseDouble(request.getParameter("price")),
                                    request.getParameter("serial"),
                                    request.getParameter("image"),
                                    Integer.parseInt(request.getParameter("stock")),
                                    Integer.parseInt(request.getParameter("isActive"))))==1){
                request.setAttribute("msg", "Produit bien ajoute");
           
	
        }else{
                request.setAttribute("msg", "Produit pas ajoute");
            }
        }
        
        
         public static void editProduct(HttpServletRequest request, HttpServletResponse response) {
            
            System.out.println("NOMBRE"+request.getParameter("name"));
            if(MItem.addItems(new Item(-1,
                                    Integer.parseInt(request.getParameter("category")),
                                    request.getParameter("name"),
                                    request.getParameter("description"),
                                    Double.parseDouble(request.getParameter("price")),
                                    request.getParameter("serial"),
                                    request.getParameter("image"),
                                    Integer.parseInt(request.getParameter("stock")),
                                    Integer.parseInt(request.getParameter("isActive"))))==1){
                request.setAttribute("msg", "Produit bien modifie");
           
	
        }else{
                request.setAttribute("msg", "Produit n'a pas ete modifie");
            }
        }
         
         
	public static  void DeleteProduit (int id, HttpServletRequest request, HttpServletResponse response){
       //request.setAttribute(id, MItem.deletItem(id));
        }
        
        public static void updateItem(HttpServletRequest request, HttpServletResponse response) {

        System.out.println("55555555555 ESTOY EN action.ActionItems Mitems.Update items " + request.getParameter("id") + request.getParameter("category") + request.getParameter("name") + request.getParameter("description") + request.getParameter("price") + request.getParameter("serial")+ request.getParameter("image")+ request.getParameter("stock")+ request.getParameter("isActive"));
        request.setAttribute("itemUpdated", MItem.updateItem(Integer.parseInt(request.getParameter("id")),
                                            Integer.parseInt(request.getParameter("category")),
                                            request.getParameter("name"),
                                            request.getParameter("description"),
                                            Double.parseDouble(request.getParameter("price")),
                                            request.getParameter("serial"),
                                            request.getParameter("image"),
                                            Integer.parseInt(request.getParameter("stock")),
                                            Integer.parseInt(request.getParameter("isActive"))));
    }
        
}
