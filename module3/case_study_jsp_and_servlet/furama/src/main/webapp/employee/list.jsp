<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/1/2022
  Time: 8:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="../datatables/css/dataTables.bootstrap4.css">
<%--    <link rel="stylesheet" href="../style.css" type="text/css">--%>
    <style><%@include file="../style.css"%></style>
    <title>Employee</title>
</head>
<body>
<div class="main">
    <header class="header">
        <div class="d-lg-flex justify-content-between align-items-lg-center py-lg-4 px-lg-5">
            <a href="/">
                <img class="logo-img" src="https://images.unsplash.com/photo-1653874525275-3dee940b034c?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHwxNXx8fGVufDB8fHx8&auto=format&fit=crop&w=500&q=60" alt="" width="80px" height="80px">
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
                        <a class="nav-link" href="#">Service</a>
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
            <div class="col-lg-3">
                <ul class="sidebar-list list-group">
                    <li class="sidebar-item list-group-item"><a href="?action=add">New employee</a></li>
                    <li class="sidebar-item list-group-item"><a href="?action=list">List employee</a></li>
                </ul>
            </div>
            <div class="bg-right col-lg-9">
                <h1 id="title">${title}</h1>
                <div class="display-list">
                    <table class="table" id="myTable">
                        <thead>
                        <tr>
                            <th>STT</th>
                            <th>H??? v?? t??n</th>
                            <th>S??? ??i???n tho???i</th>
                            <th>Email</th>
                            <th>V??? tr??</th>
                            <th>M?? b??? ph???n</th>
                            <th>L???a ch???n</th>
                        </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="employee" items="${employees}">
                                <tr>
                                    <td>${employee.getCurrentCode()}</td>
                                    <td>${employee.getName()}</td>
                                    <td>${employee.getPhoneMobile()}</td>
                                    <td>${employee.getEmail()}</td>
                                    <td>
                                        <c:forEach var="item" items="${positions}">
                                            <c:if test="${item.codePosition == employee.getPosition()}">
                                                ${item.name}
                                            </c:if>
                                        </c:forEach>
                                    </td>
                                    <td>
                                        <c:forEach var="item" items="${division}">
                                            <c:if test="${item.id == employee.getCodeTask()}">
                                                ${item.name}
                                            </c:if>
                                        </c:forEach>
                                    </td>
                                    <td>
                                        <a href="/employee?action=update&id=${employee.getCurrentCode()}">Edit</a>
                                        <a href="/employee?action=delete&id=${employee.getCurrentCode()}">Delete</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </section>
    <footer>
        <h5 class="m-0">Welcome to Furama</h5>
    </footer>
</div>



<script src="../jquery/jquery-3.5.1.min.js"></script>
<script src="../datatables/js/jquery.dataTables.min.js"></script>
<script src="../datatables/js/dataTables.bootstrap4.min.js"></script>

<script>
    $(function(){
        $('#myTable').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        })
    })
</script>

</body>
</html>
