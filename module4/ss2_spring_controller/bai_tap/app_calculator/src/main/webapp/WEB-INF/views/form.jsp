<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/16/2022
  Time: 10:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h1>Calculator</h1>
<form action="/result" method="post">
    <input type="text" name="num1">
    <input type="text" name="num2">
    <br>
    <button name="operation" value="sub">Subtraction (-)</button>
    <button name="operation" value="add">Addition (+)</button>
    <button name="operation" value="mul">Multiplication (x)</button>
    <button name="operation" value="div">Division (-)</button>
</form>
<h3>Result: ${result}</h3>
</body>
</html>
