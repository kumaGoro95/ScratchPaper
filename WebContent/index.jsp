<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name=”viewport” content=”width=device-width,initial-scale=1.0,minimum-scale=1.0″>
<title>Scratch Paper</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/index-responsive.css">
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
</head>
<body>
<jsp:include page="/header.jsp" />
<div class="main top-main">
  <div class="top-message">
    <h2>Scratch paper</h2>
    <p>「自分の中でもやもやしている気持ち」「人に言えない悩み」を気軽につぶやこう</p>
  </div>
  <div class="top-btn">
  <p>
<a href="${pageContext.request.contextPath}/login" class="btn login">ログイン</a>
<a href="${pageContext.request.contextPath}/signup" class="btn signup">会員登録</a>
  </p>
<p>ゲストユーザーで試してみる</p>
<div class="guest">
<form action="/ScratchPaper/login" method="post">
<input name="userId" type="hidden" value="guest">
<input name="pass" type="hidden" value="password">
<input class="btn guest-login" type="submit" VALUE="ゲストログイン" >
</form>
</div>
  </div>
</div>
</body>
</html>