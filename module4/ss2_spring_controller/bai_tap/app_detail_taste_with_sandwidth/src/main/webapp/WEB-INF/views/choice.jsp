<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/16/2022
  Time: 9:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Sandwich</title>
</head>
<body>
<h3 style="display: inline">Gia vị đi kèm với <h1 style="color: blue; display: inline">Sandwich</h1></h3>
<c:forEach var="item" items="${condiments}">
    <h3>+ ${item}</h3>
</c:forEach>
</body>
</html>
