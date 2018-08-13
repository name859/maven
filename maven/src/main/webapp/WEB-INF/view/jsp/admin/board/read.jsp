<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
<jsp:include page="/WEB-INF/view/jsp/admin/fragment/head.jsp" />
<body>
<jsp:include page="/WEB-INF/view/jsp/admin/fragment/navbar.jsp" />

<div class="container">
	<div class="page-header">
		<h1><b>BOARD READ</b></h1>
	</div>
	<ol class="breadcrumb">
		<li><a href="<c:url value='/a/home' />">HOME</a></li>
		<li>BOARD</li>
		<li class="active">BOARD READ</li>
	</ol>
	<div>

<form class="form-horizontal">
	<fieldset disabled>
		<div class="form-group">
			<label for="boardId" class="col-sm-2 control-label">ID</label>
			<div class="col-sm-10">
				<input type="text" name="boardId" value="<c:out value='${ domain.boardId }' />" id="boardId" placeholder="ID" class="form-control" required>
			</div>
		</div>
		<div class="form-group">
			<label for="subject" class="col-sm-2 control-label">SUBJECT</label>
			<div class="col-sm-10">
				<input type="text" name="subject" value="<c:out value='${ domain.subject }' />" id="subject" placeholder="SUBJECT" maxlength="1000" class="form-control" required>
			</div>
		</div>
		<div class="form-group">
			<label for="content" class="col-sm-2 control-label">CONTENT</label>
			<div class="col-sm-10">
				<textarea name="content" id="content" placeholder="CONTENT" rows="10" style="resize:none;" class="form-control" required><c:out value='${ domain.content }' /></textarea>
			</div>
		</div>
		<div class="form-group">
			<label for="vital" class="col-sm-2 control-label">VITAL</label>
			<div class="col-sm-10">
				<label class="radio-inline">
					<c:if test="${ domain.vital eq 'Y' }">
						<input type="radio" name="vital" value="Y" id="vital" checked> Y
					</c:if>
					<c:if test="${ domain.vital ne 'Y' }">
						<input type="radio" name="vital" value="Y" id="vital"> Y
					</c:if>
				</label>
				<label class="radio-inline">
					<c:if test="${ domain.vital eq 'N' }">
						<input type="radio" name="vital" value="N" id="vital" checked> N
					</c:if>
					<c:if test="${ domain.vital ne 'N' }">
						<input type="radio" name="vital" value="N" id="vital"> N
					</c:if>
				</label>
			</div>
		</div>
		<div class="form-group">
			<label for="addTime" class="col-sm-2 control-label">ADD TIME</label>
			<div class="col-sm-10">
				<input type="text" name="addTime" value="<fmt:formatDate value='${ domain.addTime }' pattern='yyyy-MM-dd HH:mm:ss' />" id="addTime" placeholder="ADD TIME" class="form-control" required>
			</div>
		</div>
		<div class="form-group">
			<label for="modifyTime" class="col-sm-2 control-label">MODIFY TIME</label>
			<div class="col-sm-10">
				<input type="text" name="modifyTime" value="<fmt:formatDate value='${ domain.modifyTime }' pattern='yyyy-MM-dd HH:mm:ss' />" id="modifyTime" placeholder="MODIFY TIME" class="form-control" required>
			</div>
		</div>
		<div class="form-group">
			<label for="user.name" class="col-sm-2 control-label">USER</label>
			<div class="col-sm-6">
				<div class="input-group">
					<input type="text" value="<c:out value='${ domain.user.name }' />" id="user.name" placeholder="USER" class="form-control" required>
					<span class="input-group-btn">
						<a id="user.name" class="btn btn-default">CHOICE</a>
					</span>
				</div>
			</div>
		</div>
	</fieldset>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<a href="<c:url value='${ baseUrl }?${ parameter }' />" class="btn btn-default btn-lg">&nbsp;LIST&nbsp;</a>&nbsp;
			<a href="<c:url value='${ baseUrl }/${ domain.boardId }/fm?${ parameter }' />" class="btn btn-default btn-lg"><font color="royalblue">MODIFY</font></a>&nbsp;
			<a href="<c:url value='${ baseUrl }/${ domain.boardId }/del?${ parameter }' />" class="btn btn-default btn-lg"><font color="tomato">DELETE</font></a>
		</div>
	</div>
	<div class="form-group">
		<label for="nice" class="col-sm-2 text-right">NICE</label>
		<div class="col-sm-10 text-nowrap">
			<a href="" onclick="window.open('<c:url value='/a/board/nice?searchOption=1&searchValue=${ domain.boardId }' />', 'nice_list', 'width=800, height=800, location=no, menubar=no, titlebar=no, toolbar=no, resizable=no, scrollbars=no');"><c:out value='${ domain.boardNiceList.size() }' /></a> ( Y :
			<a href="" onclick="window.open('<c:url value='/a/board/nice?searchOption=2&searchValue=${ domain.boardId }&searchValue=Y' />', 'nice_list', 'width=800, height=800, location=no, menubar=no, titlebar=no, toolbar=no, resizable=no, scrollbars=no');"><c:out value='${ domain.boardNiceList.stream().filter(boardNice -> boardNice.getVital().equals("Y")).count() }' /></a> , N :
			<a href="" onclick="window.open('<c:url value='/a/board/nice?searchOption=2&searchValue=${ domain.boardId }&searchValue=N' />', 'nice_list', 'width=800, height=800, location=no, menubar=no, titlebar=no, toolbar=no, resizable=no, scrollbars=no');"><c:out value='${ domain.boardNiceList.stream().filter(boardNice -> boardNice.getVital().equals("N")).count() }' /></a> )
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-6">
			<div class="input-group">
				<input type="text" id="user.name" placeholder="USER" class="form-control" required>
				<span class="input-group-btn">
					<a id="user.name" class="btn btn-default">CHOICE</a>
				</span>
			</div>
		</div>
		<a onclick="nice();" class="btn btn-default"><font color="royalblue">NICE</font></a>
	</div>
