<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="utf-8">
<title>Untitled Document</title>
<style>
div.border {
	border-style: none;
	height: 700px;
	width: 800px;
	padding-right: 20px;
	margin-left: 250px;
	background-color: #DDD;
}
</style>
</head>

<body>
	<div class="border">
		<a href="#" style="float: right;"></a>
		<p id="demo"></p>

	</div>
	<div>
		<input type="text" id="massage"
			style="border-style: none; height: 100px; width: 700px; margin-left: 250px; background-color: #3CF;">

		<button type="button" onclick="myFunction()"
			style="background-color: #009; height: 100px; width: 80px; float: right">Send</button>

	</div>






	<script>
		function myFunction() {
			var x = document.getElementById("massage").value;
			document.getElementById("demo").innerHTML = x;
			document.getElementById("massage").value = "";
		}
	</script>


</body>
</html>