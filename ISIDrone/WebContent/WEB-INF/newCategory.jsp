<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="manager.MDB"%>
<%@page import="action.ActionItems"%>
<%@page import="java.util.Iterator"%>
<%@page import="entities.Item"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="util.Const"%>
<%@ page import="entities.Category"%>

<%
    @SuppressWarnings("unchecked")
    String msg = (String) request.getAttribute("msg");
%>
<jsp:include page="<%=Const.PATH_HEAD_JSP%>"/>
<jsp:include page="<%=Const.PATH_MENU_JSP%>"/>
<div class="container">
    <%
        if (msg == null) {
    %>
    <form action="newCategory" method="post" >
        <h4>Ajouter une catégorie</h4>

        <div class="form-group">
            <div class="col-sm-10">
                <label for="name" class="col-sm-2 control-label">* Nom</label>
                <input type="text" id="name" class="form-control" name="name" required />
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-10">
                <label for="descriction" class="col-sm-2 control-label">* Description</label>
                <input type="text" id="description" class="form-control" name="description" required />
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-10">
                <label for="order" class="col-sm-2 control-label">* Position</label>
                <input type="text" id="order" class="form-control" name="order" required />
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-10">
                <label for="isActive" class="col-sm-2 control-label">* Actif</label>
                <select name="isActive" id="isActive" class="form-control" >
                    <option value="">Faites votre choix :</option>
                    <option value="0">NON</option>
                    <option value="1">OUI</option>
                </select>
            </div>
        </div>
        <div class="form-group text-center" style="clear: left; top: 15px; margin-bottom: 15px;">
            <div class="col-sm-10">
                <button type="submit" class="btn btn-info">Sauvegarder</button>
            </div>
        </div>
    </form> 
    <%} else {%> <h3><%= msg%></h3><%
        }
    %>
</div>
<jsp:include page="<%=Const.PATH_FOOTER_JSP%>"/>