</form>

<div>&nbsp;</div>
<div class="panel panel-default">
	<div class="panel-heading">
		<b>COMMENT LIST</b>
	</div>
	<table class="table table-condensed">
		<thead>
			<tr>
				<th class="text-center">ID</th>
				<th class="text-center">COMMENT</th>
				<th class="text-center">VITAL</th>
				<th class="text-center">ADD DATE</th>
				<th class="text-center">MODIFY DATE</th>
				<th class="text-center">BOARD</th>
				<th class="text-center">USER</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="comment" items="${ domain.commentList }">
				<tr>
					<td class="text-center"><c:out value='${ comment.commentId }' /></td>
					<td class="text-center"><a href="<c:url value='/a/comment/${ comment.commentId }?${ parameter }' />"><c:out value='${ comment.comment }' /></a></td>
					<td class="text-center">
						<c:if test="${ comment.vital == 'Y' }"><c:out value='${ comment.vital }' /></c:if>
						<c:if test="${ comment.vital == 'N' }"><font color="tomato"><c:out value='${ comment.vital }' /></font></c:if>
					</td>
					<td class="text-center"><fmt:formatDate value='${ comment.addTime }' pattern='yyyy-MM-dd' /></td>
					<td class="text-center"><fmt:formatDate value='${ comment.modifyTime }' pattern='yyyy-MM-dd' /></td>
					<td class="text-center"><c:out value='${ comment.board.boardId }' /></td>
					<td class="text-center"><c:out value='${ comment.user.name }' /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<div>&nbsp;</div>
<ol class="breadcrumb">
	<li><b>COMMENT ADD</b></li>
</ol>
<form action="<c:url value='/a/comment' />" method="post" class="form-horizontal">
	<input type="hidden" name="board.boardId" value="<c:out value='${ domain.boardId }' />">
	<div class="form-group">
		<label for="comment" class="col-sm-2 control-label">COMMENT</label>
		<div class="col-sm-10">
			<textarea name="comment" id="comment" placeholder="COMMENT" rows="5" style="resize:none;" class="form-control" required></textarea>
		</div>
	</div>
	<div class="form-group">
		<label for="vital" class="col-sm-2 control-label">VITAL</label>
		<div class="col-sm-10">
			<label class="radio-inline">
				<input type="radio" name="vital" value="Y" id="vital" checked> Y
			</label>
			<label class="radio-inline">
				<input type="radio" name="vital" value="N" id="vital"> N
			</label>
		</div>
	</div>
	<div class="form-group">
		<label for="user.userId" class="col-sm-2 control-label">USER</label>
		<div class="col-sm-6">
			<select name="user.userId" id="user.userId" class="form-control" required>
				<option value="">USER</option>
				<c:forEach var="user" items="${ userList }">
					<option value="<c:out value='${ user.userId }' />"><c:out value='${ user.name }' /></option>
				</c:forEach>
			</select>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-default btn-lg"><font color="royalblue">&nbsp;ADD&nbsp;</font></button>&nbsp;
			<button type="reset" class="btn btn-default btn-lg">RESET</button>
		</div>
	</div>
</form>

<form action="<c:url value='/a/board/nice' />" name="boardNice" method="post">
	<input type="hidden" name="vital" value="Y">
	<input type="hidden" name="board.boardId" value="<c:out value='${ domain.boardId }' />">
	<input type="hidden" name="user.userId" id="user.userId">
</form>

	</div>
</div>

<%@ include file="/WEB-INF/view/jsp/admin/fragment/footer.html" %>
<%@ include file="/WEB-INF/view/jsp/admin/fragment/js.jsp" %>
<script type="text/javascript">
	$("#user\\.name").on("click", function() {
		window.open("<c:url value='/a/user/choice' />", "choice", "width=800, height=835, location=no, menubar=no, titlebar=no, toolbar=no, resizable=no, scrollbars=no");
	});
	
	function nice() {
		if (document.getElementById("user.name").value.length > 0) {
			window.open("", "nice", "width=500, height=500, location=no, menubar=no, titlebar=no, toolbar=no, resizable=no, scrollbars=no");
			document.boardNice.target = "nice";
			document.boardNice.submit();
		} else {
			alert("CHOICE USER!");
			document.getElementById("user.name").click();
		}
	}
</script>
</body>
</html>
