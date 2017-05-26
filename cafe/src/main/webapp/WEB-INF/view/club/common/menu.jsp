<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 
<ul>
	<li>Menu 1</li>
	<ul>
		<li>Menu 1-1</li>
		<li>Menu 1-2</li>
		<li>Menu 1-3</li>			
	</ul>
	<li>Menu 2</li>
	<ul>
		<li>Menu 2-1</li>
		<li>Menu 2-2</li>
		<li>Menu 2-3</li>			
	</ul>
</ul> -->
<style type="text/css">
	li > a:LINK {/*  a:LINK 아직 방문하지 않은 link */
		 color:#333;
		 text-decoration: none; 
	}
	li > a:VISITED {/* a:VISITED: 클릭했던 것 */
		 color:#333;
		 text-decoration: none; /* 밑줄없애기 */
	}
	li > a:HOVER { /* a:HOVER : 마우스를 올리면/ 글자 진해지고, underline */
		color:#111;
		text-decoration: underline; 
	}
	li > a:ACTIVE { /* a:ACTIVE  click한 순간 */
		color: #FF0000;
		text-decoration: underline;
	}
	ul{
		list-style: none;
	}

/* 	li:HOVER {
		background-color: silver;
		color: white;
	} */

</style>
	<div id="login">
	
		<c:if test="${not empty sessionScope._MEMBER_ }">
				${sessionScope._MEMBER_.userName}님 , 환영합니다. <br/><br/>
		</c:if>
		
		<c:if test="${empty sessionScope._MEMBER_ }">
			<a href="<c:url value="/user/signIn"/>">로그인</a> | 
		</c:if>
		<c:if test="${not empty sessionScope._MEMBER_ }">
			<a href="<c:url value="/user/logout"/>">로그아웃</a> |
		</c:if>

			<a href="<c:url value="/user/signUp"/>">회원가입</a>

			
	</div>	
	
<c:set var="depth" value="0"/>

<ul>
<c:forEach items="${menu}" var="menuItem">
	<c:if test="${menuItem.level < prevLevel}">
		</ul>
	</c:if>
	<c:if test="${menuItem.level > prevLevel}">
		<ul>
	</c:if>
	<li><a href="<c:url value="${menuItem.menuUrl}"/>">${menuItem.menuName}</a></li>
	<!-- 비교를 위해 이전의 level을 변수에 담아놓음 / 변수명: prevLevel -->
	<c:set var="prevLevel" value="${menuItem.level}"/>

	<%-- <c:if test="${menuItem.level == 1 }">
		<c:if test="${menuItem.level < prevLevel}">
			</ul></li>
		</c:if>
	</c:if>
	<c:if test="${menuItem.level == 2 }">
		<c:if test="${menuItem.level > prevLevel}">
			<li><ul>
		</c:if>
		<li>${menuItem.menuName}</li>
	</c:if>
	<c:set var="prevLevel" value="${menuItem.level}"/> --%>
</c:forEach>
</ul>

<c:if test="${depth > 0 }">
	<c:forEach var="i" begin="0" end="${depth}" step="1">
	</ul>
	</c:forEach>
</c:if>
