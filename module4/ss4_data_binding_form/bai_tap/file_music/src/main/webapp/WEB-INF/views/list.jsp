<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/19/2022
  Time: 6:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List</title>
</head>
<body>
<table border="1">
    <thead>
        <tr>
            <td>Tên ca sĩ</td>
            <td>Tên bài hát</td>
            <td>Thể loại</td>
            <td>Link</td>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="item" items="${musics}">
            <tr>
                <td>${item.name}</td>
                <td>${item.singer}</td>
                <td>${item.type}</td>
                <td><a href="${item.path}" target="_blank">${item.path}</a></td>
            </tr>
        </c:forEach>
    </tbody>
    <a href="/file/">Trở lại</a>
</table>
</body>
</html>
