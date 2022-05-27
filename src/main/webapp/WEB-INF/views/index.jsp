<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-05-26
  Time: 오후 1:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>


</head>
<body>
    <h2>index.jsp</h2>
    <a href="/member/save">회원가입</a>
    <a href="/member/login">로그인</a>
    <a href="/member/list"></a>

    로그인 회원 정보: ${loginMember}
    세션에 담은 memberId: ${sessionScope.loginMemberId}
    세션에 담은 id: ${sessionScope.loginId}
</body>
</html>
