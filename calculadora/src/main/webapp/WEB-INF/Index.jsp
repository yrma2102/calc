<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/bootstrap/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.0.min.js"></script>

<script>
$(document).ready(function(){
	 $('button.btn').click(function(){
		 var fired_button = $(this).val();
		 var text = document.getElementById("pressed").value
		 document.getElementById("pressed").value = text + fired_button;
     });
	});
</script>
</head>
<body>
<div class="container">
	<div class="row">
		<div class="col-6">
			<form action="Home" method="post">
				<div class="row">
					<input type="text" class="btn-light col-12 mb-3" id="pressed" name="pressed" value=""></input>
				</div>
				<div class="row">
					<button type="button" name="character" class="btn btn-secondary btn-outline-dark col-3" waves-effect value="1">1</button>
		            <button type="button" name="character" class="btn btn-secondary btn-outline-dark col-3" waves-effect value="2">2</button>
		            <button type="button" name="character" class="btn btn-secondary btn-outline-dark col-3" waves-effect value="3">3</button>
		            <button type="button" name="character" class="btn btn-secondary btn-outline-dark col-3" waves-effect value="/">/</button>
				</div>
				<div class="row">
		            <button type="button" name="character" class="btn btn-secondary btn-outline-dark col-3" waves-effect value="4">4</button>
		            <button type="button" name="character" class="btn btn-secondary btn-outline-dark col-3" waves-effect value="5">5</button>
		            <button type="button" name="character" class="btn btn-secondary btn-outline-dark col-3" waves-effect value="6">6</button>
		            <button type="button" name="character" class="btn btn-secondary btn-outline-dark col-3" waves-effect value="*">*</button>
				</div>
				<div class="row">
		            <button type="button" name="character" class="btn btn-secondary btn-outline-dark col-3" waves-effect value="7">7</button>
		            <button type="button" name="character" class="btn btn-secondary btn-outline-dark col-3" waves-effect value="8">8</button>
		            <button type="button" name="character" class="btn btn-secondary btn-outline-dark col-3" waves-effect value="9">9</button>
		            <button type="button" name="character" class="btn btn-secondary btn-outline-dark col-3" waves-effect value="-">-</button>
				</div>
	            <div class="row">
		            <button type="button" name="character" class="btn btn-secondary btn-outline-dark col-3" waves-effect value="0">0</button>
		            <input  type="submit" class="btn btn-secondary col-6"" waves-effect value="="></input>
		            <button type="button" name="character" class="btn btn-secondary btn-outline-dark col-3" waves-effect value="+">+</button>
				</div>
			</form>
	
		</div> 
		<div class="col-4 ml-3">
			<table class="table">
			<thead>
			    <tr>
			      <th scope="col">#</th>
			       <th scope="col">Results</th>
			    </tr>
			  </thead>
			<c:forEach items="${lista}" var="current">
				  <tr>
				    <th scope="row">${current.getId()}</th>
				    <td>${current.getResult()}</td>
				  </tr>
  			</c:forEach>  
			    
			    
			</table>
		</div>     	
	</div>
</div>

</body>
</html>