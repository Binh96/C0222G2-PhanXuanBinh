<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/31/2022
  Time: 11:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete</title>
</head>
<body>
<h1>Delete Product</h1>
<form method="post">
    <legend>Product</legend>
    <fieldset>
        <table>
            <tr>
                <td>Name: </td>
                <td>${requestScope["products"].getName()}</td>
            </tr>
            <tr>
                <td>Price: </td>
                <td>${requestScope["products"].getPrice()}</td>
            </tr>
            <tr>
                <td>Desc: </td>
                <td>${requestScope["products"].getDesc()}</td>
            </tr>
            <tr>
                <td>Brand: </td>
                <td>${requestScope["products"].getBrand()}</td>
            </tr>
            <tr>
                <td><input type="submit" value="Delete"></td>
                <td><a href="/products">Back product list</a></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
