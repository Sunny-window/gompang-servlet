<%@page import="dao.ProductDao"%>
<%@page import="vo.ProductVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
ProductDao pDao = new ProductDao();
int pcode = Integer.parseInt(request.getParameter("pcode"));

ProductVO product = pDao.getProduct(pcode);

pageContext.setAttribute("product", product);
%>
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
	<h2> 상품 등록 해제 </h2>
		<form action="productDelete.do" method="get">
			<input type="hidden" name="pcode" value="${product.pcode }">
			<input type="hidden" name="pictureUrl" value="${product.pictureUrl }">
			<div id="for-inline-center">
				<img src="images/${product.pictureUrl }" alt="${product.title } 사진">
			</div>
			<div>
				<table border="1">
					<tr>
						<th>상품명</th>
						<td>${product.title }</td>	
					</tr>
					<tr>
						<th>가격</th>
						<td>${product.price }</td>
					</tr>

					<tr>
						<th>설명</th>
						<td>${product.descript }</td>
					</tr>
				</table>
				<div id="for-inline-center">
					<input type="submit" value="데이터 삭제"> <input type="button"
						value="목록으로" onclick="goList()">
				</div>
			</div>
		</form>
	</section>
	<script>
		function goList() {
			location.href = "M_productList.do";
		}
	</script>
</body>
</html>