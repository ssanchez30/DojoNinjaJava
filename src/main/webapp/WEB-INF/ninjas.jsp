<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add a Ninja</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

<!-- YOUR own local CSS -->
<link rel="stylesheet" href="./css/style.css" />
</head>
<body>

	<div class="container px-5">

		<c:set var="mensaje" value="${errorMessage }" />
		<c:if test="${mensaje != null }">

			<div
				class="alert alert-${clase} alert-dismissible fade show messageOut"
				role="alert">
				<button type="button" class="btn-close" data-bs-dismiss="alert"
					aria-label="Close"></button>
				<strong><c:out value="${errorMessage }"></c:out></strong>
			</div>
		</c:if>


		<form action="/ninja/create" method="POST" class="bg-dark px-5">

			<h1 class="text-center text-primary pt-3">New Ninja</h1>
			<label for="dojoName" class="form-label text-white">Dojo: </label> <select
				class="form-control mb-2" name="dojo_id">

				<c:forEach var="dojo" items="${dojoList}">

					<option value="${dojo.getId()}">${dojo.getName()}</option>

				</c:forEach>

			</select> <label for="ninjaName" class="form-label text-white">Fist
				Name: </label> <input type="text" id="ninjaName" name="ninjaName"
				class="form-control mb-2"> <label for="ninjaLast"
				class="form-label text-white">Last Name:</label> <input type="text"
				id="ninjaLast" name="ninjaLast" class="form-control mb-2"> <label
				for="ninjaAge" class="form-label text-white">Age:</label> <input
				type="number" id="ninjaAge" name=ninjaAge class="form-control mb-2">
			<div class="d-flex justify-content-between">
				<button type="submit" class="btn btn-primary mt-3 mb-4">Add
					Ninja</button>
				<a href="/" class="btn btn-primary mt-3 mb-4">Home</a>
			</div>


		</form>
	</div>




	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	<script src="./js/script.js"></script>

</body>
</html>