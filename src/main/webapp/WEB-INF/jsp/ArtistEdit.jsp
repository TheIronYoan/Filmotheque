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
				<div class="col-lg-3">	
				</div>
				<div class="col-lg-6">	
	
					<h1 class="text-center">Edition artiste 
					 </h1>
						<form action="edit" method="POST"  >
						<input type="hidden" name="id" value="
							<c:if test="${!empty artist.id}">
											${artist.id}
							</c:if>
							<c:if test="${empty artist.id}">
											0
							</c:if>
						"/>
							<label>Prenom: </label>
							<input type="text" name="firstname" required="true" value="${artist.firstname}"/><br>
							<label>Nom: </label>
							<input type="text" name="name" required="true" value="${artist.name}"/><br>
							<label>Realisateur: </label>
							<input type="checkbox" name="director"  value="true"
								<c:if test="${artist.director}">
										checked 
								</c:if>
							/>	
							<label>Acteur: </label>
							<input type="checkbox" name="actor" value="true" 
							<c:if test="${artist.actor}">
										checked 
							</c:if>
							/><br>
							<label>Date de naissance: </label>
							<input type="date" name="birth"   required="true" value="${birthDate}" /><br>
							<label>Nationalité: </label>
							<input type="text" name="nation"  required="true" value="${artist.nationality}"/><br>
							<br>
							
							
							<button type="submit" name="action" value="enregistrer" >Enregistrer</button>
							<button type="submit" name="action" value="annuler"  >Annuler</button>
						</form>	
				</div>
				<div class="col-lg-3">	
				</div>
			</div>	
		</div>
	</main>

	<%@ include file="./fragments/footer.jsp"%>
</body>

</html>