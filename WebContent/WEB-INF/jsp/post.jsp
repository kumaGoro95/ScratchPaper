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
<div class="main posts-new">
  <div class="container">
    <h1 class="form-heading">Create a new Post</h1>
      <div class="form">
        <div class="form-body">
<c:if test="${not empty errorMsg}">
<div class="form-error">
<c:out value="${errorMsg}" />
</div>
</c:if>

<c:if test="${empty errorMsg}">
150字以内で入力してください
</c:if>
<form action="/ScratchPaper/post" method="post">
<textarea name="post">
</textarea>
<input type="submit" value="Send">
</form>
</div>
</div>
</div>
</div>
</body>
</html>