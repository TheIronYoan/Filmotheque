<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<jsp:include page="/WEB-INF/jsp/fragments/head.jsp"></jsp:include>

<body>

	<%@ include file="/WEB-INF/jsp/fragments/header.jsp"%>
	
			<br><br>
	<main role="main">

		<div class="container myMainContainer">


	<h1 class="text-center">Films </h1>
	
	<h2>${userLogged.username}</h2>

	<table class="table">
		 	 <tbody>
		 	 <tr>
		 	 <td>Id</td>
		 	 <td>Nom</td>
		 	 <td>Année</td>
		 	 <td>Catégorie</td>
		 	 <td>Réalisateur</td>
		 	 <td>Acteur principal</td>
		 	 <td></td>
		 	 <td></td>
		 	 </tr>
				<c:forEach items="${films}" var="film" >
				    <tr>

				      <td>${film.id}</td>
				      
				      <td>${film.name}</td>
				      
				      <td>${film.releaseDate}</td>
				      
				      <td><c:if test="${not empty film.category}">
				      	${film.category}
				      </c:if></td>
				      
				      <td><c:if test="${not empty film.director}">
				      	${film.director}
				      </c:if></td>
				      
				      <td><c:if test="${not empty  film.actors}">
				      	${film.actors[0]}
				      </c:if></td>
				    
				    <td><a href="<%=request.getServletContext().getContextPath() %>/app/edit?film=${film.id}"> Editer</a></td>
				      <td><a href="<%=request.getServletContext().getContextPath() %>/app/delete?film=${film.id}"> Supprimer</a></td>
			    	</tr>

			    </c:forEach>
				      
			  </tbody>
			</table>
		</div>
	</main>
		
		
	<%@ include file="./fragments/footer.jsp"%>
</body>

</html>