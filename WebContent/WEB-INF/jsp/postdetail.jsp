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
<c:out value="${postDetail.postId}" /><br>
<c:out value="${postDetail.name}" /><br>
<c:out value="${postDetail.text}" /><br>
<c:if test="${postDetail.userId == account.userId}" var="flg" />
<c:if test="${flg}" >
<a href="/testJavaApp/DeleteServlet?action=posts">削除</a>
</c:if>
<a href="/testJavaApp/PostsServlet">つぶやき</a>
</body>
</html>
