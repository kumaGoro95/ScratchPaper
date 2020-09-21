<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.WrittenPost, java.util.List" %>
<% List<WrittenPost> writtenPostList = (List<WrittenPost>) request.getAttribute("writtenPostList");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>テストアプリ</title>
</head>
<body>
<p><a href="/testJavaApp/PostsServlet">更新</a></p>
<p><a href="/testJavaApp/PostServlet">つぶやく</a></p>
<% for(WrittenPost writtenPost : writtenPostList){ %>
  <p><%= writtenPost.getName() %>:<%= writtenPost.getText() %></p>
<% } %>
</body>
</html>