<%@page import="vo.ProductVO"%>
<%@page import="dao.ProductDao"%>
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
	<h2> 상품 업데이트 </h2>
		<div id="for-inline-center">
			<img src="images/${product.pictureUrl }" alt="${product.title } 사진">
		</div>
		<div>
			<form action="productUpdate.do" method="post"
				enctype="multipart/form-data">
				<input type="hidden" name="pcode" value="${product.pcode }" >
				<table border="1">
					<tr>
						<th>상품명</th>
						<td colspan="3"><input type="text" name="title" size="50"
							value="${product.title }"></td>
					</tr>
					<tr>
						<th>가격</th>
						<td><input type="number" name="price" size="10"
							value="${product.price }"></td>
						<th>재고량</th>
						<td><input type="number" name="stock" size="10"
							value="${product.stock }"></td>
					</tr>
					<tr>
						<th>이미지</th>
						<td colspan="3"><input type="file" name="imagefile" size="50"></td>
					</tr>
					<tr>
						<th>설명</th>
						<td colspan="3"><textarea name="descript">${product.descript }</textarea>
						</td>
					</tr>
				</table>
				<div id="for-inline-center">
					<input type="submit" value="수정"> <input type="button"
						value="목록" onclick="goList()">
				</div>
			</form>
		</div>
	</section>
	<script>
		function goList() {
			location.href = "M_productList.do";
		}
	</script>
</body>
</html>