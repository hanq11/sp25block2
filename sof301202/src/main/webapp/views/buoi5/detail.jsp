<%--
  Created by IntelliJ IDEA.
  User: lovep
  Date: 3/20/2025
  Time: 7:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Thong tin chi tiet:
    id: ${dieuHoa.id} </br>
    ten: ${dieuHoa.ten} </br>
    gia: ${dieuHoa.gia} </br>
    chucNang: ${dieuHoa.chucNang} </br>
    inverter: ${dieuHoa.inverter ? "Co" : "Khong co"} </br>
</body>
</html>
