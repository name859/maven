<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
<jsp:include page="/WEB-INF/view/jsp/admin/fragment/head.jsp" />
<style type="text/css">
	::-webkit-scrollbar { display:none!important; }
	
	ul.table li ul li:nth-child(1) { width:10%; }
	ul.table li ul li:nth-child(2) { width:10%; }
	ul.table li ul li:nth-child(3) { width:25%; }
	ul.table li ul li:nth-child(4) { width:25%; }
	ul.table li ul li:nth-child(5) { width:10%; }
	ul.table li ul li:nth-child(6) { width:20%; }
</style>
<body>

<div class="container">
	<div class="page-header">
		<h1><b>BOARD NICE LIST</b></h1>
	</div>
	<ol class="breadcrumb">
		<li>HOME</li>
		<li>BOARD NICE</li>
		<li class="active">BOARD NICE LIST</li>
	</ol>
	<div>

<div>&nbsp;</div>
<div>
	<ul class="table table-condensed table-bordered table-hover">
		<li class="head active">
			<ul>
				<li class="text-center">ID</li>
				<li class="text-center">VITAL</li>
				<li class="text-center">ADD TIME</li>
				<li class="text-center">MODIFY TIME</li>
				<li class="text-center">BOARD</li>
				<li class="text-center">USER</li>
			</ul>
		</li>
		<li>
			<c:forEach var="boardNice" items="${ list }">
				<ul>
					<li class="text-center active"><c:out value='${ boardNice.boardNiceId }' /></li>
					<li class="text-center">
						<c:if test="${ boardNice.vital == 'Y' }"><c:out value='${ boardNice.vital }' /></c:if>
						<c:if test="${ boardNice.vital == 'N' }"><font color="tomato"><c:out value='${ boardNice.vital }' /></font></c:if>
					</li>
					<li class="text-center"><fmt:formatDate value='${ boardNice.addTime }' pattern='yyyy-MM-dd HH:mm:ss' /></li>
					<li class="text-center"><fmt:formatDate value='${ boardNice.modifyTime }' pattern='yyyy-MM-dd HH:mm:ss' /></li>
					<li class="text-center"><c:out value='${ boardNice.board.boardId }' /></li>
					<li class="text-center"><c:out value='${ boardNice.user.name }' /></li>
				</ul>
			</c:forEach>
		</li>
	</ul>
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
	$("#viewRecord").val("${ pageParam.viewRecord }");
	
	$("#viewRecord").on("change", function() {
		location.href = "<c:url value='${ baseUrl }?viewRecord=' />"+ $("#viewRecord").val() +"&${ searchParam.getParam() }";
	});
</script>
</body>
</html>
