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
		<h1><b>CATEGORY READ</b></h1>
	</div>
	<ol class="breadcrumb">
		<li><a href="<c:url value='/a/home' />">HOME</a></li>
		<li>CATEGORY</li>
		<li class="active">CATEGORY READ</li>
	</ol>
	<div>

<form class="form-horizontal">
	<fieldset disabled>
		<div class="form-group">
			<label for="categoryId" class="col-sm-2 control-label">ID</label>
			<div class="col-sm-10">
				<input type="text" name="categoryId" value="<c:out value='${ domain.categoryId }' />" id="categoryId" placeholder="ID" class="form-control" required>
			</div>
		</div>
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
			<label for="groupId" class="col-sm-2 control-label">GROUP ID</label>
			<div class="col-sm-10">
				<input type="text" name="groupId" value="<c:out value='${ domain.groupId }' />" id="groupId" placeholder="GROUP ID" class="form-control" required>
			</div>
		</div>
		<div class="form-group">
			<label for="referenceId" class="col-sm-2 control-label">REFERENCE ID</label>
			<div class="col-sm-10">
				<input type="text" name="referenceId" value="<c:out value='${ domain.referenceId }' />" id="referenceId" placeholder="REFERENCE ID" class="form-control" required>
			</div>
		</div>
		<div class="form-group">
			<label for="sequence" class="col-sm-2 control-label">SEQUENCE</label>
			<div class="col-sm-10">
				<input type="text" name="sequence" value="<c:out value='${ domain.sequence }' />" id="sequence" placeholder="SEQUENCE" class="form-control" required>
			</div>
		</div>
		<div class="form-group">
			<label for="level" class="col-sm-2 control-label">LEVEL</label>
			<div class="col-sm-10">
				<input type="text" name="level" value="<c:out value='${ domain.level }' />" id="level" placeholder="LEVEL" class="form-control" required>
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
			<label for="user.userId" class="col-sm-2 control-label">USER</label>
			<div class="col-sm-6">
				<input type="text" name="user.userId" value="<c:out value='${ domain.user.name }' />" id="user.userId" placeholder="USER" class="form-control" required>
			</div>
		</div>
	</fieldset>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<a href="<c:url value='${ baseUrl }/user/${ domain.user.userId }' />" class="btn btn-default btn-lg">&nbsp;LIST&nbsp;</a>&nbsp;
			<a href="<c:url value='${ baseUrl }/${ domain.categoryId }/fm' />" class="btn btn-default btn-lg"><font color="royalblue">MODIFY</font></a>&nbsp;
			<a href="<c:url value='${ baseUrl }/${ domain.categoryId }/del' />" class="btn btn-default btn-lg"><font color="tomato">DELETE</font></a>
		</div>
	</div>
</form>

	</div>
</div>

<%@ include file="/WEB-INF/view/jsp/admin/fragment/footer.html" %>
<%@ include file="/WEB-INF/view/jsp/admin/fragment/js.jsp" %>
</body>
</html>
