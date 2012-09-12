<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="ctx" value="${pageContext.servletContext.contextPath}"></c:set>

<html>
<head>
    <title>Home</title>
</head>
<body>
<h1>
    Hello world!
</h1>
${controllerMessage}
<a href="${ctx}/member/index.do">员工管理</a>
</body>
</html>
