<?php

require "conn.php";

$user_name = $_POST["user_name"];
$user_pass = $_POST["password"];
$user_pin = $_POST["pin"];
$mysql_qry = "select * from mlogin_table where username like '$user_name' and password like '$user_pass' and pin like '$user_pin'";
$result = mysqli_query($conn ,$mysql_qry);
$successmsg = "Login success";
$failedmsg = "Login not successful";
$totalattempts = 3;
$timeout = 5;

if(mysqli_num_rows($result) > 0) {
	print $successmsg;
}
else {
	print $failedmsg;
	$totalattempts--;
	
		
	}

?>


