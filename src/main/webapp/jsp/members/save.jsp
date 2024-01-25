<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- 패키지를 임포트하는 부분 --%>
<%--
  Created by IntelliJ IDEA.
  User: rkdud
  Date: 2023-12-29
  Time: 오전 9:48
  To change this template use File | Settings | File Templates.
--%>
<%
    // 해당 선언을 한 후 자바코드 사용가능
    // % 이것만쓰면 입력 %= 이것쓰면 자바출력
    // request, response 사용 가능
    MemberRepository memberRepository = MemberRepository.getInstance();

    System.out.println("save.jsp");
    String username = request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age"));
    Member member = new Member(username, age);
    System.out.println("member = " + member);
    memberRepository.save(member);
%>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
성공
<ul>
    <li>id=<%=member.getId()%></li>
    <li>username=<%=member.getUsername()%></li>
    <li>age=<%=member.getAge()%></li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>
