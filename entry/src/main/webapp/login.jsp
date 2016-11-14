<%--
  Created by IntelliJ IDEA.
  User: james`
  Date: 2016/11/6
  Time: 12:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<% if (request.getParameter("error") != null) { %>
    <div> 登录失败</div>
<% } %>

    <form:form action="${pageContext.request.contextPath}/login.do" method="post">
        <table>
            <tr>
                <td>userName:</td><td><input name="username"/></td>
            </tr>
            <tr>
                <td>password:</td><td><input name="password"/></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="提交"/></td>
            </tr>
        </table>
    </form:form>
</body>
</html>
