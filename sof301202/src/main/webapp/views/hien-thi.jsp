<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lovep
  Date: 3/13/2025
  Time: 8:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Thong tin
<form action="/but-xoa/add" method="post">
    Ten: <input type="text" name="ten"/>
    <br/>
    Gia : <input type="text" name="gia"/>
    <br/>
    Cong dung: <input type="text" name="congDung"/>
    <br/>
    <button type="submit">Add</button>
</form>
<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Ten</th>
        <th>Gia</th>
        <th>Cong dung</th>
        <th>Hanh dong</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${danhSach}" var="butXoa">
        <tr>
            <td>${butXoa.id}</td>
            <td>${butXoa.ten}</td>
            <td>${butXoa.gia}</td>
            <td>${butXoa.congDung}</td>
            <td>
                <a href="/but-xoa/delete?id=${butXoa.id}">Remove</a>
                <a href="/but-xoa/view-update?id=${butXoa.id}">Update</a>
                <a href="/but-xoa/detail?id=${butXoa.id}">Detail</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
