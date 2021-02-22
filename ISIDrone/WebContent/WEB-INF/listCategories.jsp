
<%@page import="entities.Category"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="util.Const"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
@SuppressWarnings("unchecked")
	ArrayList<Category> categories = (ArrayList<Category>) request.getAttribute("categories");

    %>
<jsp:include page="<%=Const.PATH_HEAD_JSP%>"/>
<jsp:include page="<%=Const.PATH_MENU_JSP%>"/>
<div class="container">
      
	<div class="row">
    	<div class="col-md-12">
    		<div class="panel panel-default">
    			<div class="panel-heading">
    				<h3 class="panel-title"><strong>List des categories</strong></h3>
    			</div>
    			<div>
    				<div class="table-responsive">
    					<table class="table table-condensed">
    						<%
    							if(categories != null){
    						%>
    						<thead>
                                <tr>
        							<td><strong>Nom</strong></td>
        							<td class="text-center"><strong>Order</strong></td>
                                                                <td class="text-center"><strong>Actions</strong></td>
                                </tr>
    						</thead>
                                                <%
    							int i = 0;
    							for(Category category: categories){
    								i++;
    						%>
    							
	    							<tr>
                                                                    <td style="hover"><%=category.getIsActive()%></td>
	    								<td style="hover"><%=category.getName()%></td>
	    								<td class="text-center"><%=category.getOrder()%></td>
                                                                        <td class="text-center">

                                                                           <a href="deleteCategorie?category_id=<%=category.getId()%>"><span class="glyphicon glyphicon-remove-sign"></span></a>
                                                                           <a href="editCategory?category_id=<%=category.getId()%>"><span class="glyphicon glyphicon-edit"></span></a>

                                                                        </td>
	    							</tr>
    							
    						<%	
    							}
    						%>
    						<%
    							}else{
    						%>
    							<span>Aucune categorie</span>
    						<%
    							}
    						%>
    						
    					</table>
    				</div>
    			</div>
			</div>
		</div>
	</div>
 
</div>
<jsp:include page="<%=Const.PATH_FOOTER_JSP%>"/>
