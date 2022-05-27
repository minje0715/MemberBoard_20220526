<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-05-26
  Time: 오후 3:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
<html>
<head>
    <title>Title</title>

</head>
<body>
    <h2>login.jsp</h2>
    <form action="/member/login" method="post">
    <input class="form-control mb-2" type="text" name="memberId" placeholder="아이디">
    <input class="form-control mb-2" type="password" name="memberPassword" placeholder="비밀번호">
    <input class="btn btn-primary" type="submit" value="로그인">
    </form>
</body>
</html>
