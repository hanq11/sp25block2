<%--
  Created by IntelliJ IDEA.
  User: lovep
  Date: 3/18/2025
  Time: 7:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Update
    <form action="/but-xoa/update" method="post">
        Id: <input type="text" name="id" value="${butXoa.id}"> <br>
        Ten: <input type="text" name="ten" value="${butXoa.ten}"/>
        <br/>
        Gia : <input type="text" name="gia" value="${butXoa.gia}"/>
        <br/>
        Cong dung: <input type="text" name="congDung" value="${butXoa.congDung}"/>
        <br/>
        <button type="submit">Update</button>
    </form>
</body>
</html>
