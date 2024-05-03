<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1>
	<a href="/index.jsp"> 쿠팡 대신 곰팡 </a>
</h1>
<h3 class="header-h3">
	<c:choose>
		<c:when test="${sessionScope.id==null}">
			<a href="/login.jsp"> 로그인 </a>
		</c:when>
		<c:otherwise>
		<div class="nav-userinfo">
			<img id="img-alram" src="/images/hasNoAlram.png" 
				onclick="(location.href='/login/userpage.jsp')"> 
			<span id="nav-userinfo-span"> 접속중인 ID : ${sessionScope.id} / ${sessionScope.username}님 </span>
			<a href="Logout"> 로그아웃 </a>
		</div>
		</c:otherwise>
	</c:choose>
</h3>
<c:choose>
	<c:when test="${sessionScope.id==null}">
		<div class="nav-con">
			<%@ include file="/defalut_nav.jsp"%>
		</div>
	</c:when>
	<c:otherwise>
		<div class="nav-con">
			<%@ include file="/login/user_nav.jsp"%>
			<c:choose>
				<c:when test="${sessionScope.id == 'root' || sessionScope.id == 'admin'}">
					<a href="/ManagerCheck">관리자 페이지</a>
				</c:when>
			</c:choose>
		</div>
	</c:otherwise>
</c:choose>