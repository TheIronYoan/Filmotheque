<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<jsp:include page="/WEB-INF/jsp/fragments/head.jsp"></jsp:include>

<body>

	<%@ include file="/WEB-INF/jsp/fragments/header.jsp"%>
	
			<br/>
		
			<br/>
	<main role="main">

		<div class=" myMainContainer">
			<div class="row">
				<div class="col-lg-1">
				</div>
				
				<div class="col-lg-10">
				<div class="row">
						<div class="col-lg-6"  style="padding-left:40px;">
						
									<h1 class="text-center float-left">Films </h1>
						</div>
						<div class="col-lg-6"  style="padding-right:70px;">
						<a class="btn btn-success float-right" style="padding-right:60px;padding-left:60px;" href="<%=request.getServletContext().getContextPath() %>/app/film/search"> Rechercher Film</a>
						<a class="btn btn-success float-right" style="padding-right:60px;padding-left:60px;" href="<%=request.getServletContext().getContextPath() %>/app/film/add"> Ajouter Film</a>
						</div>
						
				</div>
				<table class="table">
				  <thead class="thead-dark" style="background: linear-gradient(#193a53, #192945);color:#ffffff;font-weight:bold">
				    <tr>
							 	 <td>Id</td>
							 	 <td>Nom</td>
							 	 <td>Année</td>
							 	 <td>Catégorie</td>
							 	 <td class=" text-center">Réalisateur</td>
							 	 <td class=" text-center w-25">Acteur principal</td>
							 	 <td></td>
							 	 <td></td>
							 	 <td></td>
						 	  </tr>
							  </thead>
							  <tbody>
								<c:forEach items="${films}" var="film" >
							    <tr>
			
							      <td>
								        ${film.id}
								     
							      </td>
							      
							     <td class="w-25">
								       ${film.name}
								    
							      </td>
							      
							      <td>${film.releaseDate}</td>
							      
							      <td><c:if test="${not empty film.category}">
							      	${film.category.name}
							      </c:if></td>
							      
							      <td><c:if test="${not empty film.director}">
							      	${film.director.firstname} ${film.director.name}
							      </c:if></td>


							      <td class=" text-center w-25">
							      <c:if test="${not empty film.actors}">

							      	${film.actors[0].firstname} ${film.actors[0].name}
							      </c:if></td>
							    <td class="text-center"><a class="btn btn-secondary"  href="<%=request.getServletContext().getContextPath() %>/app/film/show?id=${film.id}"> Voir&nbsp;Fiche</a></td>
							   
							 	<td class="text-center"><a class="btn btn-secondary"  href="<%=request.getServletContext().getContextPath() %>/app/film/edit?id=${film.id}"> Editer</a></td>
							     	<td class="text-center"><a class="btn btn-danger"  href="<%=request.getServletContext().getContextPath() %>/app/film/delete?id=${film.id}"> Supprimer</a></td>
						    	</tr>
			
						    </c:forEach>
							      
						  </tbody>
						</table>
					</div>
				<div class="col-lg-1">	
				</div>
				
				
		</div>
		</div>
	</main>
		
	<%@ include file="./fragments/footer.jsp"%>
</body>

</html>