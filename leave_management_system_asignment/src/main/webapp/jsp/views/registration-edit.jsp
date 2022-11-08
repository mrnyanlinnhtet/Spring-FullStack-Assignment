<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Leave Home</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
	
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"
	integrity="sha512-1ycn6IcaQQ40/MKBW2W4Rhis/DbILU74C1vSrLJxCq57o941Ym01SwNsOMqvEBFlcgUa6xLiPY/NS5R+E6ztJQ=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>

  <c:import url="/jsp/include/navbar.jsp">
  <c:param name="view" value="classes"></c:param>
  </c:import>

  <div class="container">
    <h1 class="text-success my-4">${empty param.id?'Add New':'Edit' } Registration</h1>
     
      <div class="row">
      
       <c:url value="/classes/saveRegistration" var="saveReg"></c:url>
       <sf:form modelAttribute="regiForm" method="post" action="${saveReg}" cssClass="col-6">
        <sf:hidden path="studentId"/>
        <sf:hidden path="classId"/>
        
        <div class="form-group mb-4">
        <div class="form-label"><b>Start Date : </b></div>
        <span class="form-control">2022-09-2022</span>
        </div>
        
        <div class="form-group mb-4">
        <div class="form-label"><b>Teacher : </b></div>
        <span class="form-control">Min Lwin</span>
        </div>
        
        <div class="form-group mb-4">
        <label for="name" class="form-label"><b>Student Name : </b></label>
        <sf:input path="studentName" cssClass="form-control" placeholder="Enter Student Name !" id="name"/>
        </div>
        
        <div class="form-group mb-4">
        <label for="email" class="form-label"><b>Email Address : </b></label>
        <sf:input path="email" type="email" cssClass="form-control" placeholder="Enter Email Address !" id="email"/>
        </div>
        
        <div class="form-group mb-4">
        <label for="phone" class="form-label"><b>Phone Number : </b></label>
        <sf:input path="phone" type="tel" cssClass="form-control" placeholder="Enter Phone Number !" id="phone"/>
        </div>
        
        <div class="form-group mb-4">
        <label for="edu" class="form-label"><b>Last Education : </b></label>
        <sf:input path="education" cssClass="form-control" placeholder="Enter Last Education !" id="edu"/>
        </div>
        
        <div>
         <button type="submit" class="btn btn-outline-success"><i class="fas fa-save"></i> Save</button>
        </div>
       
       </sf:form>
      
      </div>
    
  </div>
</body>
</html>