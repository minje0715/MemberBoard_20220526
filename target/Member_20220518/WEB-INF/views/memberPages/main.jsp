<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-05-27
  Time: 오전 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>main.jsp</h2>
    [로그인 회원 정보] ${loginMember} <br/>
    [로그인 아이디] ${sessionScope.loginMemberId} <br/>
    [회원번호] ${sessionScope.loginId} <br/>
    <button><a href="/board/save">글작성</a></button>
    <button><a href="/member/myPage">마이페이지</a></button>
</body>
</html>
