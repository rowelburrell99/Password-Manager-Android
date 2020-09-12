<?php
$website = $_POST["website"];
$logged_in = $_POST["logged_in"];
$con=mysqli_connect("localhost:8889","root","root","MLoginDB");
// Check connection
if (mysqli_connect_errno())
{
echo "Failed to connect to MySQL: " . mysqli_connect_error();
}

$result = mysqli_query($con,"SELECT * FROM`".$logged_in."` WHERE website = '$website'");

if($row = mysqli_fetch_array($result))
{
echo "Username: " . $row['username'];
echo "                          Password: " . $row['password'];
}
else {
	echo "Fill in the website field to find username and password.";
}

mysqli_close($con);
?>