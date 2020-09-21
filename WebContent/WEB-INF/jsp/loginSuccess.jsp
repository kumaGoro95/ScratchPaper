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
<c:if test="${not empty errorMsg}">
<c:out value="${errorMsg}" />
</c:if><br>
<p>ようこそ<c:out value="${userName}" />さん</p>
<a href="/testJavaApp/PostsServlet">つぶやき</a>
<a href="/testJavaApp/IndexServlet">トップへ</a>
<a href="/testJavaApp/LogoutServlet">ログアウト</a>
</body>
</html>