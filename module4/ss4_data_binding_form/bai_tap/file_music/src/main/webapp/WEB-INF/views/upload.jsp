<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/19/2022
  Time: 6:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Upload file</title>
</head>
<body>
    <form:form action="/file/upload" method="post" modelAttribute="filePath">
        <form:label path="name">Tên bài hát</form:label>
        <form:input path="name"/>
        <br>
        <form:label path="singer">Tên ca sĩ</form:label>
        <form:input path="singer"/>
        <br>
        <form:label path="type">Thể loại</form:label>
        <form:input path="type"/>
        <br>
        <form:label path="path">Link</form:label>
        <form:input path="path"/>
        <br>
        <button type="submit">Upload</button>
    </form:form>
    <a href="/file/list">Danh sách</a>
</body>
</html>
