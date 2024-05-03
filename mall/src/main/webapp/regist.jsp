<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- JSTL Core --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
request.setCharacterEncoding("UTF-8");
// post 방식으로 parameter 받을 때 한글을 인코딩하기 위해
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title></title>
<!-- 폰트 첨부 -->
<link
	href="https://fonts.googleapis.com/css2?family=Poor+Story&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Gowun+Dodum&display=swap"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/session.css">
</head>
<body>
	<header>
		<%@ include file="header.jsp"%>
	</header>
	<section>
        <h2>회원가입 페이지</h2>
		<form method="post" action="RegistServlet" onsubmit="return AllCheck()">

			<div class="input">
				<label for="uid"> 아이디 : </label> <input type="text" id="uid"
					name="uid" placeholder="id" />
                <button type="button" onclick="idcheck()">ID 중복검사</button>
                <span id="id_check_result"></span>
			</div>
			<div>
				<label for="pwd"> 비밀번호 : </label> 
                <input type="password" id="pwd" name="pwd"/>
                <span id="pwd_check_result"></span>
			</div>
            <div>
				<label for="pwd2"> 비밀번호 확인 : </label> 
                <input type="password" id="pwd2" name="pwd2"/>
                <span id="pwd2_check_result"></span>
			</div>
			<div class="input">
				<label for="username"> 이름 : </label> 
                <input type="text" id="username" name="username" placeholder="이름" />
			</div>
            <input type="submit" id="submit" name="submit" value="전송"/>
		</form>
	</section>

    <script>
        let isIdCheck = false;
        let isPwdCheck = false;
        let isPwdEqual = false;
        
        const pwd = document.getElementById("pwd");
        const pwd2 = document.getElementById("pwd2");

        pwd.addEventListener("keyup", pwdBothCheck);
        pwd2.addEventListener("keyup", pwdBothCheck);
        
        function pwdBothCheck(){
            pwdCheck();
            pwdEqualCheck();
        }

        function pwdEqualCheck(){
            if(isPwdCheck == false) {
                isPwdEqual = false;
                return;
            }
            if(pwd.value == pwd2.value){
                isPwdEqual = true;
                document.getElementById("pwd2_check_result").innerHTML = "비밀번호가 일치합니다.";
                document.getElementById("pwd2_check_result").style.color="blue";
            }
            else{
                isPwdEqual = false;
                document.getElementById("pwd2_check_result").innerHTML = "비밀번호가 일치하지 않습니다.";
                document.getElementById("pwd2_check_result").style.color="red";
            }
        }

        function idcheck() {
            const span = document.getElementById("id_check_result");
            let userID = document.getElementById("uid").value;
            if(userID == "" || userID == null){
                span.style.color="red";
                span.innerHTML = "아이디를 입력하세요.";
                isIdCheck = false;
                return;
            }
            const xhttp = new XMLHttpRequest();
            xhttp.onload = function() {
                let result = this.responseText;
                let msg = "";
                if(result == "t"){
                    msg = "ID 사용 가능";
                    span.style.color="blue";
                    isIdCheck = true;
                    console.log("true 응답 받음. " + isIdCheck);
                }
                else{ 
                    msg = "중복된 ID 존재";
                    span.style.color="red";
                    isIdCheck = false;
                }
                span.innerHTML = msg;
            }
            xhttp.open("GET", "IdCheck?uid="+userID, false);
            xhttp.send();
        }

        function pwdCheck(){
            if(pwd.value == "" || pwd.value == null){
                document.getElementById("pwd_check_result").innerHTML = "비밀번호를 입력하세요.";
                document.getElementById("pwd_check_result").style.color="red";
                isPwdCheck = false;
            }
            else {
                document.getElementById("pwd_check_result").innerHTML = "확인완료";
                document.getElementById("pwd_check_result").style.color="blue";
                isPwdCheck = true;
            }
            console.log(
                "id : " + isIdCheck +
                "\npwd : " + isPwdCheck +
                "\npwd_equalCheck : " + isPwdEqual +
                "\nboth : " + (isIdCheck && isPwdCheck)
            );
        }

        function AllCheck(){
            idcheck();
            pwdCheck();
            pwdEqualCheck();

            return (isIdCheck && isPwdCheck && isPwdEqual);
        }
    </script>
</body>
</html>