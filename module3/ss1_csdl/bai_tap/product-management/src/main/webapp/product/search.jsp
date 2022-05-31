<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/31/2022
  Time: 3:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search</title>
</head>
<body>
<h1>Search Product</h1>
<form method="post">
    <legend>Product</legend>
    <fieldset>
        <table>
            <tr>
                <td>Id: </td>
                <td>${requestScope["products"].getId()}</td>
            </tr>
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
                <a href="/products">Back to list</a>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
