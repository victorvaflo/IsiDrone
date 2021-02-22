<%-- 
    Document   : deletePopup
    Created on : Jan 18, 2021, 9:12:26 AM
    Author     : istreich
--%>


<%@page import="entities.Category"%>
<%@page import="java.util.Iterator"%>
<%@page import="entities.Item"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="util.Const"%>

<%
    @SuppressWarnings("unchecked")
    Category category =(Category)request.getAttribute("category");
    String monId =request.getParameter("category_id");
    String msg =(String)request.getAttribute("msg");
%>


<jsp:include page="<%=Const.PATH_HEAD_JSP%>"/>
<jsp:include page="<%=Const.PATH_MENU_JSP%>"/>
<div class="container">
  
<%
if(msg!=null){%>
<div class="alert alert-info">
    <h2>Votre catégorie a été supprimée</h2>
 <a href="listCategories"> Retour à la liste Categorie </a>
</div>

<%}else{
if(category!=null){%>
<div class="alert alert-danger">
    <form action = "deleteCategorie" method="post" >
        <h2> Voulez-vous supprimer cette categorie? </h2>
        <div class="btn-co">
        <input type ="submit" value ="oui"  name = "action" >
        <input type ="submit" value ="non"  name = "action" >
        <input name="idCategoryDelete" value="<%=monId%>" hidden>
 </div>
    </form>
</div>
    
<%}else{%>
                <div class="alert alert-danger">
                    Aucune Categorie ne correspond à votre demande.
                </div>
<%}}%>
</div>

<jsp:include page="<%=Const.PATH_FOOTER_JSP%>"/>