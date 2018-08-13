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
		<h1><b>COMMENT READ</b></h1>
	</div>
	<ol class="breadcrumb">
		<li><a href="<c:url value='/a/home' />">HOME</a></li>
		<li>COMMENT</li>
		<li class="active">COMMENT READ</li>
	</ol>
	<div>

<form class="form-horizontal">
	<fieldset disabled>
		<div class="form-group">
			<label for="commentId" class="col-sm-2 control-label">ID</label>
			<div class="col-sm-10">
				<input type="text" name="commentId" value="<c:out value='${ domain.commentId }' />" id="commentId" placeholder="ID" class="form-control" required>
			</div>
		</div>
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
			<label for="board.boardId" class="col-sm-2 control-label">BOARD</label>
			<div class="col-sm-6">
				<select name="board.boardId" id="board.boardId" class="form-control" required>
					<option value="<c:out value='${ domain.board.boardId }' />"><c:out value='${ domain.board.boardId }' /></option>
				</select>
			</div>
		</div>
		<div class="form-group">
			<label for="user.userId" class="col-sm-2 control-label">USER</label>
			<div class="col-sm-6">
				<select name="user.userId" id="user.userId" class="form-control" required>
					<option value="<c:out value='${ domain.user.userId }' />"><c:out value='${ domain.user.name }' /></option>
				</select>
			</div>
		</div>
	</fieldset>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<a href="<c:url value='${ baseUrl }?${ parameter }' />" class="btn btn-default btn-lg">&nbsp;LIST&nbsp;</a>&nbsp;
			<a href="<c:url value='${ baseUrl }/${ domain.commentId }/fm?${ parameter }' />" class="btn btn-default btn-lg"><font color="royalblue">MODIFY</font></a>&nbsp;
			<a href="<c:url value='${ baseUrl }/${ domain.commentId }/del?${ parameter }' />" class="btn btn-default btn-lg"><font color="tomato">DELETE</font></a>
		</div>
	</div>
</form>

	</div>
</div>

<%@ include file="/WEB-INF/view/jsp/admin/fragment/footer.html" %>
<%@ include file="/WEB-INF/view/jsp/admin/fragment/js.jsp" %>
</body>
</html>
