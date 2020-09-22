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
<h1>登録完了</h1><br>
<p>ようこそ<c:out value="${account.name}" />さん</p>
<a href="/testJavaApp/PostsServlet">つぶやき</a>
<a href="/testJavaApp/LogoutServlet">ログアウト</a>
</body>
</html>