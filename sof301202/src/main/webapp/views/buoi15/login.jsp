<%--
  Created by IntelliJ IDEA.
  User: lovep
  Date: 4/12/2025
  Time: 7:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    ${errorMessage} <br>
    <form action="/buoi15/login" method="post">
        Username: <input type="text" name="user"> <br>
        Password: <input type="password" name="password"> <br>
        <button>Submit</button>
    </form>
</body>
</html>
