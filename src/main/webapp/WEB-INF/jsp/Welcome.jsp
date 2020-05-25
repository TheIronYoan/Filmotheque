<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<jsp:include page="/WEB-INF/jsp/fragments/head.jsp"></jsp:include>

<body>

	<%@ include file="/WEB-INF/jsp/fragments/header.jsp"%>
	
	
		<br><br>
		<main role="main">
			<div class="container myMainContainer">

				
			<div class="card col-8 col-md-6 col-lg-4" style="background-color: #f2f2f2; margin: auto;">

				<form method="post" action="<%=request.getServletContext().getContextPath() %>/app/login" class="form-signin">

					<br />
					<h1 class="h3 mb-3 font-weight-normal">&nbsp;&nbsp;Identifiez vous</h1>

					<label for="inputID" class="sr-only">Identifiant </label> 
					<input type="name" id="inputName" class="form-control" 	placeholder="identifiant" name="pseudo" required autofocus>
					<br />
					<label for="inputPassword" class="sr-only">Mot de passe</label> 
					<input type="password" id="inputPassword" class="form-control" name="mdp" placeholder="Mot de passe" required> <br /> 
						

					<button class="btn btn-lg btn-block btn-secondary" type="submit">Connexion</button> 
					<br />

				</form>
				
			</div>
		</main>

	<%@ include file="./fragments/footer.jsp"%>
</body>

</html>