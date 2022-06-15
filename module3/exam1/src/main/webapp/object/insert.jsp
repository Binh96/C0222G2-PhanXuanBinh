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
    <link rel="stylesheet" href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
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
                <form action="" method="post">
                    <label for="">Mã mặt bằng:</label>
                    <input type="text" class="form-control" name="maMatBang" value="${maMatBang}" placeholder="Mã mặt bằng">
                    <p class="text-danger">${error.get('errorCode')}</p>
                    <label for="">Diện tích:</label>
                    <input type="text" class="form-control" name="dienTich" value="${dienTich}" placeholder="Diện tích">
                    <p class="text-danger">${error.get('errorDientich')}</p>
                    <label for="">Trạng thái:</label>
                    <select name="haTang" id="" class="mx-3">
                        <c:forEach items="${trangThais}" var="item">
                            <option value="${item.maTrangThai}">${item.tenTrangThai}</option>
                        </c:forEach>
                    </select>
                    <p class="text-danger">${error.get('errorHaTang')}</p>
                    <label for="">Số tầng:</label>
                    <input type="number" class="form-control" name="soTang" value="${soTang}">
                    <p class="text-danger">${error.get('errorSoTang')}</p>
                    <select name="loaiVanPhong" id="" class="mx-3">
                        <c:forEach items="${matBangs}" var="item">
                            <option value="${item.maLoaiMatBang}">${item.tenLoaiMatBang}</option>
                        </c:forEach>
                    </select>
                    <p class="text-danger">${error.get('errorMatBang')}</p>
                    <label for="">Mô tả:</label>
                    <input type="text" class="form-control" name="desc" value="${desc}" placeholder="Mô tả">
                    <p class="text-danger">${error.get('errorDesc')}</p>
                    <label for="">Giá cho thuê:</label>
                    <input type="text" class="form-control" name="gia" value="${gia}" placeholder="Giá cho thuê">
                    <p class="text-danger">${error.get('errorGia')}</p>
                    <label for="">Ngày bắt đầu:</label>
                    <input type="date" class="form-control" name="ngayBatDau" value="${ngayBatDau}">
                    <p class="text-danger">${error.get('errorNgayBatDau')}</p>
                    <label for="">Ngày kết thúc:</label>
                    <input type="date" class="form-control" name="ngayKetThuc" value="${ngayKetThuc}">
                    <p class="text-danger">${error.get('errorNgayKetThuc')}</p>
                    <div class="d-flex justify-content-between align-items-center">
                        <button class="btn-light btn border-secondary" type="submit">Thêm mới</button>
                        <button class="btn-dark btn border-secondary" type="submit">
                            <a href="/" class="text-white text-decoration-none">Trở về</a>
                        </button>
                    </div>
                </form>
            </article>
        </div>
    </section>
</div>
</body>
</html>


<script>
    $( function() {
        $( "#datepicker" ).datepicker({
            "dateFormat": "dd/mm/yyyy"
        });
    } );
</script>
<script src="../bootstrap-5.1.3-dist/js/bootstrap.bundle.min.js" crossorigin="anonymous">
</script>
