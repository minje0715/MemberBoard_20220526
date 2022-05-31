<%--
  Created by IntelliJ IDEA.
  User: 민제
  Date: 2022-05-27
  Time: 오후 5:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
<jsp:include page="../layout/header.jsp" flush="false"></jsp:include>
</head>
<body>
<div class="container">
    <table class="table">
        <tr>
            <th>글번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>내용</th>
            <th>조회수</th>
            <th>작성시간</th>
            <th>회원삭제</th>
        </tr>
        <c:forEach items="${boardList}" var="board">
            <tr>
                <td>${board.bid}</td>
                <td> <a href="/board/detail?id=${board.bid}">${board.boardTitle}</a></td>
                <td>${board.boardWriter}</td>
                <td>${board.boardContents}</td>
                <td>${board.boardHits}</td>
                <td>${board.boardCreatedDate}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>