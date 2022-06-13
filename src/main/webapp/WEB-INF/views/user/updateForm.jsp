<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="../layout/header.jsp" %>



<div class="container">
    <form>
        <input type="hidden" id="id" value="${principal.user.id}"/>
        <div class="form-group">
            <label for="username">Username</label>
            <input type="text" value="${principal.user.username}" class="form-control" placeholder="username" id="username" readonly>
        </div>
        <div class="form-group">
            <label for="email">Password</label>
            <input type="password"   class="form-control" placeholder="password" id="password">
        </div>
        <div class="form-group">
            <label for="password">Email</label>
            <input type="email" value="${principal.user.email}" class="form-control" placeholder="email" id="email">
        </div>

    </form>
    <button id="btn-update" type="submit" class="btn btn-primary">회원수정완료</button>
</div>
<br/>
<script src="/js/user.js"></script>
<%@include file="../layout/footer.jsp" %>