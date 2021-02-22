package action;

import entities.Category;
import entities.Item;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.MCategory;

public class ActionCategory {

    public static void getCategories(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("categories", MCategory.getCategories());
    }

    public static int getSelectedCategory(HttpServletRequest request, HttpServletResponse response) {
        //Permet de recevoir la catégorie sélectionné par l'utilisateur
        String paramCategory = request.getParameter("category");

        //ArrayList<Category> categories = MCategory.getCategories();
        int categorySelected;

        if (paramCategory != null) {
            try {
                //Si l'utilisateur entre lui même une valeur pour le paramêtre category dans la barre d'adresse
                // alors s'il la catégorie est invalide, alors la catégorie sélectionné deviendra 1 (qui représente toutes les catégories)
                categorySelected = Integer.valueOf(paramCategory);
                if (MCategory.isExist(categorySelected) != 0) {
                    categorySelected = 1;
                }
            } catch (NumberFormatException e) {
                categorySelected = 1;
            }
        } else {
            categorySelected = 1;
        }
        return categorySelected;
    }

    public static void getCategoryById(HttpServletRequest request, HttpServletResponse response) {
        String idCategory = request.getParameter("category_id");
        request.setAttribute("category", MCategory.getCategoryById(Integer.parseInt(idCategory)));
    }

    public static void addCategory(HttpServletRequest request, HttpServletResponse response) {

        if (MCategory.addCategory(new Category(-1,
                request.getParameter("name"),
                request.getParameter("description"),
                Integer.parseInt(request.getParameter("order")),
                Integer.parseInt(request.getParameter("isActive")))) == 1) {
            request.setAttribute("msg", "Categorie ajoutée!");
        } else {
            request.setAttribute("msg", "Category n'est pas ajoutée");
        }
    }
    

    public static void deleteCategory(HttpServletRequest request, HttpServletResponse response) {

        MCategory.deleteCategory(Integer.parseInt(request.getParameter("idCategoryDelete")));

    }

    public static void updateCategory(HttpServletRequest request, HttpServletResponse response) {

        System.out.println(" ESTOY EN action.ActionCategory.updateCategory() CON " + request.getParameter("id") + request.getParameter("name") + request.getParameter("description") + request.getParameter("isActive") + request.getParameter("order"));
        request.setAttribute("categoryUpdated", MCategory.updateCategory(Integer.parseInt(request.getParameter("id")), request.getParameter("name"), request.getParameter("description"), Integer.parseInt(request.getParameter("isActive")), Integer.parseInt(request.getParameter("order"))));
    }
}
