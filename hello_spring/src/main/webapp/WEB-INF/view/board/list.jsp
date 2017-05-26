<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<c:url value="/static/js/jquery-3.1.1.min.js"/>"></script>
<script type="text/javascript">

	$().ready(function(){
		$("#searchForm").find("input[type=button]").click(function(){
			
		});
		
	});

</script>
</head>
<body>
<h2>Hello_Spring Board</h2><hr/>
	 <a href="<c:url value="/board/write"/>">글쓰기</a>
	<div id="nav">
			<a href="<c:url value="/user/signIn"/>">로그인</a> | 
			<a href="<c:url value="/user/signUp"/>">회원가입</a>| 
			<a href="<c:url value="/user/logout"/>">로그아웃</a>
	</div>	
	<div>
		<c:if test="${not empty sessionScope._USER_ }">
						${sessionScope._USER_.userName}님 , 환영합니다.
		</c:if>
	</div>

		<table>
			<tr>
				<th>번호</th>
				<th>주제</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
			<c:forEach items="${allArticles}" var="article">
				<tr>
					<td>${article.boardId}</td>
					<%-- <td><a href="/hello_spring/board/detail/${article.boardId}">${article.subject}</a></td> --%>
					<td><a href="<c:url value="/board/detail/${article.boardId}"/>">${article.subject}</a></td>
					<td>${article.writer}</td>
					<td>${article.content}</td>
				</tr>
			</c:forEach>
			
		</table>
		
		<div>
			<form id="searchForm">
				${pager}<br/><br/><br/>
				검색<br/>
				주제:<input type="text" name="keyword"/><br/>
				작성자:<input type="text" name="writer"/><br/>
				내용:<input type="text" name="content"/><br/>
				<!--  movePage(0) : 0번 page로 이동, form의 내용도 전송 -->
				<input type="button" value="검색"  onclick="movePage(0)"/>
			</form>
		</div>
</body>
</html>