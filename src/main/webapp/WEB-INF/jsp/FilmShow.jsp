<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<jsp:include page="/WEB-INF/jsp/fragments/head.jsp"></jsp:include>

<body>

	<%@ include file="./fragments/header.jsp"%>
	
	
		<br><br>
	<main role="main">

		<div class="container myMainContainer">
		<div class="row">
				<div class="col-lg-4">	
				</div>
				<div class="col-lg-4">	
					
					
					<h1 class="text-center">Fiche d'un film</h1>
					
							<br/>	Titre : ${film.name}
							<br/>	Année de Sortie : ${film.releaseDate}
							<br/>	Realisateur :${film.director.name}  ${film.director.name}
								
								
							<c:forEach items="${film.actors}" var="actor" >
							<br/> ${actor.firstname} ${actor.name}
							</c:forEach> 
									
				</div>
				<div class="col-lg-4">	
				</div>
		</div>
	</main>

	<%@ include file="./fragments/footer.jsp"%>
</body>

</html>