<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<c:url value="/static/js/jquery-3.1.1.min.js"/>"></script>
<script type="text/javascript">
	$().ready(function(){
		$("#writeForm").find("input[type=button]").click(function(){
			$("#writeForm").attr({
				"action": "/boardTest/board/write",
				"method": "post"
			});
			$("#writeForm").submit();
		});
	});
</script>
</head>
<body>
<h2>MyBoard 글쓰기</h2><hr/>
<form:form commandName="writeForm" enctype="multipart/form-data">
	<input type="text" id="writer" name = "writer" placeholder="작성자"/><br/>
	<input type="text" id="subject"  name = "subject" placeholder="주제를 입력하세요"/>
		<form:errors path="subject"/>
		<br/>
	<input type="text" id="content"  name = "content" placeholder="내용을 입력하세요"/><br/>
	<input type="file" id="post" name="file"/><br/>
	<input type="button" value="저장"/>
</form:form>
</body>
</html>