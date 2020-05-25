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

	<h1 class="text-center">Edition</h1>
		<form action="/TODO/app/edit" method="post">	
			<div class="form-group">
				<label for="name">Nom</label>
	  			<input type="text" class="form-control"  name="name" id="name" aria-describedby="" placeholder="">
				<label for="description">Description</label>
				<textarea class="form-control rounded-0" name="description" id="description" rows="10"></textarea>
			</div>
			<button class="btn btn-lg btn-block btn-secondary" type="submit">Enregistrer</button>
		</form>
		</div>
	</main>

	<%@ include file="./fragments/footer.jsp"%>
</body>

</html>