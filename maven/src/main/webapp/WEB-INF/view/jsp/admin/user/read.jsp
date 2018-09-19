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
		<h1><b>USER READ</b></h1>
	</div>
	<ol class="breadcrumb">
		<li><a href="<c:url value='/a/home' />">HOME</a></li>
		<li>USER</li>
		<li class="active">USER READ</li>
	</ol>
	<div>

<form class="form-horizontal">
	<fieldset disabled>
		<div class="form-group">
			<label for="userId" class="col-sm-2 control-label">ID</label>
			<div class="col-sm-10">
				<input type="text" name="userId" value="<c:out value='${ domain.userId }' />" id="userId" placeholder="ID" class="form-control" required>
			</div>
		</div>
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
	</fieldset>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<a href="<c:url value='${ baseUrl }?${ parameter }' />" class="btn btn-default btn-lg">&nbsp;LIST&nbsp;</a>&nbsp;
			<a href="<c:url value='${ baseUrl }/${ domain.userId }/fm?${ parameter }' />" class="btn btn-default btn-lg"><font color="royalblue">MODIFY</font></a>&nbsp;
			<a href="<c:url value='${ baseUrl }/${ domain.userId }/del?${ parameter }' />" class="btn btn-default btn-lg"><font color="tomato">DELETE</font></a>
		</div>
	</div>
</form>

<div>&nbsp;</div>
<div class="panel panel-default">
	<div class="panel-heading">
		<b>BOARD LIST</b>
	</div>
	<table class="table table-condensed">
		<thead>
			<tr>
				<th class="text-center">ID</th>
				<th class="text-center">SUBJECT</th>
				<th class="text-center">CONTENT</th>
				<th class="text-center">VITAL</th>
				<th class="text-center">ADD DATE</th>
				<th class="text-center">MODIFY DATE</th>
				<th class="text-center">USER</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="board" items="${ domain.boardList }">
				<tr>
					<td class="text-center"><c:out value='${ board.boardId }' /></td>
					<td class="text-center"><a href="<c:url value='/a/board/${ board.boardId }?${ parameter }' />"><c:out value='${ board.subject }' /></a></td>
					<td class="text-center">***</td>
					<td class="text-center">
						<c:if test="${ board.vital == 'Y' }"><c:out value='${ board.vital }' /></c:if>
						<c:if test="${ board.vital == 'N' }"><font color="tomato"><c:out value='${ board.vital }' /></font></c:if>
					</td>
					<td class="text-center"><fmt:formatDate value='${ board.addTime }' pattern='yyyy-MM-dd' /></td>
					<td class="text-center"><fmt:formatDate value='${ board.modifyTime }' pattern='yyyy-MM-dd' /></td>
					<td class="text-center"><c:out value='${ board.user.name }' /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

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

	</div>
</div>

<%@ include file="/WEB-INF/view/jsp/admin/fragment/footer.html" %>
<%@ include file="/WEB-INF/view/jsp/admin/fragment/js.jsp" %>
</body>
</html>
