<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="entities.Item"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="util.Const"%>
<%@ page import="util.Misc"%>


<%
@SuppressWarnings("unchecked")

String msg =(String)request.getAttribute("msg");

Item item = (Item)request.getAttribute("produit_unique");
%>

<jsp:include page="<%=Const.PATH_HEAD_JSP%>"/>
<jsp:include page="<%=Const.PATH_MENU_JSP%>"/>
<!-- Page content -->


<div class="container">
    
    <%
if(msg ==null){
        %>
    <form action="editProduct" method="post" class="panel panel-primary form-horizontal" style="float: unset; margin: auto;">
           <h2>Formulaire pour editer  un produit </h2>
        <div class="panel-heading">
            <h3 class="panel-title">Edit Products</h3>
        </div>
        <div class="panel-body">
            <fieldset class="col-sm-10 col-lg-10 col-md-10">
                <legend>Informations  produit</legend>
                <div class="form-group">
                    <label for="nom">Nom </label>
                    <input type="text" id="nom" class="form-control" name="nom" value="<%= item.getName() %>"  required />
                </div>
                
                <div class="form-group">
                    <label for="categorie">Categorie </label>
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
<select name="categorie" id="category" class="form-control">
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
                
                
                <div class="form-group">
                    <label for="description">description </label>
                    <input type="text" id="description" class="form-control" name="description" placeholder="description du produit" value="<%= item.getDescription()%>"  required />
                </div>
                <div class="form-group">
                    <label for="prix">Prix </label>
                    <input type="number" step="any" id="prix" class="form-control" name="prix" value="<%= item.getPrice()%>" required />
                </div>
                <div class="form-group">
                    <label for="numero_de_serie">Numero De Serie </label>
                    <input type="text" id="numero_de_serie" class="form-control" name="numero_de_serie" value="<%= item.getSerial()%>" required />
                </div>
                <div class="form-group">
                    <label for="quantite_en_stock"> Quantite </label>
                    <input type="number" step="any"" id="quantite_en_stock" class="form-control" name="quantite_en_stock" placeholder="Quantite du produit"value="<%= item.getStock()%>"  required />
                </div>
                <div class="form-group">
                    <label for="produit_actif">*Produit actif ou pas </label>
                <select name="produit_actif" id="produit_actif" class="form-control">
                    <option value="">--Please choose an option--</option>
                    <option value="0">Non</option>
                    <option value="1">Oui</option>
                </select>
                </div>
                <input type="hidden" id="produit_id" class="form-control" name="produit_id" value="<%= item.getId()%>"  required />
                
                <input type="submit" class="btn btn-default" value ="modifier" name ="action2" /> 
            </fieldset>
        </div>
    </form>
    <%}else{%> <h3><%= msg %></h3><%
}
%>

    <!-- <a href="login?action=resetPassword" style="clear: left;">Mot de passe oublie ?</a><br /> -->
</div>
<jsp:include page="<%=Const.PATH_FOOTER_JSP%>"/>