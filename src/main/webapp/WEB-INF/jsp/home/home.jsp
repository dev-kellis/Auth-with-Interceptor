<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%><%@ page import="kr.kellis.aawithinterceptor.app.dto.User" %>
<%@ page import="kr.kellis.aawithinterceptor.app.dto.User" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<body>
<%
    User loginUser = (User)session.getAttribute("LOGGED_USER");
%>

<h1>Welcome! <%=loginUser.getName() %></h1>

<form action="/logout" method="post">
    <button type="submit">Log out</button>
</form>
</body>
</html>