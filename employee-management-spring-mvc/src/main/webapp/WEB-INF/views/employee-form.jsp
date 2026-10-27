<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html><head><title>Register Employee</title><link rel="stylesheet" href="${pageContext.request.contextPath}/assets/style.css"></head>
<body><main class="container">
<h1>Employee Registration</h1>
<p><a href="${pageContext.request.contextPath}/employees">View employee list</a></p>
<div class="error">${serviceError}</div>
<form:form method="post" action="${pageContext.request.contextPath}/employees" modelAttribute="employee">
  <label>Name</label><form:input path="name" maxlength="80"/><form:errors path="name" cssClass="error"/>
  <label>Email</label><form:input path="email" type="email"/><form:errors path="email" cssClass="error"/>
  <label>Department</label><form:input path="department" maxlength="60"/><form:errors path="department" cssClass="error"/>
  <label>Salary</label><form:input path="salary" type="number" step="0.01" min="0.01"/><form:errors path="salary" cssClass="error"/>
  <button type="submit">Register Employee</button>
</form:form>
</main></body></html>
