<%--
  Created by IntelliJ IDEA.
  User: 민제
  Date: 2022-05-29
  Time: 오후 12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="resources/css/bootstrap.min.css">
    <style>
        input {
            display: block;
        }
    </style>
</head>
<body>

<form action="/update" method="post" name="update">
    <input type="text" name="memberId" id="memberId" value="${updateMember.memberId}" readonly>
    <input type="text" name="memberPassword" placeholder="비밀번호">
    <input type="text" name="memberName" value="${updateMember.memberName}" readonly>
    <input type="text" name="memberEmail" value="${updateMember.memberEmail}" readonly>
    <input type="tel" name="memberPhone"
           required pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" title="###-####-####" placeholder="전화번호">
    <input type="button" value="수정">
</form>

</body>
</html>
