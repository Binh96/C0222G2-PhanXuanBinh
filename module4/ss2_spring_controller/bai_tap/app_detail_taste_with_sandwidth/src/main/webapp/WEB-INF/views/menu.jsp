<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/16/2022
  Time: 8:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sandwich</title>
</head>
<body>
<h1>Sandwich condiments</h1>
<form action="/save" method="post">
    <input type="checkbox" name="condiment" value="lettuce">
    <label for="">lettuce</label>
    <input type="checkbox" name="condiment" value="tomato">
    <label for="">tomato</label>
    <input type="checkbox" name="condiment" value="mustard">
    <label for="">mustard</label>
    <input type="checkbox" name="condiment" value="sprouts">
    <label for="">sprouts</label>
    <br>
    <br>
    <button type="submit">Save</button>
</form>
</body>
</html>
