<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
성공
<ul>
    <li>id=${member.id}</li>
    <li>username=${member.username}</li>
    <li>age=${member.age}</li>
    <%--프로퍼티 접근법 ${} 해당 문법으로 접근하면 request의 attribute에 담긴 데이터를 편리하게 조회가능--%>
</ul>
<a href="/index.html">메인</a>
</body>
</html>
