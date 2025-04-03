<%--
  Created by IntelliJ IDEA.
  User: lovep
  Date: 4/3/2025
  Time: 7:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="/views/buoi11/jquery-3.7.1.min.js" type="text/javascript"> </script>
    <script>
        function loadDuLieu() {
            $.ajax({
                url: "/ajax/api",
                type: "get",
                dataType: "json",
                success: function (data) {
                    document.getElementById("duLieu").innerText = data.id + ' ' + data.mssv + ' ' + data.ten;
                },
                error: function () {
                    document.getElementById("duLieu").innerText = 'Khong lay duoc thong tin'
                }
            })
        }
    </script>
</head>
<body>
    Thong tin: <span id="duLieu"></span> <br>
    <button onclick="loadDuLieu()">Lay du lieu</button>
</body>
</html>
