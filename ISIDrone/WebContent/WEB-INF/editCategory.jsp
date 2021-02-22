<%-- 
    Document   : editCategory
    Created on : Jan. 17, 2021, 9:57:02 p.m.
    Author     : vvargasf
--%>
<%@page import="entities.Category"%>
<%@page import="java.util.Iterator"%>
<%@page import="util.Const"%>
<jsp:include page="<%=Const.PATH_HEAD_JSP%>"/>
<jsp:include page="<%=Const.PATH_MENU_JSP%>"/>
<div class="container">
    <%
        Category category = (Category) request.getAttribute("category");
        Boolean allOk = (Boolean) request.getAttribute("categoryUpdated");
        if (allOk != null) {
            if (!allOk) {
    %>
    <div class="alert alert-info">
        La Categorie n'a pas peut change
    </div>
    <%} else {%>
    <div class="alert alert-info">
        La Categorie a change
    </div>
    <%}
    } else {
        if (category != null) {
    %>
    <form action="editCategory" method="post" >
        <h2>Formulaire pour Modifier une Categorie <%=category.getIsActive() + category.getName() + category.getOrder()%></h2>

        <div class="form-group">
            <div class="col-sm-10">
                <label for="name" class="col-sm-2 control-label">*Nom</label>
                <input type="text" id="name" class="form-control" name="name" value="<%=category.getName()%>" required />
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-10">
                <label for="description" class="col-sm-2 control-label">*Description</label>
                <input type="text" id="description" class="form-control" name="description" value="<%=category.getDescription()%>"  />
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-10">
                <label for="order " class="col-sm-2 control-label">*Order </label>
                <input type="number" id="order" class="form-control" name="order" value="<%=category.getOrder()%>" required />
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-10">
                <label for="isActive" class="col-sm-2 control-label">*Category actif ou pas </label>
                <%
                    if (category.getIsActive() == 1) {
                %>
                <select name="isActive" id="isActive" class="form-control">
                    <option value="0">Non</option>
                    <option value="1" selected="selected">Oui</option>
                </select>
                <%} else {%>
                <select name="isActive" id="isActive" class="form-control">
                    <option value="0" selected="selected">Non</option>
                    <option value="1" >Oui</option>
                </select>
                <%}%>
            </div>
        </div>

        <div class="form-group text-center" style="clear: left; top: 15px; margin-bottom: 15px;">
            <div class="col-sm-10">
                <button type="submit" class="btn btn-default">Sauvegarder</button>
            </div>
        </div>
        <input name="id" value="<%=category.getId()%>" hidden>
    </form> 
    <%} else {%>
    <div class="alert alert-info">
        Aucune Categorie ne correspond à votre demande.
    </div>
    <%}
    }%>
</div>
<jsp:include page="<%=Const.PATH_FOOTER_JSP%>"/>
