<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<jsp:include page="/WEB-INF/view/jsp/admin/fragment/head.jsp" />
<body>
<jsp:include page="/WEB-INF/view/jsp/admin/fragment/navbar.jsp" />

<div class="container">
	<div class="page-header">
		<h1><b>BOARD ADD</b></h1>
	</div>
	<ol class="breadcrumb">
		<li><a href="<c:url value='/a/home' />">HOME</a></li>
		<li>BOARD</li>
		<li class="active">BOARD ADD</li>
	</ol>
	<div>

<form action="<c:url value='${ baseUrl }' />" method="post" class="form-horizontal">
	<input type="hidden" name="user.userId" id="user.userId">
	<div class="form-group">
		<label for="subject" class="col-sm-2 control-label">SUBJECT</label>
		<div class="col-sm-10">
			<input type="text" name="subject" id="subject" placeholder="SUBJECT" maxlength="1000" class="form-control" required autofocus>
		</div>
	</div>
	<div class="form-group">
		<label for="content" class="col-sm-2 control-label">CONTENT</label>
		<div class="col-sm-10">
			<textarea name="content" id="content" placeholder="CONTENT" rows="10" style="resize:none;" class="form-control" required></textarea>
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
		<label for="user.name" class="col-sm-2 control-label">USER</label>
		<div class="col-sm-6">
			<div class="input-group">
				<input type="text" id="user.name" placeholder="USER" class="form-control" required>
				<span class="input-group-btn">
					<a id="user.name" class="btn btn-default">CHOICE</a>
				</span>
			</div>
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
<script type="text/javascript">
	$("#user\\.name").on("click", function() {
		window.open("<c:url value='/a/user/choice' />", "choice", "width=800, height=835, location=no, menubar=no, titlebar=no, toolbar=no, resizable=no, scrollbars=no");
	});
</script>
</body>
</html>
