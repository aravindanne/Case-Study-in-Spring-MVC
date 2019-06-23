<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
	function addStudyList() {

		console.log("hello world");
		var study = {
			"id" : "1",
			"patient_id" : "prasad",
			"description" : "testing",
			"study_status" : "3",
			"planned_start_time" : "123",
			"planned_end_time" : "23",
			"room_id" : "ROOM3",
			"doctor_id" : "doc_id"
		};
		console.log(study);

		var log = $.ajax({
			type : 'POST',
			contentType : 'application/json',
			dataType : 'json',
			url : '/myproject1/study',
			data : "hello",//JSON.stringify([study]), 
			success : function(result) {
				alert('I am a successs call...');
			}
		});

		log.error(function() {
			console.log("Something went wrong...");
		});

	}

	function addStudyListtoinput() {
		var study = {
			"id" : "1",
			"patient_id" : "prasad",
			"description" : "testing",
			"study_status" : "3",
			"planned_start_time" : "123",
			"planned_end_time" : "23",
			"room_id" : "ROOM3",
			"doctor_id" : "doc_id"
		};
		document.getElementById('t1').value = study;

	}

	function update() {
		var form = document.getElementById("form1");
		var val = form.elements["test"].value;
		document.getElementById('status').value = val;
	}
</script>
</head>
<body>

	<hr>

	<h5>List of Study</h5>
	<form id="form1" action="updatestatus" method="POST">
		<table width="100%" border="1">
			<tr>
				<td></td>
				<td>Study Id</td>
				<td>Patient Id</td>
				<td>Description</td>
				<td>Status</td>
				<td>Planned Start Time</td>
				<td>Estimated End Time</td>
				<td>Room Name</td>
				<td>Doctor Name</td>
			</tr>
			<c:forEach items="${study_list }" var="study">
				<tr>
					<td><input type="radio" name="test" value="${study.id }">
					</td>
					<td>${study.id }</td>
					<td>${study.patient_id }</td>
					<td>${study.description }</td>
					<td>${study.study_status }</td>
					<td>${study.planned_start_time }</td>
					<td>${study.estimated_end_time }</td>
					<td>${study.room_id }</td>
					<td>${study.doctor_id }</td>
				</tr>
			</c:forEach>
		</table>

		<input type="hidden" name="studyid" id="status"> <input
			type="submit" Value="Update Status" onClick="update()">
	</form>

	<hr>
	<form action="study" method="post">

		<table>
			<tr>
				<td>Patient Id</td>
			<!-- 	<td><input type="text" name="pid" required></td> -->
			
			<td>
			<select name="pid">
			<option></option>
			<c:forEach items="${list }" var="patient">
				<option value="${patient.id }"> ${patient.name } (${patient.id })</option>
			</c:forEach>

  </select>
			
			</td>
			</tr>
			<tr>
				<td>Room Id</td>
				<!-- <td><input type="number"  name="room" min = "1" max = "2" required></td> -->
			<td>
			<select name="room">
			<option></option>
				<option value="1" >ECG (1)</option>
				<option value="2" >CT-SCAN (2)</option>
			</select>
			</td>
			
			</tr>
			<tr>
				<td>Description</td>
				<td><input type="text" name="description"></td>
			</tr>
			<tr>
				<td>Start Time</td>
				<td><input type="number" name="start_time" min="9" max="20" required></td>
			</tr>
			<tr>
				<td>End Time</td>
				<td><input type="number" min="9" max="20" name="end_time"></td>
			</tr>
		</table>
		
		<input type="submit" value="Add Study">


	</form>
	
		Study ID : ${study_id }

</body>
</html>