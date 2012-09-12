<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="ctx" value="${pageContext.servletContext.contextPath}"></c:set>

<html>
<head>
    <title></title>
</head>
<body>

<form action="save.do" method="post">
    <table>
        <tr>
            <td>姓名</td>
            <td>
                <input name="member.name">
            </td>
        </tr>
        <tr>
            <td>姓名</td>
            <td>
                <input name="name">
            </td>
        </tr>
        <tr>
            <td>姓名</td>
            <td>
                <input name="name">
            </td>
        </tr>
        <tr>
            <td>姓名</td>
            <td>
                <input name="name">
            </td>
        </tr>
        <tr>
            <td>姓名</td>
            <td>
                <input name="name">
            </td>
        </tr>
    </table>
    <input type="submit" value="保存员工信息">
    <a href="index"></a>
</form>
</body>
</html>