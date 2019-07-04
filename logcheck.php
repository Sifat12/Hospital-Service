<?php
	session_start();

	if(isset($_REQUEST['submit']))
	{

		$name = trim($_REQUEST['uname']);
		$pass = trim($_REQUEST['pass']);
		
		if($name == ""){
			echo "invalid or empty name..<br>";
		}else if($pass == ""){
			echo "invalid or empty password..";
		}else{
			
			if($_SESSION['name'] == $name && $_SESSION['pass'] == $pass){

				$_SESSION['name'] = "abc";

				header('location: home.php');
			}else{
				echo "invalid username/password.";
			}
		}

	}else{
		header('location: login.php');
		//echo "Invalid request!";
	}
?>
