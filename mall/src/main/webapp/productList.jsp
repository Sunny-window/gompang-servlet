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
	<div>
		<table border="1">
			<thead>
				<tr>
					<th>상품</th>
					<th>상품명</th>
					<th>가격</th>
					<th>재고량</th>
					<th>   </th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="product" items="${plist }">
					<tr>
						<td><img id="list" src="images/${product.pictureUrl }" alt="${product.title } 사진"></td>
						<td>${product.title }</td>
						<td>${product.price }</td>
						<td>${product.stock }</td>
						<td><input id="putinbtn" type="button" value="담기"onclick="putIn('${sessionScope.id}',${product.pcode})"></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	</section>

	<script>
		function putIn(id, pcode){
			var uid = '<%=(String)session.getAttribute("id")%>';
			if( uid == 'null'){
				alert("로그인이 필요합니다.");
				location.href="/login.jsp";
				return;
			}
			let amount = prompt("장바구니에 담을 수량 입력 : ",1);
			if(amount == null ){
				alert("장바구니에 담을 수량을 입력해주세요.");
			}
			else if(!Number(amount)){
				alert("숫자를 입력해 주세요.");
			}
			else {
				location.href="PutInBasket.do?uid="+id+"&pcode="+pcode+"&amount="+amount;
			}
		}
	</script>
</body>
</html>