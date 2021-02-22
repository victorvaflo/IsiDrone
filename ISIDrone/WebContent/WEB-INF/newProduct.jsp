<%-- 
    Document   : newProduct.jsp
    Created on : Jan 13, 2021, 2:44:48 PM
    Author     : istreich
--%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="manager.MDB"%>
<%@page import="java.util.Locale.Category"%>
<%@page import="action.ActionItems"%>
<%@page import="java.util.Iterator"%>
<%@page import="entities.Item"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="util.Const"%>

<%
    @SuppressWarnings(
    
    "unchecked")
        String msg = (String) request.getAttribute("msg");
    ArrayList<Category> categories = (ArrayList<Category>) request.getAttribute("categories");
     ArrayList<Item> items = (ArrayList<Item>) request.getAttribute("items");


%>
<jsp:include page="<%=Const.PATH_HEAD_JSP%>"/>
<jsp:include page="<%=Const.PATH_MENU_JSP%>"/>

<div class="container">
    <%
        if (msg == null) {
    %>
    <form action="newProductsAdmin" method="post" >
        <h2>Formulaire pour ajouter un produit </h2>

        <div class="form-group">
            <div class="col-sm-10">
                <label for="name" class="col-sm-2 control-label">*Nom</label>
                <input type="text" id="name" class="form-control" name="name" required />
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-10">
                <label for="category" class="col-sm-2 control-label">*Categorie</label>
                <!--<input type="number" id="category" class="form-control" name="category" required />-->
<!--                <select name="category" id="category" class="form-control">
                    <option value="0">Non</option>
                    <option value="1">Oui</option>
                </select>-->
  <%
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String mysqlURL = "jdbc:mysql://127.0.0.1:3306/isidrone?serverTimezone=UTC";
                Connection connection = DriverManager.getConnection(mysqlURL, "root", "abc123...");
                Statement st = connection.createStatement();
                String query = "SELECT * FROM category";
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    String name, category, price, stockQty;
                    int id;
                    name = rs.getString("name").trim();
               

                    %> 
<select name="category" id="category" class="form-control">
        <%  while(rs.next()){ %>
        <option value="<%= rs.getInt("id")%>"><%= rs.getString("name")%></option>
        <% } %>
        </select>
         <% } %>   
        <%
    } catch (Exception ex) {
        out.println(ex);
    }
%>
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-10">
                <label for="description " class="col-sm-2 control-label">*Description </label>
                <input type="text" id="description" class="form-control" name="description" required />
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-10">
                <label for="price" class="col-sm-2 control-label">*Prix </label>
                <input type="number" id="price" class="form-control" name="price" step="any" required/>
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-10">
                <label for="serial" class="col-sm-2 control-label">*Numero de série </label>
                <input type="text" id="serial" class="form-control" name="serial" required />
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-10">
                <label for="stock" class="col-sm-2 control-label">*Quantité en stock </label>
                <input type="number" id="stock" class="form-control" name="stock" required />
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-10">
                <label for="image" class="col-sm-2 control-label">*Image</label>
                <!--<input type="file" name="image" class="form-control">-->
                <img style="max-width: 250px; max-height: 250px; min-width: 250px;" src="images/products/1.jpg" alt="Image du produit" />
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-10">
                <label for="isActive" class="col-sm-2 control-label">*Produit actif ou pas </label>
                <select name="isActive" id="isActive" class="form-control">
                    <option value="">--Please choose an option--</option>
                    <option value="0">Non</option>
                    <option value="1">Oui</option>
                </select>
            </div>
        </div>

        <div class="form-group text-center" style="clear: left; top: 15px; margin-bottom: 15px;">
            <div class="col-sm-10">
                <button type="submit" class="btn btn-default">Sauvegarder</button>
            </div>
        </div>
    </form> 
    <%}else{%> <h3><%= msg %></h3><%
}
    %>
</div>

<jsp:include page="<%=Const.PATH_FOOTER_JSP%>"/>


