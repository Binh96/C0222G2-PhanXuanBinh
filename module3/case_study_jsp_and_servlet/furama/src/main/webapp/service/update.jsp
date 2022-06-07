<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/4/2022
  Time: 10:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css">
    <style><%@include file="../style.css"%></style>
    <title>Update Service</title>
</head>
<body>
<div class="main">
    <header class="header">
        <div class="d-lg-flex justify-content-between align-items-lg-center py-lg-2 px-lg-5">
            <a href="/">
                <img class="logo-img" src="https://images.unsplash.com/photo-1653874525275-3dee940b034c?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHwxNXx8fGVufDB8fHx8&auto=format&fit=crop&w=500&q=60" alt="" width="60px" height="60px">
            </a>
            <h2 class="text-white">Furama</h2>
        </div>
    </header>
    <nav class="navbar navbar-expand-lg bg-light">
        <div class="container">
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon text-black"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item px-lg-3">
                        <a class="nav-link active" aria-current="page" href="/">Home</a>
                    </li>
                    <li class="nav-item px-lg-3 ">
                        <a class="nav-link" href="/employee">Employee</a>
                    </li>
                    <li class="nav-item px-lg-3">
                        <a class="nav-link" href="/customer">Customer</a>
                    </li>
                    <li class="nav-item px-lg-3">
                        <a class="nav-link" href="/service">Service</a>
                    </li>
                    <li class="nav-item px-lg-3">
                        <a class="nav-link" href="#">Contract</a>
                    </li>
                </ul>
                <form class="d-flex" role="search" method="post" action="?action=search">
                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success" type="submit">Search</button>
                </form>
            </div>
        </div>
    </nav>
    <section class="content container">
        <div class="row mt-5">
            <div class="bg-right col-lg-12">
                <c:if test="${service != null}">
                    <table class="table">
                        <thead>
                            <tr>
                                <th>STT</th>
                                <th>Tên dịch vụ</th>
                                <th>Diện tích</th>
                                <th>Chi phí thuê</th>
                                <th>Số người tối đa</th>
                                <th>Tiêu chuẩn phòng</th>
                                <th>Mô tả tiện nghi khác</th>
                                <th>Diện tích hồ bơi</th>
                                <th>Số tầng</th>
                                <th>Kiểu thuê</th>
                                <th>Loại dịch vụ</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>${service.id}</td>
                                <td>${service.name}</td>
                                <td>${service.area}</td>
                                <td>${service.cost}</td>
                                <td>${service.maxPeople}</td>
                                <td>${service.standardRoom}</td>
                                <td>${service.desc}</td>
                                <td>${service.poolArea}</td>
                                <td>${service.numberFloor}</td>
                                <td>
                                    <c:forEach var="item" items="${typeOfRents}">
                                        <c:if test="${item.code == service.typeRent}">
                                            ${item.name}
                                        </c:if>
                                    </c:forEach>
                                </td>
                                <td>
                                    <c:forEach var="item" items="${typeOfServices}">
                                        <c:if test="${item.code == service.serviceType}">
                                            ${item.name}
                                        </c:if>
                                    </c:forEach>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </c:if>


                <div id="formEdit">
                    <form method="post">
                        <label for="">Tên dịch vụ:</label>
                        <input type="text" name="name" placeholder="Tên dịch vu" class="form-control">
                        <label for="">Diện tích:</label>
                        <input type="text" name="area" class="form-control" placeholder="Diện tích">
                        <label for="">Chi phí thuê:</label>
                        <input type="text" name="cost" class="form-control" placeholder="Chi phí thuê">
                        <label for="">Số người tối đa:</label>
                        <input type="text" name="maxPerson" class="form-control" placeholder="Số người tối đa">
                        <label for="">Tiêu chuẩn phòng:</label>
                        <input type="text" name="standard" class="form-control" placeholder="Tiêu chuẩn phòng">
                        <label for="">Mô tả tiện nghi khác:</label>
                        <input type="text" name="anotherDesc" class="form-control" placeholder="Mô tả tiện nghi khác">
                        <label for="">Diện tích hồ bơi:</label>
                        <input type="text" name="areaPool" class="form-control" placeholder="Diện tích hồ bơi">
                        <label for="">Số tầng:</label>
                        <input type="text" name="numFloor" class="form-control" placeholder="Số tầng">
                        <label for="">Mã kiểu thuê</label>
                        <select name="typeOfRents">
                            <c:forEach var="typeOfRentItem" items="${typeOfRents}">
                                <option value="${typeOfRentItem.code}">${typeOfRentItem.name}</option>
                            </c:forEach>
                        </select>
                        <br>
                        <label for="">Loại dịch vụ </label>
                        <select name="codeTypeServices">
                            <c:forEach var="codeTypeService" items="${typeOfServices}">
                                <option value="${codeTypeService.code}">${codeTypeService.name}</option>
                            </c:forEach>
                        </select>
                        <br>
                        <br>
                        <input type="submit" value="Thay đổi">
                    </form>
                </div>
            </div>
        </div>
    </section>
    <footer>
        <h5>Welcome to Furama</h5>
    </footer>
</div>




<script src="https://code.jquery.com/jquery-2.2.4.min.js" integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js" integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.min.js" integrity="sha384-kjU+l4N0Yf4ZOJErLsIcvOU2qSb74wXpOhqTvwVx3OElZRweTnQ6d31fXEoRD1Jy" crossorigin="anonymous"></script>
</body>
</html>

