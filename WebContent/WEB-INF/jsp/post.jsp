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
<form action="/testJavaApp/PostServlet" method="post">
<textarea name="post">
</textarea>
<input type="submit" value="送信">
</form>
</div>
</div>
</div>
</div>
</body>
</html>