<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html><head><title>Employee List</title><link rel="stylesheet" href="${pageContext.request.contextPath}/assets/style.css"></head>
<body><main class="container">
<h1>Employees</h1>
<c:if test="${not empty successMessage}"><p class="success"><c:out value="${successMessage}"/></p></c:if>
<p><a class="button" href="${pageContext.request.contextPath}/employees/new">Register employee</a></p>
<c:choose><c:when test="${empty employees}"><p>No employees registered yet.</p></c:when><c:otherwise>
<table><thead><tr><th>ID</th><th>Name</th><th>Email</th><th>Department</th><th>Salary</th></tr></thead><tbody>
<c:forEach items="${employees}" var="employee"><tr>
<td><c:out value="${employee.id}"/></td><td><c:out value="${employee.name}"/></td>
<td><c:out value="${employee.email}"/></td><td><c:out value="${employee.department}"/></td>
<td><c:out value="${employee.salary}"/></td></tr></c:forEach>
</tbody></table></c:otherwise></c:choose>
</main></body></html>
