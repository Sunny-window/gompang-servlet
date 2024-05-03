<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%-- JSTL Core --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link href="https://fonts.googleapis.com/css2?family=Poor+Story&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Gowun+Dodum&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="/css/session.css">
</head>
<body>
	<header>
		<%@ include file="/header.jsp"%>
	</header>
	<section>
	<p>관리자 페이지.</p>
    <table border="1">
        <thead>
            <tr>
                <th> 유저 아이디 </th>
                <th> 유저 이름 </th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="u" items="${userlist}">
            <tr>
                <td>${u.uid}</td>
                <td>${u.username}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
	<a href="/M_productList.do"> 상품 관리로 이동 </a>
	</section>

</body>
</html>