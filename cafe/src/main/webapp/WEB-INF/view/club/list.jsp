<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<c:url value="/static/js/jquery-3.1.1.min.js"/>"></script>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/static/css/common.css"/>"/>
</head>
<body>

	<div id="menu">
		<jsp:include page="/WEB-INF/view/club/common/menu.jsp"/>
	</div>
	<div id="list">
		<h1>
			<c:forEach items="${curruntMenu}" var="currentMenuItem" varStatus="index">
				<!-- curruntMenu List 이므로 List함수를 그대로 쓸수 있음 -->
				<%-- ${curruntMenu.size()} / ${index.index + 1 } --%>
				${currentMenuItem.menuName} <c:if test="${!index.last}"> > </c:if>
				
				<%-- <c:if test="${curruntMenu.size() != index.index + 1 }"> > </c:if> --%> 
			</c:forEach>
		</h1>
		<table>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
			
			<c:if test="${empty clubList}">
				<tr>
					<td colspan="5">등록된 게시글이 존재하지 않습니다.</td>
				</tr>
			</c:if>
			<c:forEach items="${clubList}" var="club">
				<tr>
					<td>${club.articleId }</td>
					<td>
						<a href="<c:url value="/club/read/${club.menuVO.menuId}/${club.articleId}"/>">${club.subject }</a>
						(${club.repliesCount})
					</td>
					<td>${club.memberVO.nickName }</td>
					<td>${club.createdDate}</td>
					<td>${club.readCount }</td>
				</tr>
			</c:forEach>
			
		</table>
		<form id="searchForm">
			${pager}<br/><br/>
			<select id="searchType">
				<option value="1">주제/내용</option>
				<option value="2">주제</option>
				<option value="3">내용</option>
			</select>
			<input type="text" name="keyword" value="${sessionScope._SEARCH_.keyword}"/>
			<input type="button" value="Search" onclick="movePage(0)"/><br/>
			<input type="button" value="검색 초기화" onclick="location.href='<c:url value="/club/${menuId}/init"/>';"/>
		</form><br/>
		<a href="<c:url value="/club/write/${menuId}"/>">글쓰기</a>
	</div>
		
		<br/>
		<br/>
		<br/>
		<br/>
		<br/>
		<br/>
		<br/>
		
		<!-- 채팅장 연동하기 start -->
		<%--  분산환경 test로 잠시 막음
		<div style=" padding-left:350px; text-align: right; width: 200px">
			<c:import url="http://localhost:3000"/>
		</div>
		 --%>
		<script type="text/javascript">
			$().ready(function(){
				 newPostUrl = "https://www.naver.com";				
				 $('#hiddenButton').click();
			});
		</script>
		<!-- 채팅장 연동하기 end -->
</body>
</html>