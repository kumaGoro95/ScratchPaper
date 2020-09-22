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
<img src="${pageContext.request.contextPath}/media/test.jpg" alt="くまさん"><br>
<c:out value="${userAccount.userId}" /><br>
<c:out value="${userAccount.name}" /><br>
<c:out value="${userAccount.pass}" /><br>
<a href="/testJavaApp/PostsServlet">つぶやき</a>
</body>
</html>