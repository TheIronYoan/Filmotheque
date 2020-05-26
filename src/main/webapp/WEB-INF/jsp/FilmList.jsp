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

	<h1 class="text-center">Films</h1>
	
	<table class="table">
		 	 <tbody>
				<c:forEach items="${films}" var="film" >
				    <tr>
				      <th scope="row" class="text-center">${todo.description}</th>
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