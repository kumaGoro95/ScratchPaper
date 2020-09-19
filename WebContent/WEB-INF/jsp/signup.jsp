<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/testJavaApp/SignupServlet" method="post">
<c:if test="${not empty errorMsg}">
<c:out value="${errorMsg}" />
</c:if>
<c:if test="${empty errorMsg}">
名前は4文字以上
パスワードは半角英数字4文字以上で入力
</c:if>
<br><br>
名前:<input type="text" name="name"><br>
パスワード:<input type="password" name="pass"><br>
<input type="submit" value="登録">
</form><br>
<a href="/testJavaApp/IndexServlet">トップへ</a>
</body>
</html>