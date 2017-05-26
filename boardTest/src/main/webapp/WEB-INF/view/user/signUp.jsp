<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 	
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<c:url value="/static/js/jquery-3.1.1.min.js"/>"></script>
<script type="text/javascript">
	$().ready(function(){
		$("#signUpForm").find("input[type=button]").click(function(){
			$("#signUpForm").attr({
				"action" : "/boardTest/user/signUp",
				"method" : "post"
			});
			$("#signUpForm").submit();
		});
	});
</script>
</head>
<body>
<form id ="signUpForm">
	<input type="text" id="userId" name = "userId" placeholder="ID를 입력하세요"/><br/>
	<input type="text" id="userPassword" name="userPassword" placeholder="Password를 입력하세요"/><br/>
	<input type="text" id="userName" name="userName" placeholder="이름을 입력하세요"/><br/>
	<input type="button" value="회원가입"/>
</form>
</body>
</html>