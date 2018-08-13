<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
<jsp:include page="/WEB-INF/view/jsp/admin/fragment/head.jsp" />
<body>

<div class="container">
	<div class="page-header">
		<h1><b>USER LIST</b></h1>
	</div>
	<ol class="breadcrumb">
		<li>HOME</li>
		<li>USER</li>
		<li class="active">USER LIST</li>
	</ol>
	<div>

<div class="text-right">
	<form action="<c:url value='${ baseUrl }' />" method="get" class="form-inline">
		<div class="form-group">
			<input type="hidden" name="viewRecord" value="<c:out value='${ pageParam.viewRecord }' />">
			<label class="radio-inline">
				<c:if test="${ searchParam.searchOption == 1 }">
					<input type="radio" name="searchOption" value="1" id="searchOption" checked> NAME
				</c:if>
				<c:if test="${ searchParam.searchOption != 1 }">
					<input type="radio" name="searchOption" value="1" id="searchOption"> NAME
				</c:if>
			</label>&nbsp;
			<input type="text" name="searchValue" id="searchValue" placeholder="SEARCH" class="form-control">
			<button type="submit" class="btn btn-default"><font color="royalblue">GO</font></button>
			<a href="<c:url value='${ baseUrl }' />" class="btn btn-default">ALL</a>
		</div>
	</form>
</div>

<div>&nbsp;</div>
<div class="panel panel-default">
	<table class="table table-condensed table-bordered table-hover">
		<thead>
			<tr class="active">
				<th class="text-center">ID</th>
				<th class="text-center">NAME</th>
				<th class="text-center">VITAL</th>
				<th class="text-center">ADD DATE</th>
				<th class="text-center">MODIFY DATE</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${ list }">
				<tr>
					<td class="text-center active"><c:out value='${ user.userId }' /></td>
					<td class="text-center"><a href="" onclick="choice('${ user.userId }', '${ user.name }');"><c:out value='${ user.name }' /></a></td>
					<td class="text-center">
						<c:if test="${ user.vital == 'Y' }"><c:out value='${ user.vital }' /></c:if>
						<c:if test="${ user.vital == 'N' }"><font color="tomato"><c:out value='${ user.vital }' /></font></c:if>
					</td>
					<td class="text-center"><fmt:formatDate value='${ user.addTime }' pattern='yyyy-MM-dd' /></td>
					<td class="text-center"><fmt:formatDate value='${ user.modifyTime }' pattern='yyyy-MM-dd' /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<div class="row">
	<div class="col-md-6">
		TOTAL <font color="tomato"><fmt:formatNumber value='${ totalRecord }' groupingUsed='true' /></font> RECORD
	</div>
	<div class="col-md-6 form-inline text-right">
		<select name="viewRecord" id="viewRecord" class="form-control">
			<option value="10">VIEW 10 RECORD</option>
			<option value="20">VIEW 20 RECORD</option>
			<option value="30">VIEW 30 RECORD</option>
			<option value="50">VIEW 50 RECORD</option>
		</select>
	</div>
</div>

<div class="text-center">
	<c:out value='${ pagination }' escapeXml='false' />
</div>

<div class="text-center">
	<a onclick="window.close();" class="btn btn-default">CLOSE</a><br><br>
</div>

	</div>
</div>

<%@ include file="/WEB-INF/view/jsp/admin/fragment/footer.html" %>
<%@ include file="/WEB-INF/view/jsp/admin/fragment/js.jsp" %>
<script type="text/javascript">
	$("#searchValue").val("${ searchParam.searchValue }");
	$("#viewRecord").val("${ pageParam.viewRecord }");
	
	$("#viewRecord").on("change", function() {
		location.href = "<c:url value='${ baseUrl }?viewRecord=' />"+ $("#viewRecord").val() +"&${ searchParam.getParam() }";
	});
	
	function choice(userId, name) {
		$("#user\\.userId", opener.document).val(userId);
		$("#user\\.name", opener.document).val(name);
		$("#user\\.name", opener.document).prop("disabled", true);
		self.close();
	}
</script>
</body>
</html>
