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
   <th>Edit</th>
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
      <a href="${regEdit}" class="btn btn-outline-warning">Edit <i class="fas fa-pen"></i></a>
     </td>
   </tr>
  </tbody>
</table>