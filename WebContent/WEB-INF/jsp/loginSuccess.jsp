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
<p>ようこそ<c:out value="${name}" />さん</p>
<a href="/testJavaApp/IndexServlet">トップへ</a>
<a href="/testJavaApp/Logout">ログアウト</a>
</body>
</html>