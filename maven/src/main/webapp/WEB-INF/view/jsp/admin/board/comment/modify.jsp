<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<jsp:include page="/WEB-INF/view/jsp/admin/fragment/head.jsp" />
<body>
<jsp:include page="/WEB-INF/view/jsp/admin/fragment/navbar.jsp" />

<div class="container">
	<div class="page-header">
		<h1><b>COMMENT MODIFY</b></h1>
	</div>
	<ol class="breadcrumb">
		<li><a href="<c:url value='/a/home' />">HOME</a></li>
		<li>COMMENT</li>
		<li class="active">COMMENT MODIFY</li>
	</ol>
	<div>

<form action="<c:url value='${ baseUrl }/${ domain.commentId }' />" method="post" class="form-horizontal">
	<input type="hidden" name="currentPage" value="<c:out value='${ pageParam.currentPage }' />">
	<input type="hidden" name="viewRecord" value="<c:out value='${ pageParam.viewRecord }' />">
	<input type="hidden" name="searchOption" value="<c:out value='${ searchParam.searchOption }' />">
	<input type="hidden" name="searchValue" value="<c:out value='${ searchParam.searchValue }' />">
	<div class="form-group">
		<label for="comment" class="col-sm-2 control-label">COMMENT</label>
		<div class="col-sm-10">
			<textarea name="comment" id="comment" placeholder="COMMENT" rows="5" style="resize:none;" class="form-control" required><c:out value='${ domain.comment }' /></textarea>
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
		<label for="board.boardId" class="col-sm-2 control-label">BOARD</label>
		<div class="col-sm-6">
			<select name="board.boardId" id="board.boardId" class="form-control" required>
				<option value="">BOARD</option>
				<c:forEach var="board" items="${ boardList }">
					<option value="<c:out value='${ board.boardId }' />"><c:out value='${ board.boardId }' /></option>
				</c:forEach>
			</select>
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
			<button type="submit" class="btn btn-default btn-lg"><font color="royalblue">MODIFY</font></button>&nbsp;
			<button type="reset" class="btn btn-default btn-lg">RESET</button>&nbsp;
			<button type="button" onclick="history.go(-1);" class="btn btn-default btn-lg">CANCEL</button>
		</div>
	</div>
</form>

	</div>
</div>

<%@ include file="/WEB-INF/view/jsp/admin/fragment/footer.html" %>
<%@ include file="/WEB-INF/view/jsp/admin/fragment/js.jsp" %>
<script type="text/javascript">
	$("#board\\.boardId").val("${ domain.board.boardId }");
	$("#user\\.userId").val("${ domain.user.userId }");
</script>
</body>
</html>
