<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<title>Login</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<style>
body {
	background-image:
		url("http://mapiraj.me/wp-content/uploads/2018/04/website-background-images-1.jpg");
	background-repeat: no-repeat;
	background-size: cover;
	background-position: center;
	background-attachment: fixed;
	height: 100%;
}
</style>

<body>

	<div class="container row">
		<div class="container" align="center">
			<h1>Welcome HR</h1>

			<div class="col-sm-8"></div>
			<div class="col-sm-4 h-100 d-flex">
				<div class="align-self-center">
					<h3 class="text-info font-weight-light mb-4">Login</h3>


					<form method="post" action="signin">
						<input type="text" name="username" required="required"
							placeholder="username" /> <br>
						<br> <input type="password" name="password"
							required="required" placeholder="password" /> <br>
						<br> <input type="submit" value="LOGIN">
					</form>
					<p> ${msg} </p>
				</div>
			</div>
		</div>
	</div>
</body>
</html>