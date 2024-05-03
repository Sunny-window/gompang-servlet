<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css2?family=Poor+Story&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Gowun+Dodum&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="/css/session.css">
</head>
<body>
	<header>
		<%@ include file="/header.jsp"%>
	</header>
	<section>
	<h2> 상품 목록 </h2>
	<div id="for-inline-center">
		<span><a href="/login/productWrite.jsp" style="font-size:24px;">상품등록</a></span>
	</div>
	<div>
		<table border="1">
			<thead>
				<tr>
					<th>번호</th>
					<th>이름</th>
					<th>가격</th>
					<th>재고</th>
					<th>수정</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="product" items="${plist }">
					<tr>
						<td>${product.pcode }</td>
						<td>${product.title }</td>
						<td>${product.price }</td>
						<td>${product.stock }</td>
						<td><a href="productUpdate.jsp?pcode=${product.pcode }">상품수정</a></td>
						<td><a href="productDelete.jsp?pcode=${product.pcode }">상품삭제</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	</section>
</body>
</html>