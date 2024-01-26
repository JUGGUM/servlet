<%--
  Created by IntelliJ IDEA.
  User: rkdud
  Date: 2023-12-28
  Time: 오후 1:23
  To change this template use File | Settings | File Templates.
--%>
<%--바로밑에줄은 jsp문서라는 뜻 jsp는 항상이줄이있다.--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/jsp/members/save.jsp" method="post">
    username : <input type="text" name="username"/>
    age : <input type="text" name="age"/>
    <button type="submit">전송</button>
</form>
</body>
</html>
