<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<span>${board.subject }</span>/
	<span>${board.writer }</span>/
	<span>${board.writeDate }</span>/
	<span>${board.content }</span>/
	<span>${board.likeCount }</span>
    <a href="<c:url value="/board/delete/${board.boardId}"/>">삭제</a>
</body>
</html>