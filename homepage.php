<?php
	session_start();
	if(isset($_SESSION['name'])){ 
?>
		<!DOCTYPE html>
		<html>
		<head>
			<title>Home Page</title>
		</head>
		<body>

			<h1>Welcome Home....</h1> <a href="logout.php">logout</a>
		</body>
		</html>		

<?php }else{
	header("location: login.php");
} ?>

