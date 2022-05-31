<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/31/2022
  Time: 8:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List</title>
</head>
<body>
<h1>Danh sách sản phẩm</h1>
<h3>Search</h3>
<form method="post"  >
    <input type="text" name="search">
    <input type="submit" value="press me">
</form>
<a href="/products?action=create">create new product</a>
<table border="1">
    <tr>
        <th>Tên</th>
        <th>Giá</th>
        <th>Hãng</th>
    </tr>
    <c:forEach var="item" items='${requestScope["products"]}'>
        <tr>
            <td>${item.getName()}</td>
            <td>${item.getPrice()}</td>
            <td>${item.getBrand()}</td>
            <td><a href="/products?action=update&id=${item.getId()}">update</a></td>
            <td><a href="/products?action=delete&id=${item.getId()}">delete</a></td>
            <td><a href="/products?action=detail&id=${item.getId()}">detail</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
