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
$().ready(function() {
	$("#delete").find("input[type=button]").click(function(){
		$("#delete").attr({
			"action" : "/hello_spring/board/delete/"+$("#deletebtn").data("boardid"),
			"method" : "post"
		});
		$("#delete").submit();
	});
});
</script>

</head>
<body>

	<span style="background-color: blue;">${article.subject}</span><br/>
		<c:if test="${not empty article.displayFileName }">
			<p><img width="200px" height="200px" src="<c:url value="/board/download/${article.boardId}"/>"></p>
			<a href="<c:url value="/board/download/${article.boardId}"/>">${article.displayFileName}</a>
		</c:if>
	<span>${article.writer}</span><br />
	<span>${article.content}</span><br />

<form id="delete">
 <input id="deletebtn" type="button" value="삭제" data-boardid="${article.boardId}"/> 
</form>
	 <a href="<c:url value="/board/delete/${article.boardId}"/>">삭제</a>
</body>
</html>