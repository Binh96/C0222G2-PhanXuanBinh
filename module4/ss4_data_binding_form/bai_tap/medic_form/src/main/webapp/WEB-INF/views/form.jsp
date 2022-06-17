<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/17/2022
  Time: 1:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../bootstrap-5.1.3-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="../myCss/style.css">
    <title>Form Medic</title>
</head>
<body>
    <div class="main">
        <header class="container text-center mb-5">
            <h2 class="text-black">Tờ khai y tế</h2>
            <h5 class="text-black">Đây là tài liệu quan trọng, thông tin của Anh/Chị sẽ giúp cơ quan y tế liên lạc khi cần thiết để phòng
             chống dịch bệnh truyền nhiễm</h5>
            <h5 class="text-danger">Khuyến cáo: Khai báo sai thông tin là vi phạm pháp luật Việt Nam và có thể xử lý hình sự</h5>
        </header>
        <section class="container mt-5">
            <div class="row">
                <form:form action="/medic" method="post" modelAttribute="medic">
                    <div class="row my-2">
                        <div class="col-12">
                            <form:label path="name" class="text-black">Họ tên(ghi chữ IN HOA) <span class="text-danger">(*)</span></form:label>
                            <form:input path="name" class="form-control"/>
                        </div>
                    </div>
                    <div class="row my-2">
                        <div class="col-4">
                            <form:label path="yearOfBirth" class="text-black">Năm sinh <span class="text-danger">(*)</span></form:label>
                            <form:select path="yearOfBirth" class="form-control">
                                <c:forEach var="i" begin="1800" end="2021" step="1">
                                    <form:option value="${i}">${i}</form:option>
                                </c:forEach>
                            </form:select>
                        </div>
                        <div class="col-4">
                            <form:label path="gender" class="text-black">Gender <span class="text-danger">(*)</span></form:label>
                            <form:select path="gender" class="form-control">
                                <form:option value="Nam">Nam</form:option>
                                <form:option value="Nữ">Nữ</form:option>
                            </form:select>
                        </div>
                        <div class="col-4">
                            <form:label path="nation" class="text-black">Quốc tịch <span class="text-danger">(*)</span></form:label>
                            <form:select path="nation" class="form-control">
                                <form:option value="Việt Nam">Việt Nam</form:option>
                                <form:option value="Mỹ">Mỹ</form:option>
                                <form:option value="Nga">Nga</form:option>
                                <form:option value="Trung Quốc">Trung Quốc</form:option>
                                <form:option value="Nhật Bản">Nhật Bản</form:option>
                                <form:option value="Canada">Canada</form:option>
                            </form:select>
                        </div>
                    </div>
                    <div class="row my-2">
                        <div class="col-12">
                            <form:label path="id" class="text-black">Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác <span class="text-danger">(*)</span></form:label>
                            <form:input path="id" class="form-control"/>
                        </div>
                    </div>
                    <div class="row my-2">
                        <div class="col-12">
                            <form:label path="vehicle" class="text-black">Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác <span class="text-danger">(*)</span></form:label>
                            <br>
                            <form:radiobutton path="vehicle" value="Tàu bay"/>Tàu bay
                            <form:radiobutton path="vehicle" value="Tàu thuyền"/>Tàu thuyền
                            <form:radiobutton path="vehicle" value="Oto"/>Oto
                            <form:radiobutton path="vehicle" value="Khác(ghi rõ)"/>Khác(ghi rõ)
                        </div>
                    </div>
                    <div class="row my-2">
                        <div class="col-6">
                            <label class="text-black">Ngày khởi hành <span class="text-danger">(*)</span></label>
                            <div class="row">
                                <div class="col-4">
                                    <form:select path="dayStart" class="form-control">
                                        <c:forEach var="h" begin="1" end="31" step="1">
                                            <form:option value="${h}">${h}</form:option>
                                        </c:forEach>
                                    </form:select>
                                </div>
                                <div class="col-4">
                                    <form:select path="monthStart" class="form-control">
                                        <c:forEach var="i" begin="1" end="12" step="1">
                                            <form:option value="${i}">${i}</form:option>
                                        </c:forEach>
                                    </form:select>
                                </div>
                                <div class="col-4">
                                    <form:select path="yearStart" class="form-control">
                                        <c:forEach var="i" begin="2018" end="2022" step="1">
                                            <form:option value="${i}">${i}</form:option>
                                        </c:forEach>
                                    </form:select>
                                </div>
                            </div>
                        </div>
                        <div class="col-6">
                            <label class="text-black">Ngày kết thúc <span class="text-danger">(*)</span></label>
                            <div class="row">
                                <div class="col-4">
                                    <form:select path="dayEnd" class="form-control">
                                        <c:forEach var="i" begin="1" end="31" step="1">
                                            <form:option value="${i}">${i}</form:option>
                                        </c:forEach>
                                    </form:select>
                                </div>
                                <div class="col-4">
                                    <form:select path="monthEnd" class="form-control">
                                        <c:forEach var="i" begin="1" end="12" step="1">
                                            <form:option value="${i}">${i}</form:option>
                                        </c:forEach>
                                    </form:select>
                                </div>
                                <div class="col-4">
                                    <form:select path="yearEnd" class="form-control">
                                        <c:forEach var="i" begin="2018" end="2022" step="1">
                                            <form:option value="${i}">${i}</form:option>
                                        </c:forEach>
                                    </form:select>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row my-2">
                        <div class="col-6">
                            <form:label path="numberVehicle" class="text-black">Số hiệu phương tiện</form:label>
                            <form:input path="numberVehicle" placeholder="vd: 1234" class="form-control"/>
                        </div>
                        <div class="col-6">
                            <form:label path="numberSeat" class="text-black">Số ghế</form:label>
                            <form:input path="numberSeat" class="form-control"/>
                        </div>
                    </div>
                    <div class="row my-2">
                        <div class="col-12">
                            <form:label path="desc" class="text-black">Trong vòng 14 ngày qua, Anh/Chị có đến tỉnh/thành phố nào không <span class="text-danger">(*)</span></form:label>
                            <form:textarea path="desc" cols="" rows="2" class="form-control"/>
                        </div>
                    </div>
                    <button class="btn btn-primary">Xác nhận</button>
                    <button class="btn btn-dark"><a href="/showMedic" class="text-decoration-none text-white">Danh sách</a></button>
                </form:form>
            </div>
        </section>
    </div>
</body>
</html>
