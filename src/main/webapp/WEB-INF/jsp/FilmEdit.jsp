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
<h1>Nouvel Artiste</h1>
	<form action="add" method="POST"  >
		<label>Nom: </label><input type="text" name="name"  required=true/><br>
		<label>Année de sortie: </label><input type="number" name="release"  required=true/><br>
		<select name="cat">
			<c:forEach items="${cats}" var="cat" >
			<option value="${cat.id}">${cat.name}</option>
			</c:forEach>
		</select>
		<select name="director">
			<c:forEach items="${directors}" var="director" >
			<option value="${director.id}">${director.name} ${director.firstname}</option>
			</c:forEach>
		</select><br>
		<input type="hidden" value="${numAct}" name="numAct">
		<c:forEach begin="0" end="${numAct}" var="loop">
			<select name="actors[]" value="${loop}">
				<c:forEach items="${actors}" var="actor" >
				<option value="${actor.id}">${actor.name} ${actor.firstname}</option>
				</c:forEach>
			</select>
		</c:forEach>
		<button type="submit" name="action" value="plus" >+</button>
		<br><br>
		<button type="submit" name="action" value="enregistrer" >Enregistrer</button>
		<button type="submit" name="action" value="annuler"  >Annuler</button>
	</form>	

<%@ include file="./fragments/footer.jsp"%>
</body>
</html>