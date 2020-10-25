<%@ page import="com.veveup.dao.UserDao" %>
<%@ page import="com.veveup.domain.User" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: veve
  Date: 2020/10/21
  Time: 5:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="authory.jsp"></jsp:include>
<html>
<head>
    <jsp:include page="includeStatic.jsp"></jsp:include>
    <title>Title</title>
</head>
<body>


<%--<c:if test="${sessionScope.user!=null}">--%>
<%--    登陆成功--%>
<%--    <table border="1">--%>
<%--<tr>--%>
<%--<th>id</th>--%>
<%--<th>name</th>--%>
<%--<th>password</th>--%>
<%--<th>profile</th>--%>
<%--</tr>--%>

<%--    <c:forEach items="${users}" var="u" >--%>
<%--<tr>--%>
<%--    <td>${u.id}</td>--%>
<%--    <td>${u.name}</td>--%>
<%--    <td>${u.pass}</td>--%>
<%--    <td>${u.profile}</td>--%>
<%--</tr>--%>
<%--&lt;%&ndash;        ${u}<br>&ndash;%&gt;--%>
<%--    </c:forEach>--%>
<%--    </table>--%>
<%--</c:if>--%>
<%--<p class="buttons 922991">--%>
<%--<button class="button is-success">--%>
<%--    <span class="icon is-small">--%>
<%--      <i class="fas fa-check"></i>--%>
<%--    </span>--%>
<%--    <span><a href="${pageContext.request.contextPath}/addUser.jsp">Add</a></span>--%>
<%--</button>--%>
<%--</p>--%>

<jsp:include page="navbar.jsp"></jsp:include>
<%
    UserDao userDao = new UserDao();
    ArrayList<User> allUser = userDao.getAllUser();
    request.getSession().setAttribute("users",allUser);
%>

<c:if test="${sessionScope.author!=null}">

<div class="container">
    <div class="table-container">
        <table class="table is-bordered is-striped is-narrow is-hoverable is-fullwidth">
            <!-- Your table content -->
            <tbody>

            <tr>
                <th align="center">id</th>
                <th>name</th>
                <th>password</th>
                <th>profile</th>
                <th>action</th>
            </tr>
    <c:forEach items="${users}" var="u" >
            <tr>
                <th align="center">${u.id}</th>
                <th> ${u.name}</th>
                <th>${u.pass}</th>
                <th>${u.profile}</th>
                <th>

                    <div class="tags">
                        <a class="tag is-danger" href="${pageContext.request.contextPath}/deleteUser.do?name=${u.name}&id=${u.id}">Delete</a>
                        <a class="tag is-info" href="${pageContext.request.contextPath}/updateUser.jsp?name=${u.name}&id=${u.id}">Update</a>

                    </div>
                </th>

            </tr>
    </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</c:if>

</body>
</html>
