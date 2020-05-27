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

	<div class="row">
		<div class="col-lg-3">	
		</div>
		<div class="col-lg-6">	
					<div class="row">
					<div class="col-lg-6"  style="padding-left:40px;">
					
								<h1 class="text-center float-left">Categories</h1>
					</div>
					<div class="col-lg-6"  style="padding-right:40px;">
					<a class="btn btn-success float-right" style="padding-right:20px;padding-left:20px;" href="<%=request.getServletContext().getContextPath() %>/app/category/add"> Ajouter Caetgorie</a>
					</div>
					
			</div>
			<table class="table">
			  <thead class="thead-dark" style="background: linear-gradient(#193a53, #192945);color:#ffffff;font-weight:bold">
			    <tr>
					 <td>Id</td>
				 	 <td>Nom</td>
				 	 <td></td>
				 	 <td></td>
				 	
				 	 </tr>
				 	 </thead>
				 	 <tbody>
						<c:forEach items="${categories}" var="category" >
						    <tr>
		
						      <td>${category.id}</td>
						      
						      <td class="w-50">${category.name}</td>
						      
						   
						    
						    	<td class="text-center"><a class="btn btn-secondary" href="<%=request.getServletContext().getContextPath() %>/app/category/edit?id=${film.id}"> Editer</a></td>
						    	<td class="text-center"><a class="btn btn-danger" href="<%=request.getServletContext().getContextPath() %>/app/category/delete?id=${film.id}"> Supprimer</a></td>
					    	</tr>
		
					    </c:forEach>
						      
					  </tbody>
					</table>
					</div>
				
				<div class="col-lg-3">	
				</div>
			</div>	
		</div>
	</main>
		
		
	<%@ include file="./fragments/footer.jsp"%>
</body>

</html>