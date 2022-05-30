<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/30/2022
  Time: 2:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Form Caluclate</title>
  </head>
  <body>
  <form action="/calculate" method="get">
    <label for="">First Operand</label>
    <input type="text" name="firstOperand">
    <label for="">Operator</label>
    <input type="text" name="Operator">
    <label for="">Second Operand</label>
    <input type="text" name="secondOperand">
    <button type="submit">calculate</button>
  </form>
  </body>
</html>
