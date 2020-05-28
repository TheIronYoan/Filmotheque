<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar navbar-expand-lg navbar-dark "  style="background: linear-gradient(#193a53, #192945)">
  <div class="row w-100">
	  	<div class="col-lg-2">
	  		&nbsp;&nbsp;&nbsp;&nbsp;
	  		<a class="navbar-brand" href="<%=request.getServletContext().getContextPath() %>">Filmotheque</a>
	    </div>
	    <div class="col-lg-8 text-center">
	    
	    <c:if test="${user!=null}">
							     
							    
	  		  <a class="btn btn-light btn-outline-primary " href="<%=request.getServletContext().getContextPath() %>/app/film/list">
					Films
				</a> 
				 <a class="btn btn-light btn-outline-primary " href="<%=request.getServletContext().getContextPath() %>/app/artist/list">
					Artistes
				</a>  
				<a class="btn btn-light btn-outline-primary " href="<%=request.getServletContext().getContextPath() %>/app/category/list">
					Categories
				</a>
		  </c:if>
	    </div>
	   	<div class="col-lg-2 float-lg-right">
				  <c:if test="${user!=null}">	
			   <a class="btn btn-light btn-outline-primary float-right" href="<%=request.getServletContext().getContextPath() %>/app/logout">
					Deconnexion
				</a>
			 </c:if>
	     </div>
    </div>
</nav>






