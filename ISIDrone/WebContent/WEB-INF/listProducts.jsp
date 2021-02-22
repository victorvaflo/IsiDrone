<%@page import="entities.Item"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="manager.MDB"%>
<%@page import="action.ActionCategory"%>
<%@page import="action.ActionEditProduct"%>

<%@page import="entities.Category"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="util.Const"%>
<link rel="stylesheet" type="text/css" href="../css/shop-homepage.css"/>
<jsp:include page="<%=Const.PATH_HEAD_JSP%>"/>
<jsp:include page="<%=Const.PATH_MENU_JSP%>"/>
<div class="container">    
    <table class="table">
        <tr>
            <th>Nom</th> 
            <th>Catégorie</th> 
            <th>Prix</th> 
            <th>Quantité</th> 
            <th>Action</th> 
        </tr>
        <%
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String mysqlURL = "jdbc:mysql://127.0.0.1:3306/isidrone?serverTimezone=UTC";
                Connection connection = DriverManager.getConnection(mysqlURL, "root", "abc123...");
                Statement st = connection.createStatement();
                String query = "SELECT * FROM product";
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    String name, category, price, stockQty;
                    int id;
                    name = rs.getString("name").trim();
                    category = rs.getString("category").trim();
                    price = rs.getString("price").trim();
                    stockQty = rs.getString("stockQty").trim();
                    id = rs.getInt("id");
                    
   Item item = (Item)request.getAttribute("produit_unique");
        %> 
        <tr>
            <td><%=name%></td>
            <td><%=category%></td>
            <td><%=price%></td>
            <td><%=stockQty%></td>
            <td> 

                <a href="popup?id=<%=id%>"><span class="glyphicon glyphicon-remove-sign"></span></a>
                <a href="editProduct?product=<%=id%>"><span class="glyphicon glyphicon-edit"></span></a>           

            </td> 
        </tr> 
        <% } %>   
    </table>
</div>
<%
    } catch (Exception ex) {
        out.println(ex);
    }
%>
<jsp:include page="<%=Const.PATH_FOOTER_JSP%>"/>