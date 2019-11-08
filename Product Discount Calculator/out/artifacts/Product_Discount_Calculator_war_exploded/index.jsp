<%--
  Created by IntelliJ IDEA.
  User: Tomorrow
  Date: 10/11/2019
  Time: 4:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Product Discount Calculator</title>
  </head>
  <body>
  <fieldset>
    <legend>
      Product Discount Calculator
    </legend>
  <form action="/discount" method="post">
    <table>
      <tr>
        <td>Product Description</td>
        <td><input type="text" name = "product_description"> </td>
      </tr>
      <tr>
        <td>List Price</td>
        <td><input type="text" name = "list_price"> </td>
      </tr>
      <tr>
        <td>Discount Percent</td>
        <td><input type="text" name = "discount_percent"> </td>
      </tr>
      <tr>
        <td><input type = "submit" id = "submit" value = "Discount"/></td>
      </tr>
    </table>
  </form>
  </fieldset>
  </body>
</html>
