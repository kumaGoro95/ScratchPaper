<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <header>
   <div class="container">
      <div class="header-logo">
        <c:choose>
          <c:when test="${not empty account}">
            <a href="/ScratchPaper/posts">Scratch paper</a>
          </c:when>
          <c:otherwise>
            <a href="/ScratchPaper/index">Scratch paper</a>
          </c:otherwise>
        </c:choose>
      </div>
      <div id="menu">
		<div><a href="#menu" class="menuopen"><span class="fa fa-bars menu-icon"></span></a><a href="#close" class="menuclose"><span class="fa fa-bars menu-icon"></span></a></div>
      <ul class="header-menus">
         <c:choose>
          <c:when test="${not empty account}">
          <li>
            <a href="/ScratchPaper/user?userId=${account.userId}">${account.name}</a>
          </li>
          <li>
            <a href="/ScratchPaper/posts">Posts</a>
          </li>
          <li>
            <a href="/ScratchPaper/post">NewPost</a>
          </li>
          <li>
            <a href="/ScratchPaper/logout">Logout</a>
          </li>
        </c:when>
          <c:otherwise>
          <li>
            <a href="/ScratchPaper/signup">Signup</a>
          </li>
          <li>
            <a href="/ScratchPaper/login">Login</a>
          </li>
        </c:otherwise>
        </c:choose>
      </ul>
      </div>
      </div>
      </div>
   </header>
