<?php
$username = $_POST["username"];
$pin = $_POST["pin"];
$con=mysqli_connect("localhost:8889","root","root","MLoginDB");
// Check connection
if (mysqli_connect_errno())
{
echo "Failed to connect to MySQL: " . mysqli_connect_error();
}

$result = mysqli_query($con,"SELECT hint FROM mlogin_table WHERE pin = '$pin' and username = '$username'");

if($row = mysqli_fetch_array($result))
{
echo "Hint: " . $row['hint'];

}
else {
	echo "Fill in the text fields to retrieve hint.";
}

mysqli_close($con);
?>