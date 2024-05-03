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
	<link href="https://fonts.googleapis.com/css2?family=Poor+Story&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Gowun+Dodum&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="/css/session.css">
</head>
<body>
    <header>
        <%@ include file="/header.jsp"%>
    </header>
	<section>
	<h2>${sessionScope.username}'s 장바구니.</h2>
    <div>
	<form method="post" action="BuyinBasket.do">
		<table border="1">
			<thead>
				<tr>
					<th> <input type="checkbox" id="allchk" checked /> <label for="allchk" >전체 선택</label> </th>
					<th>상품 이미지</th>
					<th>상품명</th>
					<th>재고</th>
					<th>수량</th>
					<th>개당가격</th>
					<th>합계</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="b" items="${blist }">
					<tr>
						<input type="hidden" name="pcode" value="${b.pcode}"/>
						<td><input type="checkbox" class="chk" name="selected" value="${b.pcode}" checked></td>
						<td><img id="list" src="images/${b.pictureUrl }" alt="${b.title } 사진"></td>
						<td>${b.title }</td>
						<td class="stock">${b.stock}</td>
						<td>
						<input type="number" class="amount" name="amount" size="10" value="${b.amount}"/>
						<button type="button" class="chang-btn" onclick="changeApply()"> 변경 </button>
						</td>
						<td>${b.price }</td>
						<td>${b.totalprice }</td>
						<td><button type="button" onclick="deleteBasket('${sessionScope.id}',${b.pcode})"> 삭제 </button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div id="for-inline-center">
			<input type="submit" value="구매" onClick="return checkBeforePost()" />
		</div>
		</form>
	</div>
    
	</section>

	<script>
		const chks = document.querySelectorAll(".chk");
		const allchk = document.getElementById("allchk");
		const stocks = document.querySelectorAll(".stock");
		const amounts = document.querySelectorAll(".amount");

		function checkBeforePost(){
			let amountMoreThanStock = false;
			let isNoSelectionCheck = true;
			
			for(let chk of chks){
				if(chk.checked){
                    isNoSelectionCheck = false;
                }
			}
			if(isNoSelectionCheck){
				alert("선택된 항목이 없음.");
                return false;
			}
			
			
			for(let i = 0; i<chks.length; i++){
				console.log('stock : ' + stocks[i].innerHTML+ ', ' + 'amount : ' + amounts[i].value);
				if(chks[i].checked){
                    if(Number(stocks[i].innerHTML) < Number(amounts[i].value)){
                        amountMoreThanStock = true;
                    }
                }
			}
			if(amountMoreThanStock){
				alert("주문 수량에 비해 재고가 부족합니다.");
				return false;
			}


			return true;
		}

		function deleteBasket(uid, pcode){
			let isDelete = confirm("삭제 ?");
			if(isDelete){
				location.href="BasketDelete.do?uid="+uid+"&pcode="+pcode;
			}
		}
		
		for(let chk of chks){
			chk.addEventListener("change",f);
		}
		
		function f(){
			for(chk of chks){
				if(chk.checked){
                    allchk.checked = true;
                }
                else{
                    allchk.checked = false;
					return;
                }
			}
		}

		allchk.addEventListener("change",f2);

		function f2(){
			for(chk of chks){
                chk.checked = allchk.checked;
            }
		}

		checkBeforePost();

	</script>
</body>
</html>