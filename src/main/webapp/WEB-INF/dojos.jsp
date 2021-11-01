<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dojo Page</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

<!-- YOUR own local CSS -->
<link rel="stylesheet" href="./css/style.css" />
</head>
<body>



	<div class="container">


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


		<div class="row">

			<div class="col-6 d-flex flex-row justify-content-center">



				<div class="col mt-5 mx-5">
					<div class="bg-dark py-5">
						<h1 class="text-center py-2 text-primary">New Dojo</h1>

						<form action="/dojo/create" method="POST" class="px-5">
							<label for="dojoName" class="form-label text-white">Name:</label>
							<input type="text" name="dojoName" id="dojoName"
								class="form-control">
							<div class="d-flex flex-row justify-content-between">
								<button type="submit" class="btn text-white bg-dark py-4">Add
									Dojo</button>
								<a href="/ninja/add" class="btn text-white bg-dark py-4">Add
									Ninja</a>
							</div>
						</form>
					</div>
				</div>
			</div>

			<div class="col-6 d-flex flex-row justify-content-center">

				<div class="col py-5">
					<div class="bg-dark py-5">
						<h1 class="text-center py-2 text-primary">All Dojos</h1>

						<div class="d-flex flex-column align-items-center">

							<c:forEach var="dojo" items="${dojoList}">

								<a href="/dojo/${dojo.getId()}"
									class="mb-2 text-warning text-decoration-none"><c:out
										value="${dojo.getName()}"></c:out></a>

							</c:forEach>



						</div>
					</div>
				</div>

			</div>

		</div>

	</div>



	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	<script src="./js/script.js"></script>

</body>
</html>