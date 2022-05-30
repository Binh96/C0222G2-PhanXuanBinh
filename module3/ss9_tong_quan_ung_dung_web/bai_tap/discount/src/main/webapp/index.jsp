<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/29/2022
  Time: 8:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Discount</title>
  </head>
  <body>
  <form action="/display-discount" method="post">
    <label for="">Product Description</label>
    <input type="text" placeholder="Product Description" name="productdesc">
    <label for="">List Price</label>
    <input type="number" placeholder="List Price" name="listprice">
    <label for="">Discount Percent</label>
    <input type="text" placeholder="Discount Percent" name="discountpercent">
    <button>Calculate</button>
  </form>
  </body>
</html>
