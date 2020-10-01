<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>テストアプリ</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/users.css">
</head>
<body>
<jsp:include page="/header.jsp" />

<div class="main users-new">
  <div class="container">
    <h1 class="form-heading">Login</h1>
    <div class="form users-form">
    <div class="form-body">
      <c:if test="${not empty errorMsg}">
       <div class="form-error">
      <c:out value="${errorMsg}" />
        </div>
      </c:if>

<form action="/ScratchPaper/login" method="post">
ユーザーID:<input type="text" name="userId"><br>
パスワード:<input type="password" name="pass"><br>
<input type="submit" value="Login">
</form>
</div>
</div>
</div>
</div>
</body>
</html>