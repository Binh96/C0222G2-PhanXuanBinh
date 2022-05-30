<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/30/2022
  Time: 1:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customer</title>
</head>
<body>
<table border="1">
    <thead>Danh Sach Khach Hang</thead>
    <tr>
        <th>Ten</th>
        <th>Ngay Sinh</th>
        <th>Dia chi</th>
        <th>Anh</th>
    </tr>
    <c:forEach var="temp" items="${listcustomer}">
        <tr>
            <td>${temp.name}</td>
            <td>${temp.dob}</td>
            <td>${temp.address}</td>
            <td>
                <img src="${temp.image}" alt="" width="80px" height="80px">
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
