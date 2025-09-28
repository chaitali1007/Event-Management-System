<%@ page import="com.campus.model.User" %>
<%
User u=(User)session.getAttribute("user");
%>
<html><body>
<h1>Campus Event System</h1>
<% if(u==null){ %>
<a href="login.jsp">Login</a> | <a href="register.jsp">Register</a>
<% } else { %>
Hello <b><%=u.getName()%></b> (<%=u.getRole()%>) | <a href="logout">Logout</a>
<a href="events">Events</a>
<% if("admin".equals(u.getRole())){ %> | <a href="create_event.jsp">Create Event</a><% } %>
<% } %>
</body></html>
