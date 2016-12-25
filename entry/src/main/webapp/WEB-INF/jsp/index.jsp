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
    <title>Title</title>
</head>
<body>
 <div>Welcome: ${currentUser.username}</div>

 <table>
     <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.username}</td>
            <td>${user.password}</td>
        </tr>
     </c:forEach>

 </table>

 <form:form action="${pageContext.request.contextPath}/logout.do" method="post">
     <input type="submit" value="退出"/></td>
 </form:form>

<a href="${pageContext.request.contextPath}/register/index.do">注册</a>

<div>
    AccessIp: ${accessIp}

</div>

</body>
</html>
