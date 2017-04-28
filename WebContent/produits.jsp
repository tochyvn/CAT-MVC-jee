<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
		<!-- Optional theme -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" />
		<link rel="stylesheet" href="./public/css/style.css" />
	</head>
	<body class="bottom-buffer">
		<div class="container">
			<div class="row top-buffer">
				<div class="col-lg-12 well">
					<form class="form-inline" method="post" action="post.io">
					  <div class="form-group">
					    <label for="keyword">Produit recherché</label>
					    <input type="text" class="form-control" id="keyword" name="keyword" value="${ model.motCle }">
					  </div>
					  <button type="submit" class="btn btn-default">Submit</button>
					</form>
				</div>
				
			</div>
			
			<div class="row well top-buffer">
				<table class="table table-inverse table-striped">
				 <thead class="thead-inverse">
				   <tr>
				     <th>Reference</th>
				     <th>Designation</th>
				     <th>Prix</th>
				     <th>Quantité</th>
				   </tr>
				 </thead>
				 <tbody>
				 <c:forEach items="${ model.produits }" var="produit">
				    <tr>
				    	<td><c:out value="${ produit.reference }">null</c:out></td>
				    	<td><c:out value="${ produit.designation }">null</c:out></td>
				    	<td><c:out value="${ produit.prix }">null</c:out></td>
				    	<td><c:out value="${ produit.quantite }">null</c:out></td>
				    </tr>
				    </c:forEach>	
				 </tbody>
				</table>
			</div>
			
		</div>
	</body>
</html>