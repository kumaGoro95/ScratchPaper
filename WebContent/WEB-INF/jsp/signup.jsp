<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name=”viewport” content=”width=device-width,initial-scale=1.0,minimum-scale=1.0″>
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/users.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/users-responsive.css">
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
</head>
<body>
<jsp:include page="/header.jsp" />

<div class="main users-new">
<div class="container">
<h1 class="form-heading">Sign up</h1>
<div class="form users-form">
<div class="form-body">
<c:if test="${not empty errorMsg}">
<div class="form-error">
<c:out value="${errorMsg}" />
</div>
</c:if>

<c:if test="${empty errorMsg}">
パスワードは半角英数字4文字以上で入力してください
</c:if>
<form action="/ScratchPaper/signup" method="post">
ユーザーID:<input type="text" name="userId"><br>
名前:<input type="text" name="name"><br>
パスワード:<input type="password" name="pass"><br>
<input type="submit" value="Signup">
</form>
</div>
</div>
</div>
</div>
</body>
</html>