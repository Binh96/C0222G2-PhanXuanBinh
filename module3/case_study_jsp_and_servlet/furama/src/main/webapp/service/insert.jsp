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
    <title>Insert Service</title>
    <style><%@include file="../style.css"%></style>
</head>
<body>
<div class="main">
    <header class="header">
        <div class="d-lg-flex justify-content-between align-items-lg-center py-lg-4 px-lg-5">
            <a href="/">
                <img class="log-img" src="https://images.unsplash.com/photo-1653874525275-3dee940b034c?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHwxNXx8fGVufDB8fHx8&auto=format&fit=crop&w=500&q=60" alt="" width="80px" height="80px">
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
                        <a class="nav-link" href="">Contract</a>
                    </li>
                </ul>
                <form class="d-flex" role="search" method="post" action="?action=search">
                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="search">
                    <button class="btn btn-outline-success" type="submit">Search</button>
                </form>
            </div>
        </div>
    </nav>
    <section class="content">
        <div class="container">
            <div class="row mt-5">
                <div class="col-lg-3">
                    <ul class="sidebar-list list-group">
                        <li class="sidebar-item list-group-item"><a href="/service?action=add">New service</a></li>
                        <li class="sidebar-item list-group-item"><a href="/service?action=list">List service</a></li>
                    </ul>
                </div>
                <div class="bg-right col-lg-9">
                    <h1 class="">Service</h1>
                    <div class="text mt-4">
                        <form method="post">
                            <label for="">T??n d???ch v???:</label>
                            <input type="text" name="name" placeholder="T??n d???ch vu" class="form-control">
                            <label for="">Di???n t??ch:</label>
                            <input type="text" name="area" class="form-control" placeholder="Di???n t??ch">
                            <label for="">Chi ph?? thu??:</label>
                            <input type="text" name="feeRent" class="form-control" placeholder="Chi ph?? thu??">
                            <label for="">S??? ng?????i t???i ??a:</label>
                            <input type="text" name="maxPerson" class="form-control" placeholder="S??? ng?????i t???i ??a">
                            <label for="">Ti??u chu???n ph??ng:</label>
                            <input type="text" name="standard" class="form-control" placeholder="Ti??u chu???n ph??ng">
                            <label for="">M?? t??? ti???n nghi kh??c:</label>
                            <input type="text" name="anotherDesc" class="form-control" placeholder="M?? t??? ti???n nghi kh??c">
                            <label for="">Di???n t??ch h??? b??i:</label>
                            <input type="text" name="areaPool" class="form-control" placeholder="Di???n t??ch h??? b??i">
                            <label for="">S??? t???ng:</label>
                            <input type="text" name="numFloor" class="form-control" placeholder="S??? t???ng">
                            <label for="">M?? ki???u thu??</label>
                            <select name="typeOfRents">
                                <c:forEach var="typeOfRentItem" items="${typeOfRent}">
                                    <option value="${typeOfRentItem.code}">${typeOfRentItem.name}</option>
                                </c:forEach>
                            </select>
                            <br>
                            <label for="">Lo???i d???ch v??? </label>
                            <select name="codeTypeServices">
                                <c:forEach var="codeTypeService" items="${typeServices}">
                                    <option value="${codeTypeService.code}">${codeTypeService.name}</option>
                                </c:forEach>
                            </select>
                            <br>
                            <br>
                            <input type="submit" value="Th??m m???i">
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <footer class="m-0">
        <h5>Welcome to Furama</h5>
    </footer>
</div>


<script src="https://code.jquery.com/jquery-2.2.4.min.js" integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js" integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.min.js" integrity="sha384-kjU+l4N0Yf4ZOJErLsIcvOU2qSb74wXpOhqTvwVx3OElZRweTnQ6d31fXEoRD1Jy" crossorigin="anonymous"></script>
</body>
</html>

