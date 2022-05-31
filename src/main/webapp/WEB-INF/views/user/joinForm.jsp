<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="../layout/header.jsp" %>


<div class="container">
    <form>
        <div class="form-group">
            <label for="username">Username</label>
            <input type="text" class="form-control" placeholder="username" id="username">
        </div>
        <div class="form-group">
            <label for="email">Password</label>
            <input type="password" class="form-control" placeholder="password" id="password">
        </div>
        <div class="form-group">
            <label for="password">Email</label>
            <input type="email" class="form-control" placeholder="email" id="email">
        </div>
        <div class="form-group form-check">
            <label class="form-check-label">
                <input class="form-check-input" type="checkbox"> Remember me
            </label>
        </div>
        <button id="btn-save" type="submit" class="btn btn-primary">회원가입완료</button>
    </form>
</div>
<br/>
<script src="/blog/js/user.js"></script>
<%@include file="../layout/footer.jsp" %>