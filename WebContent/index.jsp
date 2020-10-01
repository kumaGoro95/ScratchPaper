<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name=”viewport” content=”width=device-width,initial-scale=1.0,minimum-scale=1.0″>
<title>テストアプリ</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/index-responsive.css">
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
</head>
<body>
<jsp:include page="/header.jsp" />
<div class="main top-main">
  <div class="top-message">
    <h2>Scratch paper means paper <br>for quick notes or sketches.</h2>
    <p>Please post freely!!</p>
  </div>
  <div class="top-btn">
  <p>
<a href="${pageContext.request.contextPath}/login" class="btn login">Login</a>
<a href="${pageContext.request.contextPath}/signup" class="btn signup">Signup</a>
  </p>
<p>Guest Login is here.↓</p>
<div class="guest">
<form action="/ScratchPaper/login" method="post">
<input name="userId" type="hidden" value="guest">
<input name="pass" type="hidden" value="password">
<input type="image" src="${pageContext.request.contextPath}/media/guest.png" VALUE="submit" border="0">
</form>
</div>
  </div>
</div>
</body>
</html>