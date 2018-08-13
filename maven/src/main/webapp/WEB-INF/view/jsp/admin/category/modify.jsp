<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<jsp:include page="/WEB-INF/view/jsp/admin/fragment/head.jsp" />
<body>
<jsp:include page="/WEB-INF/view/jsp/admin/fragment/navbar.jsp" />

<div class="container">
	<div class="page-header">
		<h1><b>CATEGORY MODIFY</b></h1>
	</div>
	<ol class="breadcrumb">
		<li><a href="<c:url value='/a/home' />">HOME</a></li>
		<li>CATEGORY</li>
		<li class="active">CATEGORY MODIFY</li>
	</ol>
	<div>

<form action="<c:url value='${ baseUrl }/${ domain.categoryId }' />" method="post" class="form-horizontal">
	<input type="hidden" name="groupId" value="<c:out value='${ domain.groupId }' />">
	<input type="hidden" name="referenceId" value="<c:out value='${ domain.referenceId }' />">
	<input type="hidden" name="sequence" value="<c:out value='${ domain.sequence }' />">
	<input type="hidden" name="level" value="<c:out value='${ domain.level }' />">
	<input type="hidden" name="user.userId" value="<c:out value='${ domain.user.userId }' />">
	<div class="form-group">
		<label for="name" class="col-sm-2 control-label">NAME</label>
		<div class="col-sm-10">
			<input type="text" name="name" value="<c:out value='${ domain.name }' />" id="name" placeholder="NAME" maxlength="100" class="form-control" required>
		</div>
	</div>
	<div class="form-group">
		<label for="note" class="col-sm-2 control-label">NOTE</label>
		<div class="col-sm-10">
			<textarea name="note" id="note" placeholder="NOTE" rows="2" style="resize:none;" class="form-control"><c:out value='${ domain.note }' /></textarea>
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
</body>
</html>
