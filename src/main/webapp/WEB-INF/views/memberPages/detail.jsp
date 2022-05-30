<%--
  Created by IntelliJ IDEA.
  User: 민제
  Date: 2022-05-28
  Time: 오후 2:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="/resources/js/jquery.js"></script>
    <style>
        input {
            display: block;
        }
    </style>
</head>
<body>

<input type="text" value="${sessionScope.loginId}" id="loginMemberId" readonly>
<input type="password" id="memberPassword" name="memberPassword">
<div id="pwCheckResult"></div>
<button type="button" value="확인" onclick="memberPassword()">확인</button>


<script>
    const memberPassword = () => {
        const loginMemberId = document.getElementById("loginMemberId").value;
            const memberPassword = document.getElementById("memberPassword").value;
            const pwCheckResult = document.getElementById("pwCheckResult");
        $.ajax({
            type: "post",
            url: "/member/pwCheck",
            data: {"memberPassword1": memberPassword,"memberId1": loginMemberId },
            dataType: "json",
            success: function (pwCheck1){
                if(pwCheck1){
                    alert("비밀번호가 일치합니다")
                    location.href ="/member/updateForm";
                }else{
                    pwCheckResult.innerHTML = "비밀번호가 틀립니다";
                    pwCheckResult.style.color = "red";
                }
            },
            error: function (){
                alert("ㅋㅋㅋ 다시하세요");
            }
        })
    }
</script>
</body>

</html>
