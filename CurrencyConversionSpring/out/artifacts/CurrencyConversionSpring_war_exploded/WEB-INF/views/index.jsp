<%--
  Created by IntelliJ IDEA.
  User: Tomorrow
  Date: 10/17/2019
  Time: 4:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Chương trình chuyển đổi tiền</h1>
<form method="get" action="convert">
    Nhập vào USD: <input type="text" name="usd" id="usd">
    <button type="submit">Convert</button>
</form>
VND: <span>${vnd}</span>
</body>
</html>