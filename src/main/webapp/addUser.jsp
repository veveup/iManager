<%--
  Created by IntelliJ IDEA.
  User: veve
  Date: 2020/10/22
  Time: 12:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="authory.jsp"></jsp:include>

<html>
<head>
    <jsp:include page="includeStatic.jsp"></jsp:include>
    <title>AddUser</title>
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
<div class="container">
<form action="${pageContext.request.contextPath}/adduser.do" method="post">

    <div class="field">
        <label class="label">用户名</label>
        <div class="control">
            <input class="input" type="text" name="name">
        </div>
    </div>

    <div class="field">
        <label class="label">密码</label>
        <div class="control">
            <input class="input" type="password" name="password">
        </div>
    </div>

    <div class="field">
        <label class="label">用户简介</label>
        <div class="control">
            <input class="input" type="text" name="profile">
        </div>
    </div>





    <button name="Submit" class="button is-primary " type="submit">Add</button>
</form>
    </div>

</body>
</html>
