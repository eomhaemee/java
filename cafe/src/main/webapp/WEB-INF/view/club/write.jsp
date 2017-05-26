<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="<c:url value="/static/js/jquery-3.1.1.min.js"/>"></script>
<script src="<c:url value="/static/js/ckeditor/ckeditor.js"/>"></script>
<script type="text/javascript">
	$().ready(function(){
		$("#saveBtn").click(function(){
			$("#writeForm").attr({
				"method":"post",
				"action":"<c:url value="/club/write/${menuId}"/>"
			});
			/* alert("<c:url value="/club/write/${menuId}"/>"); */
			$("#writeForm").submit();
		});
	});
</script>
</head>
<body>
	<form id="writeForm">
		<input type="text" name="subject" id="subject"/>
		<input type="hidden" name="csrf_token" value="${sessionScope._CSRF_TOKEN_}" />
		<textarea name="content" id="content" rows="10" cols="80">
                This is my textarea to be replaced with CKEditor.
            </textarea>
		<script>
                // Replace the <textarea id="editor1"> with a CKEditor
                // instance, using default configuration.
                CKEDITOR.replace( 'content' );
            </script>
	</form>
	<div id="uploadFiles"></div>
	<div>
		<!-- target: 전송할 대상 지정 ajax로는 파일을 못보내니 iframe 위치에 target을 줘서 처리하자 -->
		<form target="uploadFrame"
				method="post" action="<c:url value="/club/upload"/>"
				enctype="multipart/form-data">
			<input type="file" name="file"/> 
			<input type="submit" value="Upload!!!"/>
		</form>
		<iframe name="uploadFrame" style="display:none;"></iframe>
	</div>
	<!-- onclick="alert(CKEDITOR.instances.content.getData());" -->
	<input type="button" id="saveBtn" value="Save"/>
	<input type="button" id="cancelBtn" value="Cancel"/>

</body>
</html>