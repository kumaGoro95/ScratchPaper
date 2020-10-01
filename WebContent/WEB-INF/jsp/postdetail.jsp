<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name=”viewport” content=”width=device-width,initial-scale=1.0,minimum-scale=1.0″>
<title>テストアプリ</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/posts.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/posts-responsive.css">
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
</head>
<body>
<jsp:include page="/header.jsp" />
<div class="main posts-show">
 <div class="container">
 <div class="posts-show-item">
 <div class="post-user-name">
 <img src="${pageContext.request.contextPath}/media/${postDetail.icon}">
<c:out value="${postDetail.name}" />
</div>
<p>
<c:out value="${postDetail.text}" />
</p>
<c:if test="${postDetail.userId == account.userId}" var="flg" />
<c:if test="${flg}" >
<a href="/ScratchPaper/delete?action=posts">削除</a>
</c:if>
</div>
</div>
</div>
</body>
</html>
