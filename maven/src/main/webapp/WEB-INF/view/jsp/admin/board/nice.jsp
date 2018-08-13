<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%
	String msg = "";
	if (request.getAttribute("result").equals("success")) {
		msg = "BOARD NICE SUCCESS!";
	} else {
		msg = "BOARD NICE FAIL!";
	}
%>
<!DOCTYPE html>
<html lang="ko">
<body>

<script type="text/javascript">
	alert("<%= msg %>");
	opener.window.location.reload();
	self.close();
</script>

</body>
</html>
