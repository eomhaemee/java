<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/static/css/common.css"/>"/>

<!-- 붙여넣기 start -->
<link type="text/css" rel="stylesheet" href="<c:url value="/static/js/ckeditor/contents.css?t=H0CG"/>"/>
<link type="text/css" rel="stylesheet" href="<c:url value="/static/js/ckeditor/plugins/copyformatting/styles/copyformatting.css"/>" />
<style>
.cke_editable{cursor:text}.cke_editable img,.cke_editable input,.cke_editable textarea{cursor:default}
img.cke_flash{background-image: url("<c:url value="/static/js/ckeditor/plugins/flash/images/placeholder.png?t=H0CG"/>");background-position: center center;background-repeat: no-repeat;border: 1px solid #a9a9a9;width: 80px;height: 80px;}
.cke_editable form{border: 1px dotted #FF0000;padding: 2px;}

img.cke_hidden{background-image: url("<c:url value="/static/js/ckeditor/plugins/forms/images/hiddenfield.gif?t=H0CG"/>");background-position: center center;background-repeat: no-repeat;border: 1px solid #a9a9a9;width: 16px !important;height: 16px !important;}
img.cke_iframe{background-image: url("<c:url value="/static/js/ckeditor/plugins/iframe/images/placeholder.png?t=H0CG"/>");background-position: center center;background-repeat: no-repeat;border: 1px solid #a9a9a9;width: 80px;height: 80px;}
.cke_contents_ltr a.cke_anchor,.cke_contents_ltr a.cke_anchor_empty,.cke_editable.cke_contents_ltr a[name],.cke_editable.cke_contents_ltr a[data-cke-saved-name]{background:url("<c:url value="/static/js/ckeditor/plugins/link/images/anchor.png?t=H0CG"/>") no-repeat left center;border:1px dotted #00f;background-size:16px;padding-left:18px;cursor:auto;}.cke_contents_ltr img.cke_anchor{background:url("<c:url value="/static/js/ckeditor/plugins/link/images/anchor.png?t=H0CG"/>") no-repeat left center;border:1px dotted #00f;background-size:16px;width:16px;min-height:15px;height:1.15em;vertical-align:text-bottom;}.cke_contents_rtl a.cke_anchor,.cke_contents_rtl a.cke_anchor_empty,.cke_editable.cke_contents_rtl a[name],.cke_editable.cke_contents_rtl a[data-cke-saved-name]{background:url("<c:url value="/static/js/ckeditor/plugins/link/images/anchor.png?t=H0CG"/>") no-repeat right center;border:1px dotted #00f;background-size:16px;padding-right:18px;cursor:auto;}.cke_contents_rtl img.cke_anchor{background:url("<c:url value="/static/js/ckeditor/plugins/link/images/anchor.png?t=H0CG"/>") no-repeat right center;border:1px dotted #00f;background-size:16px;width:16px;min-height:15px;height:1.15em;vertical-align:text-bottom;}
div.cke_pagebreak{background:url("<c:url value="/static/js/ckeditor/plugins/pagebreak/images/pagebreak.gif?t=H0CG"/>") no-repeat center center !important;clear:both !important;width:100% !important;border-top:#999 1px dotted !important;border-bottom:#999 1px dotted !important;padding:0 !important;height:7px !important;cursor:default !important;}
.cke_show_blocks h6:not([contenteditable=false]):not(.cke_show_blocks_off),.cke_show_blocks h5:not([contenteditable=false]):not(.cke_show_blocks_off),.cke_show_blocks h4:not([contenteditable=false]):not(.cke_show_blocks_off),.cke_show_blocks h3:not([contenteditable=false]):not(.cke_show_blocks_off),.cke_show_blocks h2:not([contenteditable=false]):not(.cke_show_blocks_off),.cke_show_blocks h1:not([contenteditable=false]):not(.cke_show_blocks_off),.cke_show_blocks blockquote:not([contenteditable=false]):not(.cke_show_blocks_off),.cke_show_blocks address:not([contenteditable=false]):not(.cke_show_blocks_off),.cke_show_blocks pre:not([contenteditable=false]):not(.cke_show_blocks_off),.cke_show_blocks div:not([contenteditable=false]):not(.cke_show_blocks_off),.cke_show_blocks p:not([contenteditable=false]):not(.cke_show_blocks_off){background-repeat:no-repeat;border:1px dotted gray;padding-top:8px}.cke_show_blocks h6:not([contenteditable=false]):not(.cke_show_blocks_off){background-image:url("<c:url value="/static/js/ckeditor/plugins/showblocks/images/block_h6.png?t=H0CG"/>")}.cke_show_blocks h5:not([contenteditable=false]):not(.cke_show_blocks_off){background-image:url("<c:url value="/static/js/ckeditor/plugins/showblocks/images/block_h5.png?t=H0CG"/>")}.cke_show_blocks h4:not([contenteditable=false]):not(.cke_show_blocks_off){background-image:url("<c:url value="/static/js/ckeditor/plugins/showblocks/images/block_h4.png?t=H0CG"/>")}.cke_show_blocks h3:not([contenteditable=false]):not(.cke_show_blocks_off){background-image:url("<c:url value="/static/js/ckeditor/plugins/showblocks/images/block_h3.png?t=H0CG"/>")}.cke_show_blocks h2:not([contenteditable=false]):not(.cke_show_blocks_off){background-image:url("<c:url value="/static/js/ckeditor/plugins/showblocks/images/block_h2.png?t=H0CG"/>")}.cke_show_blocks h1:not([contenteditable=false]):not(.cke_show_blocks_off){background-image:url("<c:url value="/static/js/ckeditor/plugins/showblocks/images/block_h1.png?t=H0CG"/>")}.cke_show_blocks blockquote:not([contenteditable=false]):not(.cke_show_blocks_off){background-image:url("<c:url value="/static/js/ckeditor/plugins/showblocks/images/block_blockquote.png?t=H0CG"/>")}.cke_show_blocks address:not([contenteditable=false]):not(.cke_show_blocks_off){background-image:url("<c:url value="/static/js/ckeditor/plugins/showblocks/images/block_address.png?t=H0CG"/>")}.cke_show_blocks pre:not([contenteditable=false]):not(.cke_show_blocks_off){background-image:url("<c:url value="/static/js/ckeditor/plugins/showblocks/images/block_pre.png?t=H0CG"/>")}.cke_show_blocks div:not([contenteditable=false]):not(.cke_show_blocks_off){background-image:url("<c:url value="/static/js/ckeditor/plugins/showblocks/images/block_div.png?t=H0CG"/>")}.cke_show_blocks p:not([contenteditable=false]):not(.cke_show_blocks_off){background-image:url("<c:url value="/static/js/ckeditor/plugins/showblocks/images/block_p.png?t=H0CG"/>")}.cke_show_blocks.cke_contents_ltr h6:not([contenteditable=false]):not(.cke_show_blocks_off),.cke_show_blocks.cke_contents_ltr h5:not([contenteditable=false]):not(.cke_show_blocks_off),.cke_show_blocks.cke_contents_ltr h4:not([contenteditable=false]):not(.cke_show_blocks_off),.cke_show_blocks.cke_contents_ltr h3:not([contenteditable=false]):not(.cke_show_blocks_off),.cke_show_blocks.cke_contents_ltr h2:not([contenteditable=false]):not(.cke_show_blocks_off),.cke_show_blocks.cke_contents_ltr h1:not([contenteditable=false]):not(.cke_show_blocks_off),.cke_show_blocks.cke_contents_ltr blockquote:not([contenteditable=false]):not(.cke_show_blocks_off),.cke_show_blocks.cke_contents_ltr address:not([contenteditable=false]):not(.cke_show_blocks_off),.cke_show_blocks.cke_contents_ltr pre:not([contenteditable=false]):not(.cke_show_blocks_off),.cke_show_blocks.cke_contents_ltr div:not([contenteditable=false]):not(.cke_show_blocks_off),.cke_show_blocks.cke_contents_ltr p:not([contenteditable=false]):not(.cke_show_blocks_off){background-position:top left;padding-left:8px}.cke_show_blocks.cke_contents_rtl h6:not([contenteditable=false]):not(.cke_show_blocks_off),.cke_show_blocks.cke_contents_rtl h5:not([contenteditable=false]):not(.cke_show_blocks_off),.cke_show_blocks.cke_contents_rtl h4:not([contenteditable=false]):not(.cke_show_blocks_off),.cke_show_blocks.cke_contents_rtl h3:not([contenteditable=false]):not(.cke_show_blocks_off),.cke_show_blocks.cke_contents_rtl h2:not([contenteditable=false]):not(.cke_show_blocks_off),.cke_show_blocks.cke_contents_rtl h1:not([contenteditable=false]):not(.cke_show_blocks_off),.cke_show_blocks.cke_contents_rtl blockquote:not([contenteditable=false]):not(.cke_show_blocks_off),.cke_show_blocks.cke_contents_rtl address:not([contenteditable=false]):not(.cke_show_blocks_off),.cke_show_blocks.cke_contents_rtl pre:not([contenteditable=false]):not(.cke_show_blocks_off),.cke_show_blocks.cke_contents_rtl div:not([contenteditable=false]):not(.cke_show_blocks_off),.cke_show_blocks.cke_contents_rtl p:not([contenteditable=false]):not(.cke_show_blocks_off){background-position:top right;padding-right:8px}
.cke_show_borders  table.cke_show_border,.cke_show_borders  table.cke_show_border > tr > td, .cke_show_borders  table.cke_show_border > tr > th,.cke_show_borders  table.cke_show_border > tbody > tr > td, .cke_show_borders  table.cke_show_border > tbody > tr > th,.cke_show_borders  table.cke_show_border > thead > tr > td, .cke_show_borders  table.cke_show_border > thead > tr > th,.cke_show_borders  table.cke_show_border > tfoot > tr > td, .cke_show_borders  table.cke_show_border > tfoot > tr > th{border : #d3d3d3 1px dotted}
</style>

<script type="text/javascript" src="<c:url value="/static/js/jquery-3.1.1.min.js"/>"></script>
<script type="text/javascript">
$().ready(function(){

	//등록
	$("#writeReplyBtn").click(function(){
		$.post("<c:url value="/club/reply/write"/>",{
			'articleId' : $("#articleId").val(),
			'parentReplyId' : $("#parentReplyId").val(),
			'content' : $("#content").val()
		},function(response){
			if (response == 'OK') {
				location.reload();
			} else {
				alert("댓글 등록을 실패 했습니다.\n관리자에게 문의하세요");
			}
		});	
		


});	 
	 
/* 	//대댓글
	$(".formAppender").on("click","#writeReplyBtn",function(){
		
		//validation check
		var thisForm = $(this).parent().parent();
		
		if ( thisForm.find("textarea").val() == ""){
				alert("대댓글 내용을 입력하지 않았습니다.");
				thisForm.find("textarea").focus();
				return;
		} 
		
		if($("#replyDiv").data("user") ==  ""){
				alert("로그인 후 사용할수 있습니다.");
				$("#comment").focus();
				return;
	    } 
		$.post("/SourceMeister/reply/write",{
			'openSourceId' : thisForm.find('#openSourceId').val(),
			'parentReplyId' : thisForm.find('#parentReplyId').val(),
			'comment' : thisForm.find('#comment').val()
		}, function(response){

			if (response == 'OK') {
				$("#replyMain").load("/SourceMeister/reply/list?opensourceId="+ $("#openSourceId").val());
			} else {
				alert("대댓글 등록을 실패 했습니다.\n관리자에게 문의하세요");
			}
		}); 
	
	});
	
	$(".ReReply").click(function(){
		var replyId = $(this).data("replyid");	
		var form = $("#formWrapper").html();
		var thisDiv = $(this).closest(".reply").children("div");
		
		thisDiv.children("form").remove();	
		thisDiv.append(form);
		thisDiv.children("form").find("input[id=parentReplyId]").val(replyId);
		thisDiv.children("form").attr({id:"writeReReply"});
		thisDiv.children("form").attr({class:"writeReReplyForm"});
		thisDiv.children("form").attr({style:"padding-left: 40px; text-align: left;"});
		thisDiv.toggle();
	 	
		$(".reply").each(function (index, data) {
			
			if( $(this).data("parent") == replyId ) {
				$(this).toggle();
				//대댓글에는 글 등록 불가
				$(this).find("td[class=ReReply]").remove();
			}
		}); 
	}); */
});
</script>

</head>
<body class="cke_contents_ltr cke_show_borders">
<!-- 붙여넣기 END -->

	<div id="menu">
		<jsp:include page="/WEB-INF/view/club/common/menu.jsp"/>
	</div>
	<div id="detail">
		<h1>
			<c:forEach items="${curruntMenu}" var="currentMenuItem" varStatus="index">
				<!-- curruntMenu List 이므로 List함수를 그대로 쓸수 있음 -->
				<%-- ${curruntMenu.size()} / ${index.index + 1 } --%>
				${currentMenuItem.menuName} <c:if test="${!index.last}"> > </c:if>
				
				<%-- <c:if test="${curruntMenu.size() != index.index + 1 }"> > </c:if> --%> 
			</c:forEach>
		</h1>
		<span style="background-color: aqua;">${clubVO.subject}</span>
		<span>${clubVO.content}</span>
		
		<hr/>
		<!-- depth 변수 선언: 닫히지 않은 ul갯수 세기 ul이 열릴때 증가시키고, 닫히면 뺴자
		     즉, depth = 0 이면 닫히지 않은 tag가 없다-->
		<c:set var="depth" value="0"/>
			<ul>
			<c:forEach items="${clubVO.replyVO}" var="reply">
				<c:if test="${reply.level < prevLevel}">
					<c:forEach var="i" begin="0" end="${(prevLevel - reply.level) -1 }" step ="1">
						<c:set var="depth" value="${depth - 1}"/>
						</ul>
					</c:forEach>
				</c:if>
				<c:if test="${reply.level > prevLevel}">
					<c:set var="depth" value="${depth + 1}"/>
					<ul>
				</c:if>
				<li >${reply.content} <p class="ReReply" style="cursor: pointer; color: red;" data-replyid="${reply.replyId }">답글</p></li>
				<c:set var="prevLevel" value="${reply.level}"/>
			</c:forEach>
			</ul>
			<!-- 댓글 안쪽의 ul을 닫기 위한 코드 안적어주면 아래 목록 보기가 ul에 포함되어 버림
			      위에서 열리기만 했던 ul을 닫아준다  -->
			<c:if test="${depth > 0 }">
				<c:forEach var="i" begin="0" end="${depth}" step="1">
				</ul>
				</c:forEach>
			</c:if>
			
		<div id="formWrapper" >
			<form class="writeReplyForm" >
				<input type="hidden" id="articleId" name="articleId" value="${clubVO.articleId}" /> 
				<input type="hidden" id="parentReplyId" name="parentReplyId" value="" />
				<textarea id="content" name="content" style="resize:none; width: 500px; text-align: left;"></textarea>
				<input type="button" id="writeReplyBtn" value="등록"  style="position: relative; top: -15px;"/>
			</form>
		</div>	
		<br/>
	
		<a href="<c:url value="/club/${menuId}"/>">목록보기</a><br/><br/><br/>

	<%-- 	댓글	<br/><br/>
		<c:forEach items="${replyList}" var="reply">
			<div  style="margin-left: ${reply.level  * 20 }px; ">
				<span>${reply.content}</span>
				<span>${reply.createdDate}</span>
			</div>
			<br/>
		</c:forEach>
	 --%>
	 
	 <!-- 채팅장 연동하기 start -->
	<%--  분산환경 test로 잠시 막음
		<div style=" padding-left:350px; text-align: right; width: 200px">
			<c:import url="http://localhost:3000"/>
		</div>
		 --%>
	 <!-- 채팅장 연동하기 end -->	
	</div>
</body>
</html>