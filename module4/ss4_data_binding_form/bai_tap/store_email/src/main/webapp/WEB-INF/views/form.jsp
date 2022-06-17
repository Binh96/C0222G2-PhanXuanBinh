<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/16/2022
  Time: 11:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Form Binding</title>
</head>
<body>
<form:form method="POST" action="save" modelAttribute="emails">
    <table>
        <tr>
            <td><form:label path="languages">Languages: </form:label></td>
            <td><form:select path="languages">
                <form:option  value="English">English</form:option>
                <form:option  value="Việt Nam">Việt Nam</form:option>
                <form:option  value="Japanese">Japanese</form:option>
                </form:select>
            </td>
        </tr>
        <tr>
            <td><form:label path="page">Page size: </form:label></td>
            <td><span>show</span>
                <form:select path="page">
                    <form:option value="5">5</form:option>
                    <form:option value="10">10</form:option>
                    <form:option value="15">15</form:option>
                    <form:option value="25">25</form:option>
                    <form:option value="50">50</form:option>
                    <form:option value="100">100</form:option>
                </form:select>
                <span>email persize</span>
            </td>
        </tr>
        <tr>
            <td><form:label path="enableSpam">Spam filter: </form:label></td>
            <td><form:checkbox  path="enableSpam"/>Enable spams filter</td>
        </tr>
        <tr>
            <td><form:label path="signature">Signature: </form:label></td>
            <td><form:textarea cols="30" rows="5" path="signature"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>
