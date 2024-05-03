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
	<h2>Login 페이지</h2>
		<form method="post" action="LoginServlet" >
			<div class="input">
				<label for="uid"> 아이디 : </label> <input type="text" id="uid"
					name="uid" placeholder="id" />
			</div>
			<div class="input">
				<label for="pwd"> 비밀번호	</label> <input type="password" id="pwd"
					name="pwd"/>
			</div>
            <div class="input">
                <input type="submit" value="로그인" />
            </div>
		</form>
	</section>

    
</body>
</html>