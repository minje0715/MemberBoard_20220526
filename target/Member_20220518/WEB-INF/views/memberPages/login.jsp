<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-05-26
  Time: 오후 3:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <script src="/resources/js/jquery.js"></script>
    <style>
        header{
            display:flex;
            justify-content: center;
        }
        form{
            padding:10px;
        }
        .input-box{
            position:relative;
            margin:10px 0;
        }
        .input-box > input{
            background:transparent;
            border:none;
            border-bottom: solid 1px #ccc;
            padding:20px 0px 5px 0px;
            font-size:14pt;
            width:100%;
        }
        input::placeholder{
            color:transparent;
        }
        input:placeholder-shown + label{
            color:#aaa;
            font-size:14pt;
            top:15px;

        }
        input:focus + label, label{
            color:#8aa1a1;
            font-size:10pt;
            pointer-events: none;
            position: absolute;
            left:0px;
            top:0px;
            transition: all 0.2s ease ;
            -webkit-transition: all 0.2s ease;
            -moz-transition: all 0.2s ease;
            -o-transition: all 0.2s ease;
        }

        input:focus, input:not(:placeholder-shown){
            border-bottom: solid 1px #8aa1a1;
            outline:none;
        }
        button{
            background-color: #8aa1a1;
            border:none;
            color:white;
            border-radius: 5px;
            width:100%;
            height:35px;
            font-size: 14pt;
            margin-top:100px;
        }

    </style>
</head>
<body>
<h2>login.jsp</h2>
<div class="input-box">
<input type="text" id="memberId2" name="memberId" placeholder="아이디">
    <label for="memberId2">아이디</label>
</div>

<div class="input-box">
<input type="password" id="memberPassword2" name="memberPassword" placeholder="비밀번호">
    <label for="memberPassword2">비밀번호</label>
</div>

<div id="idCheck"></div>

<button onclick="memberId1()">확인</button>

<script>
    const memberId1 = () => {
        const memberId2 = document.getElementById("memberId2").value;
        const memberPassword2 = document.getElementById("memberPassword2").value;
        const idCheck = document.getElementById("idCheck");
        $.ajax({
            type: "post",
            url: "/member/loginCheck",
            data: {"memberId2": memberId2, "memberPassword2": memberPassword2},
            dataType: "text",
            success: function (idCheckResult) {
                if (idCheckResult == "ok") {
                    alert("로그인이 성공합니다")
                    location.href = "/"

                } else {
                    idCheck.innerHTML = "비밀번호를 확인해주세요";
                    idCheck.style.color = "red";
                }
            },
            error: function () {
                alert("코드확인")
            }
        })
    }
</script>
</body>
</html>
