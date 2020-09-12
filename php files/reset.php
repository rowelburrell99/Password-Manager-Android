<?php
require "conn.php";

$username = $_POST["username"];
$password = $_POST["password"];
$pin = $_POST["pin"];
$mysql_qry = "UPDATE mlogin_table SET password='$password' WHERE username = '$username' and pin = '$pin'";

if (strlen($pin) >= 6){
	if($conn->query($mysql_qry) === TRUE) {
		echo "Password reset is successful";
	}
}
else {
	//echo "Error: " . $mysql_qry . "<br>" . $conn -> error;
	echo "Ensure the pin is 6-digits.";
}

$conn -> close();



?>