<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Login Page</title>

    <!-- Bootstrap core CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/resources/css/login.css" rel="stylesheet">
</head>
<body style='margin:50px;'>
<%
    String orgRequestUrl = (String)request.getAttribute("orgRequestUrl");
    String redirectUrl = orgRequestUrl == null ? request.getParameter("orgRequestUrl") : orgRequestUrl;
%>
<main class="box">
    <h2>Login</h2>
    <form action="/login?orgRequestUrl=<%=redirectUrl %>" method="post">

        <c:if test="${errorMsg != null}">
            <p style='color:red'>
                <%=request.getAttribute("errorMsg") %>
            </p>
        </c:if>
        <div class="inputBox">
            <label for="userId">User ID</label>
            <input type="text" id="userId" name="userId"/>
        </div>
        <div class="inputBox">
            <label for="password">Password</label>
            <input type="password" id="password" name="password"/>
        </div>
        <div>
            <button type="submit" style="float: left;">Log in</button>
        </div>
    </form>
</main>
</body>
</html>