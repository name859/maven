<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="url" value="${ pageContext.request.contextPath }/a" />
<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
				<span class="sr-only">Toggle Navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Maven</a>
		</div>
		<div id="navbar" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li><a href="<c:url value='/a/home' />"><font color="black">HOME</font></a></li>
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">USER <span class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="<c:url value='/a/user' />">USER LIST</a></li>
						<li><a href="<c:url value='/a/user/fm' />">USER ADD</a></li>
					</ul>
				</li>
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">BOARD <span class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="<c:url value='/a/board' />">BOARD LIST</a></li>
						<li><a href="<c:url value='/a/board/fm' />">BOARD ADD</a></li>
						<li class="divider"></li>
						<li class="dropdown-header">ex USER PAGE</li>
						<li><a href="<c:url value='/a/board/user' />">BOARD LIST</a></li>
					</ul>
				</li>
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">COMMENT <span class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="<c:url value='/a/comment' />">COMMENT LIST</a></li>
						<li><a href="<c:url value='/a/comment/fm' />">COMMENT ADD</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</div>
</nav>
