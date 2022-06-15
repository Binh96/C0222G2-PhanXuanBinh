<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/15/2022
  Time: 2:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dictionary</title>
</head>
<body>
<form action="/translate">
    <label for="">Nhập: </label>
    <input type="text" name="vietNam" value="${vietNam}">
    <label for="">Từ dịch: </label>
    <input type="text" name="english" value="${english}" disabled>
    <button>Dịch</button>
</form>
<h1 style="color: red">${result}</h1>
</body>
</html>
