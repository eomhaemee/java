<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>	
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<c:url value="/static/js/jquery-3.1.1.min.js"/>"></script>
<script type="text/javascript">
$().ready(function() {
	$("#singInForm").find("input[type=button]").click(function(){
		$("#singInForm").attr({
			"action":"<c:url value="/user/signIn"/>",
			"method" : "post"
		});
		$("#singInForm").submit();
	});


});
</script>
</head>
<body>
<form:form commandName="singInForm">
		 <input type="text" name="userId" placeholder="ID를 입력하세요" />
		 	<form:errors path="userId"/><br/>
		 <input type="password" name="userPassword" placeholder="비밀번호를 입력하세요" />
		 	<form:errors path="userPassword"/><br/>
		 <input type="submit" value="로그인" />
</form:form>
</body>
</html>