<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/17/2022
  Time: 3:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Medic List</title>
</head>
<body>
<table border="1">
    <thead>
        <tr>
            <th>Họ tên</th>
            <th>Giới tính</th>
            <th>Năm sinh</th>
            <th>Quốc gia</th>
            <th>Số chứng mình nân dân</th>
            <th>Thông tin đi lại</th>
            <th>Số hiệu phương tiện</th>
            <th>Ngày bắt đầu</th>
            <th>Ngày kết thúc</th>
            <th>Số ghế</th>
            <th>Mô tả</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="item" items="${medicList}">
            <tr>
                <td>${item.name}</td>
                <td>${item.gender}</td>
                <td>${item.yearOfBirth}</td>
                <td>${item.nation}</td>
                <td>${item.id}</td>
                <td>${item.vehicle}</td>
                <td>${item.numberVehicle}</td>
                <td>${item.getDayYearMonthStart()}</td>
                <td>${item.getDayYearMonthEnd()}</td>
                <td>${item.numberSeat}</td>
                <td>${item.desc}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>
