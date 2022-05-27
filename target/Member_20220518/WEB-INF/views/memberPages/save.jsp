<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-05-26
  Time: 오후 3:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <script src="/resources/js/jquery.js"></script>
</head>
<body>

<h2>save.jsp</h2>
<form action="/member/save" method="post">
    <input class="form-control mb-2" type="text" name="memberId" id="memberId" placeholder="아이디" onblur="duplicateCheck()">
    <span id="id-check-result"></span>
    <input class="form-control mb-2" type="text" name="memberPassword" placeholder="비밀번호">
    <input class="form-control mb-2" type="text" name="memberName" placeholder="이름">
    <input class="form-control mb-2" type="text" name="memberEmail" placeholder="이메일">
    <input class="form-control mb-2" type="tel" name="memberPhone"
           required pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" title="###-####-####" placeholder="전화번호">
    <input class="btn btn-primary" type="submit" value="가입">
</form>
</body>
<script>
    const duplicateCheck = () => {
        const memberId = document.getElementById("memberId").value;
        const idCheck = document.getElementById("id-check-result");
        $.ajax({
            type: "post", // 보낼타입
            url: "/member/duplicate-check", //주소값
            data: {"memberId": memberId}, //보낼 데이터
            dataType: "text", //데이터 타입
            success: function (checkResult) {
                if (checkResult == "ok") {
                    // 사용가능한 아이디
                    idCheck.innerHTML = "멋진 아이디군요 !!";
                    idCheck.style.color = "green";
                } else {
                    // 이미 사용중인 아이디
                    idCheck.innerHTML = "사용중인 아이디입니다";
                    idCheck.style.color = "red";
                }
                alert("아이디 중복체크 성공!!");
            },
            error: function () {
                alert("오타체크");
            }
        })
    }
</script>
</html>
