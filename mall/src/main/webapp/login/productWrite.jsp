<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link href="https://fonts.googleapis.com/css2?family=Poor+Story&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Gowun+Dodum&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/css/session.css">
<body>
	<header>
		<%@ include file="/header.jsp"%>
	</header>
	<section>
	<h2> 상품 등록 </h2>
		<form action="productWrite.do" method="post"
			enctype="multipart/form-data">
			<table border="1">
				<tr>
					<th>상품명</th>
					<td colspan="3"><input type="text" name="title" size="50"></td>
				</tr>
				<tr>
					<th>가격</th>
					<td><input type="number" name="price" size="10"></td>
					<th>입고량</th>
					<td><input type="number" name="stock" size="10"></td>
				</tr>
				<tr>
					<th>이미지</th>
					<td colspan="3"><input type="file" name="imagefile" size="50"></td>
				</tr>
				<tr>
					<th>설명</th>
					<td colspan="3"><textarea name="descript"></textarea></td>
				</tr>
			</table>
			<div id="for-inline-center">
				<input type="submit" value="등록"> <input type="reset"
					value="다시 작성"> <input type="button" value="목록"
					onclick="goList()">
			</div>
		</form>
	</section>
	<script>
		function goList() {
			location.href = "productList.do";
		}
	</script>
</body>
</html>