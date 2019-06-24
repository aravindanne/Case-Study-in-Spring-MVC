<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Case Study</title>

<link rel="stylesheet"
	href="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">
<script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<script
	src="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<style>
html, #page {
	padding: 0;
	margin: 0;
}

body {
	margin: 0;
	padding: 0;
	width: 100%;
	color: #959595;
	font: normal 12px/2.0em Sans-Serif;
}

h1, h2, h3, h4, h5, h6 {
	color: darkgreen;
}

#page {
	background: #fff;
}

#header, #footer, #top-nav, #content, #content #contentbar, #content #sidebar
	{
	margin: 0;
	padding: 0;
}

/* Logo */
#logo {
	padding: 0;
	width: auto;
	float: left;
}

#logo h1 a, h1 a:hover {
	color: darkgreen;
	text-decoration: none;
}

#logo h1 span {
	color: #BCCE98;
}

/* Header */
#header {
	background: #fff;
}

#header-inner {
	margin: 0 auto;
	padding: 0;
	width: 970px;
}

/* Feature search */
.feature {
	background: green;
	padding: 18px;
}

.feature input[type=text] {
	width: 10%;
	padding: 5px;
	height: 5px;
}

/* Menu */
#top-nav {
	margin: 0 auto;
	padding: 0px 0 0;
	height: 37px;
	float: right;
}

/* Clear both sides to assist with div alignment  */
.clr {
	clear: both;
	padding: 0;
	margin: 0;
	width: 100%;
	font-size: 0px;
	line-height: 0px;
}

/* The popup form - hidden by default */
.addpatient-form {
	display: none;
	border: 6px solid salmon;
	padding: 2em;
	width: 400px;
	text-align: center;
	background: #fff;
	position: fixed;
	top: 55%;
	left: 50%;
	transform: translate(-50%, -50%);
	-webkit-transform: translate(-50%, -50%)
}

/* Add styles to the form container of add patient */
.form-container {
	max-width: 300px;
	padding: 10px;
	background-color: white;
	text-align: left;
}

/* Full-width input fields */
.form-container input[type=text], .form-container input[type=number] {
	width: 100%;
	padding: 15px;
	border: none;
	background: #f1f1f1;
	color: black;
	font-weight: bold;
	font: bold;
}

/* Set a style for the submit/login button */
.form-container .btn {
	background-color: #4CAF50;
	color: white;
	padding: 16px 20px;
	border: none;
	cursor: pointer;
	width: 100%;
	margin-bottom: 10px;
	opacity: 0.8;
}

/* Add a red background color to the cancel button */
.form-container .cancel {
	background-color: red;
}

/*Buttons design for add and study*/
#outer {
	width: 100%;
	text-align: right;
}

.inner {
	display: inline-block;
}

/*Table design*/
th {
	border-bottom: 1px solid #d6d6d6;
}

tr:nth-child(even) {
	padding-top: 15px;
	padding-bottom: 10px;
	background: #e9e9e9;
}
</style>

<script>
	/*Disable Study button until radio check */
	function loopForm(form) {
		for (var i = 0; i < form.elements.length; i++) {
			if (form.elements[i].type == 'radio') {
				if (form.elements[i].checked == true) {
					document.getElementById("myStudy").disabled = false;
				}
			}
		}
	}

	/* Date of birth date picking calendar */
	$(function() {
		$("#dob").datepicker();
	});

	/* Add Patient and close form */
	function addPatient() {
		document.getElementById("addPatient").style.display = "block";
	}

	function closeForm() {
		document.getElementById("addPatient").style.display = "none";
	}

	/* Auto fill Patient Id on Add patient */
	window.onload = function() {
		document.getElementById('idGen').value = Math
				.floor(Math.random() * 100000);
	}
	
	function readRadioValue(){
		//var selected_id;
		    $(document).ready(function(){
		        	var radioValue = $("input[name='cb']:checked").val();
		            if(radioValue){
		               // alert("Your are a - " + radioValue);
		               
		            	 $.ajax({
		      		       type:'GET',
		      		       url:"/myproject1/patients/"+radioValue,
		      		       data:radioValue,
		      			   contentType : 'application/json',
		      			     dataType : 'json',
		      		       success: function(i){
		      		           console.log(i);  
		      		       }
		      		   });
		               
		            }        
		    });
		        
		    
		
	}
	
	
</script>

</head>

<body>
	<div id="page">
		<header id="header">
			<div id="header-inner">
				<div id="logo">
					<h1>
						<a href="#">{caresyntax - Case Study<span></span></a>
					</h1>
				</div>
				<div id="top-nav"></div>
				<div class="clr"></div>
			</div>
		</header>
		<!-- 			  Search field -->
		New patient id: ${patient_id }
		<div class="feature">
			<input type="text" id="filterTable-input"
				placeholder="Search for patient...." title="Type in a name">
		</div>
		<!-- 			Add Patient and Study -->
		<div id="outer">
			<div class="inner">
				<button class="" onclick="addPatient()">Add Patient</button>
			</div>
			<div class="inner">
			<form action="/patients/1">
				<button type="" class="" id="myStudy" onClick="readRadioValue()" disabled>Study</button>
				</form>
			</div>
			<div class="inner">
			<form action = "/patients" method="get">
 				<button onClick="window.location.reload();"  class="" id="refresh" >Refresh Data</button>
				</form>
			</div>
			
		</div>
		<!-- Add Patient Pop up			 -->
		<div class="addpatient-form" id="addPatient">
			<form action="patients" method="POST" class="form-container"
				target="_blank">
				<h1>Patient Details</h1>
				<!-- <label for="id"><b>Patient-Id(*)</b></label> <b> <input
					type="number" placeholder="Id" name="Id" id="idGen" disabled></b>
 -->
				<label for="name"><b>Patient-Name</b></label> <input type="text"
					placeholder="Name" id="patientname" name="name" required> <label
					for="gender"><b>GENDER</b></label> <select name="sex" id="gender">
					<option value=""></option>
					<option value="male">Male</option>
					<option value="female">Female</option>
					<option value="other">Other</option>
				</select> <label for="dob"><b>Date-Of-Birth</b></label> <input type="date"
					placeholder="Date-of-Birth" id="Dob" name="dob" required>

				<button type="submit" class="btn">Submit</button>
				<button type="button" class="btn cancel" onclick="closeForm()">Close</button>
			</form>
		</div>
		<br />

		<!-- Table contents -->
		<form name="thisForm">
			<table data-role="table" data-mode="columntoggle"
				class="ui-responsive ui-shadow" id="myTable" data-filter="true"
				data-input="#filterTable-input">
				<thead>
					<tr>
						<th></th>
						<th>Patient-Id(*)</th>
						<th data-priority="1">Patient-Name</th>
						<th data-priority="2">Gender</th>
						<th data-priority="3">Date-Of-Birth</th>
					</tr>
				</thead>

				<tbody>

					<c:forEach items="${list }" var="patients">
						<tr>
							<td><input type="radio" name="cb" value="${patients.id }"
								onclick="loopForm(document.thisForm);"></td>
							<td>${patients.id }</td>
							<td>${patients.name}</td>
							<td>${patients.sex}</td>
							<td>${patients.dateOfBirth}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>


