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
<form action="/testJavaApp/PostServlet" method="post">
<c:if test="${not empty errorMsg}">
<c:out value="${errorMsg}" />
</c:if>
<c:if test="${empty errorMsg}">
150字以内で入力してください
</c:if>
<br><br>
<textarea name="post">
</textarea>
<input type="submit" value="送信">
</form>
</body>
</html>