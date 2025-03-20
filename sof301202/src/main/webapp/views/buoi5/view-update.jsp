<%--
  Created by IntelliJ IDEA.
  User: lovep
  Date: 3/20/2025
  Time: 7:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Sua thong tin: <br>
    <form action="/dieu-hoa/update" method="post">
        Id: <input type="text" name="id" value="${dieuHoa.id}"> <br>
        Ten: <input type="text" name="ten" value="${dieuHoa.ten}"> <br>
        Gia: <input type="text" name="gia" value="${dieuHoa.gia}"> <br>
        Chuc nang: <input type="text" name="chucNang" value="${dieuHoa.chucNang}"> <br>
        Inverter: Co <input type="radio" name="inverter" value="true" ${dieuHoa.inverter == "true" ? "checked" : ""}>
        Khong co <input type="radio" name="inverter" value="false" ${dieuHoa.inverter == "false" ? "checked" : ""}>
        <br>
        <button>Update</button>
    </form>
</body>
</html>
