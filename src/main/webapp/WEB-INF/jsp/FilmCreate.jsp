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

	<br><br>
	<main role="main">

		<div class="container myMainContainer">	<div class="row">
		<div class="col-lg-2">	
		</div>
		<div class="col-lg-8">	
	
			<h1 class="text-center">Creation Film </h1>
				<form action="add" method="POST"  class="form"  >
			  <div class="form-group">
				<label>Nom: </label>
				<input type="text" name="name"  class="form-control" /><br>
				
				<label>Année de sortie: </label>
				<input type="number" name="release" value="2000" class="form-control"/><br>
			
				<label>Categorie : </label>
				<select name="cat">
					<c:forEach items="${cats}" var="cat" >
					<option value="${cat.id}">${cat.name}</option>
					</c:forEach>
				</select>
				<br />
				<label>Realisateur : </label>
				<select name="director">
					<c:forEach items="${directors}" var="director" >
					<option value="${director.id}"> ${director.firstname} ${director.name}</option>
					</c:forEach>
				</select><br>
				
				<label>Distribution : </label>
				<input type="hidden" value="${numAct}" name="numAct">
				<c:forEach begin="0" end="${numAct}" var="loop">
					<select name="actors[]" value="${loop}">
						<c:forEach items="${actors}" var="actor" >
						<option value="${actor.id}"> ${actor.firstname} ${actor.name}</option>
						</c:forEach> 
					</select>
				</c:forEach>
				<button type="submit" name="action" value="plus" >+</button>
				<button type="submit" name="action" value="minus" >-</button>
				<br><br>
				<button type="submit" name="action" value="enregistrer" >Enregistrer</button>
				<button type="submit" name="action" value="annuler"  >Annuler</button>
				</div>
			</form>	
					
			
		</div>	
		<div class="col-lg-2">	
		</div>
			
		
		</div>
	</main>

<%@ include file="./fragments/footer.jsp"%>
</body>
</html>