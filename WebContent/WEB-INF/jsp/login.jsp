<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>テストアプリ</title>
</head>
<body>
<form action="/testJavaApp/LoginServlet" method="post">
<c:if test="${not empty errorMsg}">
<c:out value="${errorMsg}" />
</c:if><br>
名前:<input type="text" name="name"><br>
パスワード:<input type="password" name="pass"><br>
<input type="submit" value="ログイン">
</form><br>
<a href="/testJavaApp/IndexServlet">トップへ</a>
</body>
</html>