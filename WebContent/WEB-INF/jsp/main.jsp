<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.WrittenPost, java.util.List" %>
<% List<WrittenPost> writtenPostList = (List<WrittenPost>) application.getAttribute("writtenPostList");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name=”viewport” content=”width=device-width,initial-scale=1.0,minimum-scale=1.0″>
<title>テストアプリ</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/posts.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/posts-responsive.css">
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
</head>
<body>
<jsp:include page="/header.jsp" />
<div class="main posts-index">
<div class="container">
<% for(WrittenPost writtenPost : writtenPostList){ %>
<div class="posts-index-item">
 <div class="post-left">
 <img src= "${pageContext.request.contextPath}/media/<%= writtenPost.getIcon()%>">
 </div>
 <div class="post-right">
 <div class="post-user-name">
  <a href="/ScratchPaper/user?userId=<%= writtenPost.getUserId()%>"><%= writtenPost.getName() %></a>
  </div>
  <a href="/ScratchPaper/posts?postId=<%= writtenPost.getPostId()%>"><%= writtenPost.getText() %></a>
  </div>
  </div>
<% } %>
</div>
</div>
</body>
</html>