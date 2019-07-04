<!DOCTYPE html>
<html>
<head>
	<title>Login </title>
</head>
<body>
	<h1>Login Page</h1>

	<form method="post" action="logcheck.php">
		<fieldset>
			<legend>Login</legend>
			<table>
				<tr>
					<td>Username </td>
					<td>:</td>
					<td><input type="text" name="uname"></td>
				</tr>
				<tr>
					<td>Password </td>
					<td>:</td>
					<td><input type="password" name="pass"></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td><input type="submit" name="submit" value="Submit"></td>
				</tr>
			</table>
		</fieldset>
	</form>
</body>
</html>