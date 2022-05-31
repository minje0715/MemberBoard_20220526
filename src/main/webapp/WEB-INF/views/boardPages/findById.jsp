<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-05-27
  Time: 오전 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="../layout/header.jsp" flush="false"></jsp:include>
<div class="container">
    <table class="table">
        <tr>
            <th>글번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>내용</th>
            <th>조회수</th>
            <th>작성시간</th>
        </tr>
            <tr>
                <td>${board.bid}</td>
                <td>${board.boardTitle}</td>
                <td>${board.boardWriter}</td>
                <td>${board.boardContents}</td>
                <td>${board.boardHits}</td>
                <td>${board.boardCreatedDate}</td>
            </tr>
    </table>
</div>
<div class="text-center">
<c:choose>
    <c:when test="${sessionScope.loginMemberId eq board.boardWriter}">
        <button onclick="boardUpdate()" class="btn btn-primary">수정</button>
        <button onclick="list()" class="btn btn-dark">글목록</button>
        <button onclick="boardDelete()" class="btn btn-danger">삭제</button>
    </c:when>
    <c:otherwise>
        <button onclick="list()" class="btn btn-dark">글목록</button>
    </c:otherwise>
</c:choose>
</div>
<script>
    const list = () => {
        location.href = "/board/list";
    }
    const boardUpdate = () => {
        location.href = "/board/update?id=${board.bid}";
    }
    const boardDelete = () => {
        location.href = "/board/delete?id=${board.bid}";
    }
</script>
</body>
</html>
