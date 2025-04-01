<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lovep
  Date: 3/20/2025
  Time: 7:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Them thong tin: <br>
    <form action="/dieu-hoa/add" method="post">
        Ten: <input type="text" name="ten"> <br>
        Gia: <input type="text" name="gia"> <br>
        Chuc nang: <input type="text" name="chucNang"> <br>
        Inverter: Co <input type="radio" name="inverter" value="true">
        Khong co <input type="radio" name="inverter" value="false">
        <br>
        Hang: <select name="hang">
                <c:forEach items="${listHang}" var="hang">
                    <option value="${hang.id}" label="${hang.ten}"></option>
                </c:forEach>
            </select>
        <br>
        <button>Add</button>
    </form>
    <br>
    Bang thong tin: <br>
    <table>
        <thead>
            <tr>
                <th>Id</th>
                <th>Ten</th>
                <th>Gia</th>
                <th>Chuc nang</th>
                <th>Inverter</th>
                <th>Hang</th>
                <th>Hanh dong</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${danhSach}" var="dieuHoa">
                <tr>
                    <td>${dieuHoa.id}</td>
                    <td>${dieuHoa.ten}</td>
                    <td>${dieuHoa.gia}</td>
                    <td>${dieuHoa.chucNang}</td>
                    <td>${dieuHoa.inverter ? "Co" : "Khong co"}</td>
                    <td>${dieuHoa.hang.ten}</td>
                    <td>
                        <a href="/dieu-hoa/detail?id=${dieuHoa.id}">Detail</a>
                        <a href="/dieu-hoa/view-update?id=${dieuHoa.id}">View update</a>
                        <a href="/dieu-hoa/delete?id=${dieuHoa.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="/dieu-hoa/phan-trang?page=${pageNumber  - 1}">Prev</a>
    <a href="/dieu-hoa/phan-trang?page=${pageNumber  + 1}">Next</a>
</body>
</html>
