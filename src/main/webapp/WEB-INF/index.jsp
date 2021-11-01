<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html xmlns:th="http://www.thymeLeaf.org">
<head>
<meta charset="UTF-8">
<title>List of Ninjas</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="./css/style.css" />
</head>
<body>






	<div class="container">

		<c:forEach var="dojo" items="${dojoList}">

			<h1 class="text-center py-3 text-primary">
				<c:out value="${dojo.getName()}"></c:out>
				Ninjas
			</h1>

		</c:forEach>

		<table class="table table-hover">
			<thead>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Age</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="dojo" items="${dojoList}">

					<c:forEach var="ninja" items="${dojo.getNinjas()}">

						<tr>
							<td><c:out value="${ninja.getFirstname()}"></c:out></td>
							<td><c:out value="${ninja.getLastname()}"></c:out></td>
							<td><c:out value="${ninja.getAge()}"></c:out></td>
						</tr>
					</c:forEach>

				</c:forEach>
			</tbody>
		</table>

		<a href="/" class="btn btn-primary text-decoration-none">Home</a>

	</div>



	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	<script src="./js/script.js"></script>

</body>
</html>