<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/users.css">
</head>
<body>
<jsp:include page="/header.jsp" />

<div class="main user-show">
<div class="container">
<div class="user">
<c:if test="${empty userAccount}">
<h3>ユーザーが見つかりません</h3>
</c:if>
<img src="${pageContext.request.contextPath}/media/${userAccount.icon}">
<h2><c:out value="${userAccount.name}" /></h2>
<p><c:out value="${userAccount.userId}" /></p>
<c:if test="${userAccount.userId == account.userId}" var="flg" />
<c:if test="${flg}" >
<a href="/testJavaApp/DeleteServlet?action=user">削除</a>
</c:if>
</div>
</div>
</div>
</body>
</html>