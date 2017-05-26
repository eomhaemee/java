<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>MyBoard</h2><hr/>
	<div><a href="<c:url value="/board/write"/>">글쓰기</a></div>
	<div><a href="<c:url value="/user/signUp"/>">회원가입</a></div>
	<div><a href="<c:url value="/user/signIn"/>">로그인</a></div>
	<table>
		<tr>
			<td>게시글번호</td>
			<td>주제</td>
			<td>작성자</td>
			<td>작성일</td>
		</tr>
		
		<c:forEach items="${boards}" var="board">
	
			<tr>
				<td>${board.boardId }</td>
				<%-- <td><a href="/boardTest/board/detail/${board.boardId}">${board.subject}</a></td> --%>
				<td><a href="<c:url value="/board/detail/${board.boardId}"/>">${board.subject}</a></td>
				<td>${board.writer }</td>
				<td>${board.writeDate }</td>
			</tr>

		</c:forEach>
	</table>
	

</body>
</html>