<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar navbar-expand-lg navbar-dark ironnavbar"  style="background: linear-gradient(#193a53, #192945)">
  <div class="row w-100">
	  	<div class="col-lg-1">
	  		<a class="navbar-brand" href="<%=request.getServletContext().getContextPath() %>">Filmotheque</a>
	    </div>
	    <div class="col-lg-10 text-center">
	  		  <a class="btn btn-light btn-outline-primary float-left" href="<%=request.getServletContext().getContextPath() %>/app/logout">
					Films
				</a> 
				 <a class="btn btn-light btn-outline-primary float-left" href="<%=request.getServletContext().getContextPath() %>/app/logout">
					Artistes
				</a>  
				<a class="btn btn-light btn-outline-primary float-left" href="<%=request.getServletContext().getContextPath() %>/app/logout">
					Categories
				</a>
	    </div>
	   	<div class="col-lg-1 float-left"  style="background:#19ff45;">
					
			   <a class="btn btn-light btn-outline-primary" href="<%=request.getServletContext().getContextPath() %>/app/logout">
					Deconnexion
				</a>
			 
	     </div>
    </div>
</nav>






