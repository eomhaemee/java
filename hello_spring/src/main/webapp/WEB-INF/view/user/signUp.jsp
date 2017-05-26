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
	/* $("#signUpForm").find("input[type=button]").click(function(){
		$("#signUpForm").attr({
			"action" : "/hello_spring/user/signUp",
			"method" : "post"
		});
		$("#signUpForm").submit();
	}); */
	$("#signUpForm").find("input[type=button]").click(function(){
		$.post("/hello_spring/user/signUp",
			$("#signUpForm").serialize()
		/* 
			{'userId' : $('#userId').val(),
			'userPassword': $('#userPassword').val(),
			'userName': $('#userName').val()} */
		,function(response){
			
			if(response == 'OK') {
				alert("회원가입이 완료되었습니다!");
				location.href="/hello_spring/board";
				
				/* $("span.login").click();
				$("#id").val($("#userId").val());
				$("#password").focus(); */
			}
			else if(response == "PWFAIL"){
				alert("비밀번호는 영소문자와 영대문자, 숫자, 특수문자로 이루어진 8글자 이상으로 입력해주세요.");
			}
			else {
				alert($("#userId").val()+ "은(는) 이미 존재하는 아이디 입니다.");
			}
		});
	});

});
</script>
</head>
<body>
<form:form commandName="signUpForm">
	<input type="text" name="userId" id="userId" placeholder="ID를 입력하세요">
		<form:errors path="userId"/> <br/>
	<input type="password" name="userPassword" id="userPassword" placeholder="PW를 입력하세요">
		<form:errors path="userPassword"/><br/>
	<input type="text" name="userName" id="userName" placeholder="이름을 입력하세요"> <br/>
	<input type="button" value="가입하기">
</form:form>

<%-- 	<form id="signUpForm" >
		<input type="text" name="userId" id="userId" placeholder="ID를 입력하세요"> <br/>
		<input type="password" name="userPassword" id="userPassword" placeholder="PW를 입력하세요"><br/>
		<input type="text" name="userName" id="userName" placeholder="이름을 입력하세요"> <br/>
		<input type="button" value="가입하기">
	</form> --%>
</body>
</html>