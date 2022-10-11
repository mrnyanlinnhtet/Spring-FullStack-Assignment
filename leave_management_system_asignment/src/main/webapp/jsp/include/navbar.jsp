<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url value="/home" var="home"/>
<c:url value="/teachers" var="teachers"/>
<c:url value="/classes" var="classes"/>
<c:url value="/students" var="students"/>
<c:url value="/leaves" var="leaves"/>
<c:url value="/signout" var="signout"/>

    <nav class="navbar navbar-expand-lg navbar-dark bg-success">
 
 <div class="container my-2">
   
   <a href="${home}" class="navbar-brand"><b>Leave Registration System</b></a>
   
    <ul class="navbar-nav">
    
      <li class="nav-item">
      <a href="${teachers}" class="nav-link ${param.view eq 'teachers' ? 'active':'' }">Teachers</a>
      </li>
      
      <li class="nav-item">
      <a href="${classes}" class="nav-link ${param.view eq 'classes' ? 'active':'' }">Classes</a>
      </li>
      
      <li class="nav-item">
      <a href="${students}" class="nav-link ${param.view eq 'students' ? 'active':'' }">Students</a>
      </li>
      
      <li class="nav-item">
      <a href="${leaves}" class="nav-link ${param.view eq 'leaves' ? 'active':'' }">Leaves</a>
      </li>
      
      <li class="nav-item">
      <a href="${signout}" class="nav-link">Sign Out</a>
      </li>
    
    </ul>
 </div>
 
 </nav>