<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<jsp:include page="/WEB-INF/view/jsp/admin/fragment/head.jsp" />
<body>
<jsp:include page="/WEB-INF/view/jsp/admin/fragment/navbar.jsp" />

<div class="container">
	<div class="page-header">
		<h1><b>BOARD MODIFY</b></h1>
	</div>
	<ol class="breadcrumb">
		<li><a href="<c:url value='/a/home' />">HOME</a></li>
		<li>BOARD</li>
		<li class="active">BOARD MODIFY</li>
	</ol>
	<div>

<form action="<c:url value='${ baseUrl }/${ domain.boardId }' />" method="post" class="form-horizontal">
	<input type="hidden" name="currentPage" value="<c:out value='${ pageParam.currentPage }' />">
	<input type="hidden" name="viewRecord" value="<c:out value='${ pageParam.viewRecord }' />">
	<input type="hidden" name="searchOption" value="<c:out value='${ searchParam.searchOption }' />">
	<input type="hidden" name="searchValue" value="<c:out value='${ searchParam.searchValue }' />">
	<input type="hidden" name="user.userId" value="<c:out value='${ domain.user.userId }' />" id="user.userId">
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
		<label for="user.name" class="col-sm-2 control-label">USER</label>
		<div class="col-sm-6">
			<div class="input-group">
				<input type="text" value="<c:out value='${ domain.user.name }' />" id="user.name" placeholder="USER" class="form-control" required disabled>
				<span class="input-group-btn">
					<a id="user.name" class="btn btn-default">CHOICE</a>
				</span>
			</div>
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
	$("#user\\.name").on("click", function() {
		window.open("<c:url value='/a/user/choice' />", "choice", "width=800, height=835, location=no, menubar=no, titlebar=no, toolbar=no, resizable=no, scrollbars=no");
	});
</script>
</body>
</html>
