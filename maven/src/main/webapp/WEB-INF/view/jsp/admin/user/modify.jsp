<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<jsp:include page="/WEB-INF/view/jsp/admin/fragment/head.jsp" />
<body>
<jsp:include page="/WEB-INF/view/jsp/admin/fragment/navbar.jsp" />

<div class="container">
	<div class="page-header">
		<h1><b>USER MODIFY</b></h1>
	</div>
	<ol class="breadcrumb">
		<li><a href="<c:url value='/a/home' />">HOME</a></li>
		<li>USER</li>
		<li class="active">USER MODIFY</li>
	</ol>
	<div>

<form action="<c:url value='${ baseUrl }/${ domain.userId }' />" method="post" class="form-horizontal">
	<input type="hidden" name="currentPage" value="<c:out value='${ pageParam.currentPage }' />">
	<input type="hidden" name="viewRecord" value="<c:out value='${ pageParam.viewRecord }' />">
	<input type="hidden" name="searchOption" value="<c:out value='${ searchParam.searchOption }' />">
	<input type="hidden" name="searchValue" value="<c:out value='${ searchParam.searchValue }' />">
	<div class="form-group">
		<label for="name" class="col-sm-2 control-label">NAME</label>
		<div class="col-sm-10">
			<input type="text" name="name" value="<c:out value='${ domain.name }' />" id="name" placeholder="NAME" maxlength="30" class="form-control" required>
		</div>
	</div>
	<div class="form-group">
		<label for="password" class="col-sm-2 control-label">PASSWORD</label>
		<div class="col-sm-10">
			<input type="password" name="password" value="<c:out value='${ domain.password }' />" id="password" placeholder="PASSWORD" maxlength="100" class="form-control" required>
		</div>
	</div>
	<div class="form-group">
		<label for="mail" class="col-sm-2 control-label">eMAIL</label>
		<div class="col-sm-10">
			<input type="email" name="mail" value="<c:out value='${ domain.mail }' />" id="mail" placeholder="eMAIL" maxlength="255" class="form-control">
		</div>
	</div>
	<div class="form-group">
		<label for="phone" class="col-sm-2 control-label">PHONE</label>
		<div class="col-sm-10">
			<input type="tel" name="phone" value="<c:out value='${ domain.phone }' />" id="phone" placeholder="PHONE" maxlength="30" class="form-control">
		</div>
	</div>
	<div class="form-group">
		<label for="photo" class="col-sm-2 control-label">PHOTO</label>
		<div class="col-sm-10">
			<input type="text" name="photo" value="<c:out value='${ domain.photo }' />" id="photo" placeholder="PHOTO" maxlength="255" class="form-control">
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
