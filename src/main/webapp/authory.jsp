<%--
  Created by IntelliJ IDEA.
  User: veve
  Date: 2020/10/25
  Time: 5:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%
    if (session.getAttribute("author")==null){
        System.out.println("有憨包没有登陆 进行非法操作");
        response.setContentType("text/html;charset=UTF-8");
//        response.getWriter().write("憨包 还没有登陆呢 再见");
        response.getWriter().write("<meta http-equiv=\"refresh\" content=\"0; url=index.jsp\">");
    }

%>