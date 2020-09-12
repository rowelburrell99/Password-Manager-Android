<?php
require "conn.php";
$id = $_POST["id"];
$username = $_POST["username"];
$password = $_POST["password"];
$website = $_POST["website"];
$logged_in = $_POST["logged_in"];
$mysql_qry = "UPDATE `".$logged_in."` SET username = '$username', password = '$password', website = '$website' WHERE id = '$id'";

if (strlen($id) > 1 and strlen($username) > 1 and strlen($password) > 1 and strlen($website) > 1) {
	if($conn->query($mysql_qry) === TRUE) {
		echo "Update successful";
	}
}
else {
	//echo "Error: " . $mysql_qry . "<br>" . $conn -> error;
	echo "Ensure all text fields are filled in correctly.";
}

$conn -> close();

?>
