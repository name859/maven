<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<jsp:include page="/WEB-INF/view/jsp/admin/fragment/head.jsp" />
<body>
<jsp:include page="/WEB-INF/view/jsp/admin/fragment/navbar.jsp" />

<div class="container">
	<div class="page-header">
		<h1><b>USER ADD</b></h1>
	</div>
	<ol class="breadcrumb">
		<li><a href="<c:url value='/a/home' />">HOME</a></li>
		<li>USER</li>
		<li class="active">USER ADD</li>
	</ol>
	<div>

<form action="<c:url value='${ baseUrl }' />" method="post" class="form-horizontal">
	<div class="form-group">
		<label for="name" class="col-sm-2 control-label">NAME</label>
		<div class="col-sm-10">
			<input type="text" name="name" id="name" placeholder="NAME" maxlength="30" class="form-control" required autofocus>
		</div>
	</div>
	<div class="form-group">
		<label for="password" class="col-sm-2 control-label">PASSWORD</label>
		<div class="col-sm-10">
			<input type="password" name="password" id="password" placeholder="PASSWORD" maxlength="100" class="form-control" required>
		</div>
	</div>
	<div class="form-group">
		<label for="mail" class="col-sm-2 control-label">eMAIL</label>
		<div class="col-sm-10">
			<input type="email" name="mail" id="mail" placeholder="eMAIL" maxlength="255" class="form-control">
		</div>
	</div>
	<div class="form-group">
		<label for="phone" class="col-sm-2 control-label">PHONE</label>
		<div class="col-sm-10">
			<input type="tel" name="phone" id="phone" placeholder="PHONE" maxlength="30" class="form-control">
		</div>
	</div>
	<div class="form-group">
		<label for="photo" class="col-sm-2 control-label">PHOTO</label>
		<div class="col-sm-10">
			<input type="text" name="photo" id="photo" placeholder="PHOTO" maxlength="255" class="form-control">
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
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-default btn-lg"><font color="royalblue">&nbsp;ADD&nbsp;</font></button>&nbsp;
			<button type="reset" class="btn btn-default btn-lg">RESET</button>
		</div>
	</div>
</form>

	</div>
</div>

<%@ include file="/WEB-INF/view/jsp/admin/fragment/footer.html" %>
<%@ include file="/WEB-INF/view/jsp/admin/fragment/js.jsp" %>
</body>
</html>
