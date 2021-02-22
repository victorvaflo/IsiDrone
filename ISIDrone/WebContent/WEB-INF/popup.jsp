<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="util.Const"%>

<jsp:include page="<%=Const.PATH_HEAD_JSP%>"/>
<jsp:include page="<%=Const.PATH_MENU_JSP%>"/>
<link rel="stylesheet" type="text/css" href="../css/popup.css"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action = "supressionProduit" method = "post">
            <P class ="para"> Est ce que vous voulez vraiment effacer ce produit </P>
           <div class="btn-co">
            <input type ="submit" value ="oui"  name = "action">
            <input type ="submit" value ="non"  name ="action">
            <input name="id" value="<%=request.getParameter("id")%>" hidden>
           </div>
            
        </form>
    </body>
    <!-- Footer -->
<jsp:include page="<%=Const.PATH_FOOTER_JSP%>"/>
</html>
