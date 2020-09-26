<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>テストアプリ</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/posts.css">
</head>
<body>
<jsp:include page="/header.jsp" />
<div class="main posts-chow">
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
<a href="/testJavaApp/DeleteServlet?action=posts">削除</a>
</c:if>
</div>
</div>
</div>
</body>
</html>
