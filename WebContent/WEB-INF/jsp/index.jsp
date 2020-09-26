<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>テストアプリ</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/stylesheet.css">
<script src="https://kit.fontawesome.com/675ef5529e.js" crossorigin="anonymous"></script>
</head>
<body>
<jsp:include page="/header.jsp" />
<div class="main top-main">
  <div class="top-message">
    <h2>Tweet to the world.<br>Connect to the world.</h2>
    <p>Share your favorite moments!</p>
  </div>
  <div class="top-btn">
  <p>
<a href="/testJavaApp/LoginServlet" class="btn login">ログイン</a>
<a href="/testJavaApp/SignupServlet" class="btn signup">ユーザー登録</a>
  </p>
  </div>
</div>
</body>
</html>