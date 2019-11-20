<%--
  Created by IntelliJ IDEA.
  User: Tomorrow
  Date: 10/21/2019
  Time: 11:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Save Date SanWich</title>
</head>
<body>
<h1>Save Data: </h1>
<form action="display" method="post">
    <c:forEach var="condiment" items="${condimentChoose}">
        <c:out value="${condiment}"/>
    </c:forEach>
</form>
</body>
</html>