<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/15/2022
  Time: 1:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Exchange</title>
</head>
<body>
    <h1>Exchange</h1>
    <form action="/exchangeMoney">
        <label>VND</label>
        <input type="text" name="vnd" value="${vnd}">
        <label>USD</label>
        <input type="text" name="usd" value="${usd}" disabled>
        <button>Exchange</button>
    </form>
</body>
</html>
