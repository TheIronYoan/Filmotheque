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

				<form class="text-center" method="post" action="<%=request.getServletContext().getContextPath() %>/app/artist/delete" class="form-signin">

					<br />
					<h1 class="h3 mb-3 font-weight-normal">Validez la suppression de </h1>
					<br/>
					<h2 class="h4 mb-3 font-weight-normal">${artist.firstname} ${artist.name} </h2>
					<br/>
					<input type="hidden" name="id" value="
							<c:if test="${!empty artist.id}">
											${artist.id}
							</c:if>
							<c:if test="${empty artist.id}">
											0
							</c:if>
						"/>
		
					<button class="btn btn-lg btn-block btn-danger" type="submit">/!\  Supprimer  /!\ </button> 
					<br />

				</form>
				
			</div>
		</main>

	<%@ include file="./fragments/footer.jsp"%>
</body>

</html>