<%--
  Created by IntelliJ IDEA.
  User: Tomorrow
  Date: 10/21/2019
  Time: 11:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sandwich</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form action="save" method="get">

    <tr>
        <td><input type="checkbox" name="condiment" value="Lettuce"><label>Lettuce</label></td>
        <td><input type="checkbox" name="condiment" value="Tomato"><label>Tomato</label></td>
        <td><input type="checkbox" name="condiment" value="Mustard"><label>Mustard</label></td>
        <td><input type="checkbox" name="condiment" value="Sprouts"><label>Sprouts</label></td>
    </tr>
    <hr>
    <tr><input type="submit" value="Save"></tr>

</form>
</body>
</html>
