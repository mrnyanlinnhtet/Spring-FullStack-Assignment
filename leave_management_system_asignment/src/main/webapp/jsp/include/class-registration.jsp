<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table class="table table-hover table-striped">
  <thead>
   <tr>
   <th>Id</th>
   <th>Registration Date</th>
   <th>Student</th>
   <th>Phone</th>
   <th></th>
   </tr>
  </thead>
  <tbody>
   <tr>
     <td>1</td>
     <td>2022-01-12</td>
     <td>Nyan Linn Htet</td>
     <td>09444859894</td>
     <td>
     <c:url value="/classes/registration" var="regEdit">
     <c:param name="id" value="1"></c:param>
     </c:url>
      <a href="${regEdit}" class="mx-3"><i class="fas fa-pencil-alt"></i></a>
      
      
      
      
      <c:url value="/classes/registration/1/1" var="reg_detail">
      </c:url>
      <a href="${reg_detail}"><i class="fas fa-external-link-square-alt"></i></a>
     </td>
   </tr>
  </tbody>
</table>