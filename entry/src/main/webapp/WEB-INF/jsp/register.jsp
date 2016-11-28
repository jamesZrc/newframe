<%--
  Created by IntelliJ IDEA.
  User: james
  Date: 2016/11/2
  Time: 22:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<div>注册</div>

<form:form modelAttribute="user" action="${pageContext.request.contextPath}/rest/register/add" method="post">

    <table>
        <tr>
            <td>UserName:</td><td><form:input path="userName"/></td>
        </tr>
        <tr>
            <td>Password:</td><td><form:input path="password"/></td>
        </tr>
        <tr>
            <td>Confirm password:</td><td><input name="confirmpassword"/></td>
        </tr>
        <tr>
            <td>vVerificationCode:</td><td><form:input path="vVerificationCode"/></td>
        </tr>
    </table>
    <input type="submit" value="提交"/></td>
</form:form>

</body>
</html>
