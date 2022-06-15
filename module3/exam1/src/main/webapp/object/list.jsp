<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/10/2022
  Time: 10:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../bootstrap-5.1.3-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="../myCss/style.css">
    <link rel="stylesheet" href="../datatables/css/dataTables.bootstrap4.css">
    <title>Object</title>
</head>
<body>
    <div class="main">
        <header class="bg-black">
            <div class="container header-container text-white d-flex align-items-center justify-content-between">
                <div class="logo">
                    <a href="/" class="d-flex align-items-center text-decoration-none">
                        <img src="../myCss/img/taylor-heery-cFX0WmDJRiw-unsplash.jpg" alt=""
                             width="45px" height="45px" class="img-logo">
                        <p class="text-white mx-2 my-0">Logo</p>
                    </a>
                </div>
                <nav class="navbar navbar-expand-lg bg-black">
                    <div class="container-fluid">
                        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse" id="navbarNavDropdown">
                            <ul class="navbar-nav">
                                <li class="nav-item">
                                    <a class="nav-link active text-white" aria-current="page" href="#">Home</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link text-white" href="#">Features</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link text-white" href="#">Pricing</a>
                                </li>
                                <li class="nav-item dropdown">
                                    <a class="nav-link text-white dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                        Dropdown link
                                    </a>
                                    <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                        <li><a class="dropdown-item " href="#">Action</a></li>
                                        <li><a class="dropdown-item" href="#">Another action</a></li>
                                        <li><a class="dropdown-item" href="#">Something else here</a></li>
                                    </ul>
                                </li>
                            </ul>
                        </div>
                    </div>
                </nav>
                <button type="button" class="btn btn-light" data-bs-toggle="modal" data-bs-target="#exampleModal">
                    Login
                </button>

                <!-- Modal -->
                <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Đăng nhập</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body container">
                                <form action="" method="post">
                                    <label class="text-dark">Tài khoản:</label>
                                    <input class="form-control" type="text" name="account" placeholder="Tài khoản" value="${accountValue}">
                                    <br>
                                    <label class="text-dark">Mật khẩu: </label>
                                    <input class="form-control" type="password" name="password" placeholder="Mật khẩu" value="${passwordValue}">
                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                <button type="button" class="btn btn-primary">Đăng nhập</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </header>
        <section class="content container mt-5">
            <div class="row">
                <article class="col-12">
                    <div class="d-flex justify-content-between align-items-center">
                        <button class="btn btn-primary">
                            <a href="?action=add" class="text-decoration-none text-white">Thêm mới</a>
                        </button>
                        <form class="d-flex" role="search" method="get" action="">
                            <input type="hidden" name="action" value="search">
                            <select name="trangThaiSearch" id="" class="mx-3">
                                <option value="">---Danh muc---</option>
                                <c:forEach items="${trangThais}" var="item">
                                    <option value="${item.maTrangThai}">${item.tenTrangThai}</option>
                                </c:forEach>
                            </select>
                            <select name="matBangSearch" id="" class="mx-3">
                                <option value="">---Danh muc---</option>
                                <c:forEach items="${matBangs}" var="item">
                                    <option value="${item.maLoaiMatBang}">${item.tenLoaiMatBang}</option>
                                </c:forEach>
                            </select>
                            <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="maMatBang">
                            <button class="btn btn-outline-success" type="submit">Search</button>
                        </form>
                    </div>
                    <table class="pt-5 table" id="myTable">
                        <thead>
                        <tr>
                            <th class="text-center">Mã mặt bằng</th>
                            <th class="text-center">Hạ tầng</th>
                            <th class="text-center">Diện tích</th>
                            <th class="text-center">Số tầng</th>
                            <th class="text-center">Loại mặt bằng</th>
                            <th class="text-center">Mô tả</th>
                            <th class="text-center">Giá tiền</th>
                            <th class="text-center">Ngày bắt đầu</th>
                            <th class="text-center">Ngày kết thúc</th>
                            <th class="text-center">Option</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="toaNha" items="${toaNhas}">
                            <tr>
                                <td class="text-center">${toaNha.maToaNha}</td>
                                <td class="text-center">
                                    <c:forEach var="item" items="${trangThais}">
                                        <c:if test="${item.maTrangThai == toaNha.loaiMatBang}">
                                            ${item.tenTrangThai}
                                        </c:if>
                                    </c:forEach>
                                </td>
                                <td class="text-center">${toaNha.dienTich}</td>
                                <td class="text-center">${toaNha.soTang}</td>
                                <td class="text-center">
                                    <c:forEach var="item" items="${matBangs}">
                                        <c:if test="${item.maLoaiMatBang == toaNha.haTang}">
                                            ${item.tenLoaiMatBang}
                                        </c:if>
                                    </c:forEach>
                                </td>
                                <td class="text-center">${toaNha.desc}</td>
                                <td class="text-center">${toaNha.giaTien}</td>
                                <td class="text-center">${toaNha.ngayBatDau}</td>
                                <td class="text-center">${toaNha.ngayKetThuc}</td>
                                <td class="d-flex">
                                    <button class="btn btn-dark mx-1">
                                        <a href="?action=edit&id=${toaNha.maToaNha}" class="text-white text-decoration-none">Edit</a>
                                    </button>
                                    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal${toaNha.maToaNha}">
                                        Delete
                                    </button>

                                    <!-- Modal -->
                                    <div class="modal fade" id="exampleModal${toaNha.maToaNha}" tabindex="-1" aria-labelledby="exampleModalLabel1" aria-hidden="true">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title text-primary" id="exampleModalLabel1">Do you want to do it?</h5>
                                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                </div>
                                                <div class="modal-body">
                                                    <p class="text-primary">Erase product have id ${toaNha.maToaNha}</p>
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                                    <button type="button" class="btn btn-primary">
                                                        <a href="?action=delete&id=${toaNha.maToaNha}" class="text-white">Delete</a>
                                                    </button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </article>
            </div>
        </section>
    </div>
</body>
</html>


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
<script src="../bootstrap-5.1.3-dist/js/bootstrap.bundle.min.js" crossorigin="anonymous">
</script>
