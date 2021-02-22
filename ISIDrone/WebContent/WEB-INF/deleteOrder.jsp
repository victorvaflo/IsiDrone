<%@page import="util.Const"%>
<%@page import="java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="<%=Const.PATH_HEAD_JSP%>"/>
<jsp:include page="<%=Const.PATH_MENU_JSP%>"/>
<%
    Integer deleteOK=(Integer)request.getAttribute("deleteOk");
    Integer orderId = (Integer)request.getAttribute("orderId");
    if(deleteOK!=null){
if(deleteOK!=1){
    %>
                    <div class="alert alert-info">
                    La commande n'a pas peux etree suprimee
                </div>
        <%
          }else{%>
                    <div class="alert alert-info">
                    La commande est suprimee
                </div>
<%}}else{
        %>
        <div class="container">
         <form action = "historiqueC" method="post" >
        <h2> Voulez-vous supprimer cette Commande? </h2>
        <div class="btn-co">
        <input type ="submit" value ="oui"  name = "action" >
        <input type ="submit" value ="non"  name = "action" >
        <input name="idOrderDelete" value="<%=orderId%>" hidden>
 </div>
    </form>
        </div>
        <%
    }
%>


<jsp:include page="<%=Const.PATH_FOOTER_JSP%>"/>