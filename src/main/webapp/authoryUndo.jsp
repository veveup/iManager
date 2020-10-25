<%--
  Created by IntelliJ IDEA.
  User: veve
  Date: 2020/10/26
  Time: 12:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="authory.jsp"></jsp:include>
<%
    if(session.getAttribute("authory")!=null){
        session.setAttribute("authory",null);
        response.getWriter().write("<meta http-equiv=\"refresh\" content=\"0; url=index.jsp\">");
    }
%>
<html>
<head>
    <jsp:include page="includeStatic.jsp"></jsp:include>
    <meta http-equiv="refresh" content="0; url=index.jsp">
    <title>Log Out</title>
</head>
<body>



</body>
</html>
