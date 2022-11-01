<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
   <h1 class="my-4 text-success"><b><i class="fas fa-info-circle"></i> Class Details</b></h1>
    <div class="card my-4">
    <div class="card-header text-success"><b><i class="fas fa-info"></i> Class Information</b></div>
    <div class="card-body">
    
    </div>
    </div>
    <!-- End of Card -->
    
    <div class="d-flex justify-content-between my-5">
    
     <ul class="nav nav-pills">
     <li class="nav-item">
      <button class="nav-link active" data-bs-toggle="pill" data-bs-target="#registration">Registrations  <i class="fas fa-address-book"></i></button>
     </li>
     
     <li class="nav-item">
      <button class="nav-link" data-bs-toggle="pill" data-bs-target="#leaves">Leaves Application <i class="fas fa-users"></i></button>
     </li>
     
     </ul>
     
     <a href="#" class="btn btn-outline-danger">Add New Registration <i class="fas fa-user-plus"></i></a>
     
    </div>
    
     <!-- End of justify -->
     <div class="tab-content" id="content">
     <div class="tab-pane fade show active" id="registration">
     <!-- Registration Form -->
     <c:url value="/jsp/include/class-registration.jsp" var="reg"></c:url>
      <c:import url="${reg}"></c:import>
     </div>
      <div class="tab-pane fade" id="leaves">
      <!-- Leaves -->
      </div>
     </div>
    
  </div>

</body>
</html>