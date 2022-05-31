<%--
  Created by IntelliJ IDEA.
  User: 민제
  Date: 2022-05-27
  Time: 오후 6:14
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
<%--    <header>--%>
<%--        <button><a href="/">메인화면</a></button>--%>
<%--        <button><a href="/memberPages/myPage">마이페이지</a></button>--%>
<%--        <button><a href="/member/logout">로그아웃</a></button>--%>
<%--    </header>--%>
<header class="p-3 bg-dark text-white">
    <div class="container">
        <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
            <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
                <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap">
                    <use xlink:href="#bootstrap"></use>
                </svg>
            </a>

            <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">

                <button onclick="boardList()" type="button" class="btn btn-outline-light me-2">메인화면</button>
                <button onclick="boardList()" type="button" class="btn btn-outline-light me-2">글목록</button>
                <button onclick="save1(${sessionScope.loginId})" type="button" class="btn btn-outline-light me-2">글작성
                </button>
                <c:choose>
                    <c:when test="${sessionScope.loginMemberId eq 'admin'}">
                        <button onclick="findId()" type="button" class="btn btn-outline-light me-2">회원목록</button>
                    </c:when>
                </c:choose>
            </ul>

            <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" role="search">
                <input type="search" class="form-control form-control-dark text-white bg-dark" placeholder="Search..."
                       aria-label="Search">
            </form>

            <div class="text-end">
                <c:choose>
                    <c:when test="${sessionScope.loginId == null}">
                        <button onclick="login()" type="button" class="btn btn-outline-light me-2">로그인</button>
                        <button onclick="save()" type="button" class="btn btn-warning">회원가입</button>
                    </c:when>
                    <c:otherwise>
                        <button onclick="myPage()" type="button" class="btn btn-outline-light me-2">마이페이지</button>
                        <button onclick="logout()" type="button" class="btn btn-warning">로그아웃</button>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>
</header>
</body>
<script>
    const save = () => {
        location.href = "/member/save";
    }
    const login = () => {
        location.href = "/member/login";
    }
    const findId = () => {
        location.href = "/member/memberList";
    }
    const myPage = () => {
        location.href = "/member/myPage";
    }
    const logout = () => {
        location.href = "/member/logout";
    }
    const save1 = () => {
        <c:choose>
        <c:when test="${sessionScope.loginId == null}">
        alert("로그인이 필요합니다")
        location.href = "/member/login";
        </c:when>
        <c:otherwise>
        location.href = "/board/saveForm";
        </c:otherwise>
        </c:choose>
    }
    const boardList = () => {
        location.href = "/board/list";
    }
</script>
</html>
