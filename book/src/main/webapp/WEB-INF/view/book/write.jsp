<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->

<!-- 부트스트랩 -->
<link href="<c:url value="/static/css/bootstrap.min.css"/>" rel="stylesheet">

<!-- IE8 에서 HTML5 요소와 미디어 쿼리를 위한 HTML5 shim 와 Respond.js -->
<!-- WARNING: Respond.js 는 당신이 file:// 을 통해 페이지를 볼 때는 동작하지 않습니다. -->
<!--[if lt IE 9]> 구형 브라우저에서도 돌아갈수 있게 9버전이하면 풀어서 적용함
<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]-->
 
<title>Insert title here</title>
<script type="text/javascript" src="<c:url value="/static/js/jquery-3.1.1.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/static/js/bootstrap.min.js"/>"></script>
<script type="text/javascript">
	$().ready(function(){
	
		
		
	});
</script>
</head>
<body>
<nav class="navbar navbar-default">
	<div class="container">
		<a class="navbar-brand" href="#">Book Store</a>
		<ul class="nav navbar-nav">
			<li><a href="<c:url value="/pub/write"/>">출판사 등록</a></li>
			<li><a href="<c:url value="/auth/write"/>">작가 등록</a></li>
			<li  class="active"><a href="<c:url value="/book/write"/>">책 등록</a></li>
			
		</ul>
	</div>	
</nav>
<div class="container">
	<div class="row"> 
		<div class="col-md-8 col-xs-8" style="border: 1px solid #ccc">
			<form id="writeForm">
				<div class="row">
				 	<div class="col-md-12">
				 		<div class="form-group">
				 			<label for="bookName">책제목</label>
				 			<input class="form-control" type="text"  id="bookName" name="bookName" placeholder="책 제목을 입력하세요"/>
				 		</div>
				 	</div>
				</div>
				<div class="row">	
				 	<div class="col-md-12">
				 		<div class="form-group">
				 			<label for="bookSubName">책부제</label>
				 			<input class="form-control" type="text"  id="bookSubName" name="bookSubName" placeholder="책 부제목을 입력하세요"/>
				 		</div>
				 	</div>
			 	</div>
			 	<div class="row">	
				 	<div class="col-md-6">
				 		<div class="form-group">
				 			<label for="publisherId">출판사</label>
				 			<select class="form-control" id="publisherId" name="publisherId" >
					 			<option value=""> 출판사를 선택하세요</option>
					 			<c:forEach items="${publisher.publisherList}" var="pub">	
									<option value="${pub.publisherId}">${pub.publisherName}</option>			
								</c:forEach> 
					 			
				 			</select>
				 		</div>
				 	</div>
				 	<div class="col-md-6">
				 		<div class="form-group">
				 			<label for="authorId">저자</label>
				 			<select class="form-control" id="authorId" name="authorId">
				 				<option value=""> 저자를 선택하세요</option>
				 				<c:forEach items="${author.authorList}" var="auth">	
				 					<option value="${auth.authorId}">${auth.authorName}</option>
				 				</c:forEach> 
				 				
				 			</select>
				 		</div>
				 	</div>
			 	</div>
			 	<div class="row">	
				 	<div class="col-md-6">
				 		<div class="form-group">
				 			<label for="releaseDate">출판일</label>
				 			<input type="date" class="form-control" id="releaseDate" name="releaseDate"></input>
				 		</div>
				 	</div>
				 	<div class="col-md-6">
				 		<div class="form-group">
				 			<label for="price">가격</label>
				 			<input type="number" class="form-control" id="price" name="price" placeholder="가격을 입력하세요"></input>
				 		</div>
				 	</div>
			 	</div>
			 	<div class="row">	
				 	<div class="col-md-12">
				 		<div class="form-group">
				 			<label for="isbn">ISBN</label>
				 			<input type="text" class="form-control" id="isbn" name="isbn" placeholder="ISBN을 입력하세요"></input>
				 		</div>
				 	</div>
			 	</div>
			 	<div class="row">	
				 	<div class="col-md-12">
				 		<div class="form-group">
				 			<label for="intro">소개</label>
				 			<textarea rows="7" class="form-control" id=intro name="intro" placeholder="소개글을 입력하세요"></textarea>
				 		</div>
				 	</div>
			 	</div>
			 	<div class="row">	
				 	<div class="col-md-12">
				 		<div class="form-group">
				 			<label for="index">목차</label>
				 			<textarea class="form-control" id=index name="index" placeholder="목차를 입력하세요"></textarea>
				 		</div>
				 	</div>
			 	</div>
			</form>
		</div>
		<div class="col-md-4 col-xs-12">
			<div>로그인폼</div>
		</div>
	 </div>

</div>
</body>
</html>