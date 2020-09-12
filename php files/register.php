<?php
require "conn.php";
$user_name = $_POST["username"];
$password = $_POST["password"];
$pin = $_POST["pin"];
$hint = $_POST["hint"];
$mysql_qry = "INSERT INTO mlogin_table (username, password, pin, hint) VALUES ('$user_name', '$password', '$pin', '$hint')";

$table_qry = "CREATE TABLE `".$user_name."` (
id INT(11) PRIMARY KEY,
username VARCHAR(255),
password VARCHAR(255),
website VARCHAR(255)
)";

if (strlen($user_name) > 1 and strlen($pin) >= 6 and strlen($password) > 1 and strlen($hint) > 1){
	if($conn->query($mysql_qry) === TRUE) {
	$result = mysqli_query($conn, $table_qry) or die("Bad Create: $table_qry");
	echo "Register successful";
	}
}
else {
	//echo "Error: " . $mysql_qry . "<br>" . $conn -> error;
	echo "Ensure all text fields are filled in correctly.";
}

$conn -> close();

?>


