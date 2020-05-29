<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="/WEB-INF/jsp/fragments/head.jsp"></jsp:include>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Créer un Artiste</title>
</head>
<body>
<%@ include file="/WEB-INF/jsp/fragments/header.jsp"%>
<main role="main">
		<div class="container myMainContainer">
		<div class="row">
				<div class="col-lg-odelAttribute User user,3">	
				</div>
				<div class="col-lg-6">	
				<br/><br/>
					<h1>Edition Categorie</h1>
						<form action="add" method="POST"  >
						<input type="hidden" name="id" value="
							<c:if test="${!empty category.id}">
											${category.id}
							</c:if>
							<c:if test="${empty category.id}">
											0
							</c:if>
						"/>
						<label>Type de Catégorie: </label>
						<input type="text" name="cat" value="${category.name}"/><br>
						<br/>
						<button type="submit" name="action" value="enregistrer" >Enregistrer</button>
						<button type="submit" name="action" value="annuler"  >Annuler</button>
					</form>	
				</div>
				<div class="col-lg-3">	
				</div>

<%@ include file="./fragments/footer.jsp"%>
</body>
</html>