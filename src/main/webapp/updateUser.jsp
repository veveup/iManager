<%@ page import="com.veveup.dao.UserDao" %>
<%@ page import="com.veveup.domain.User" %><%--
  Created by IntelliJ IDEA.
  User: veve
  Date: 2020/10/22
  Time: 3:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="authory.jsp"></jsp:include>



<%
    String name = request.getParameter("name");
//    String oldpassword = request.getParameter("oldpassword");
//    String newpassword = request.getParameter("newpassword");
//    String profile = request.getParameter("profile");
    User userByName = new UserDao().getUserByName(name);
    if(userByName!=null){
        session.setAttribute("olduser",userByName);
    }
//    if (userByName!=null){
//        if(userByName.getPass().equals(oldpassword)){
//            System.out.println("旧密码验证成功了");
//            userByName.setPass(newpassword);
//            userByName.setProfile(profile);
//            new UserDao().updateUserByUser(userByName);
//            System.out.println("密码可能更新成功了");
//        }else{
////            System.out.println("旧密码错误");
//        }
//    }else{
////        response.getWriter().write("没有这个用户");
//    }
//    response.getWriter().write("用户名或者密码错误！");
////    request.getRequestDispatcher(request.getContextPath()+"/manager.jsp").forward(request,response);
//    response.setStatus(response.SC_MOVED_TEMPORARILY);
//    response.setHeader("Location",request.getContextPath()+"/manager.jsp");

%>
<html>
<head>
    <jsp:include page="includeStatic.jsp"></jsp:include>
    <title>Title</title>
</head>
<body>

<jsp:include page="navbar.jsp"></jsp:include>
<script>
    function docheck() {
    //    检查两次密码是否相同
        // 密码若不相同 返回false 浏览器不会发起请求
        return true;

    }
</script>
<div class="container">
<form class="form" action="${pageContext.request.contextPath}/update.do" method="post" enctype="application/x-www-form-urlencoded">

    <div class="field">
        <label class="label">用户名</label>
        <div class="control">
            <input class="input" type="text" name="name" value="${olduser.name}">
        </div>
    </div>

    <div class="field">
        <label class="label">旧密码</label>
        <div class="control">
            <input class="input" type="password" name="password" >
        </div>
    </div>

    <div class="field">
        <label class="label">新密码</label>
        <div class="control">
            <input class="input" type="password" name="newpassword">
        </div>
    </div>

    <div class="field">
        <label class="label">重复输入</label>
        <div class="control">
            <input class="input" type="password" name="renewpassword">
        </div>
    </div>


    <button type="submit" class="button is-primary" onclick="docheck();" >Update</button>

</form>

</div>

</body>
</html>
