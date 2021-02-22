<%-- 
    Document   : listOrders
    Created on : 19 janv. 2021, 19 h 48 min 56 s
    Author     : aelmeski
--%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="manager.MDB"%>
<%@page import="action.ActionCategory"%>

<%@page import="entities.Category"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="util.Const"%>
<link rel="stylesheet" type="text/css" href="../css/shop-homepage.css"/>
<jsp:include page="<%=Const.PATH_HEAD_JSP%>"/>
<jsp:include page="<%=Const.PATH_MENU_JSP%>"/>
<div class="container">    
    <table class="table">
        <tr>
            <th>LastName</th> 
            <th>FirstName </th> 
            <th>Date</th> 
            <th>Action</th>
            
        </tr>
        <%
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String mysqlURL = "jdbc:mysql://127.0.0.1:3306/isidrone?serverTimezone=UTC";
                Connection connection = DriverManager.getConnection(mysqlURL, "root", "abc123...");
                Statement st = connection.createStatement();
                String query = "select  user.lastName, user.firstName,`order`.date from user join `order` on user.id = `order`.id";
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    String order ,lastName, firstName, date;
                    int id;
                  order= rs.getString("order").trim();
                    lastName = rs.getString("lastName").trim();
                    firstName = rs.getString("firstName").trim();
                    date = rs.getString("date").trim();
                    id = rs.getInt("id");
        %> 
        <tr>
             <td><%=order%></td>
            <td><%=lastName%></td>
            <td><%=firstName%></td>
            <td><%=date%></td>
            <td> 
                <button><a href=""><span class="glyphicon glyphicon-remove-sign"></span></a></button>
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