<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="ctx" value="${pageContext.servletContext.contextPath}"></c:set>


<html>
<head>
    <title>${ctx}....</title>
</head>
<body>

<table>

    <thead>
    <td>姓名1</td>
    <td>姓名2</td>
    <td>姓名3</td>
    <td>姓名4</td>
    <td>姓名5</td>
    </thead>
    <tbody>
    <c:forEach items="${memberList}" var="m">
        <tr>
            <td>
                    ${m.id}
            </td>
            <td>
                    ${m.id}
            </td>
            <td>
                    ${m.id}
            </td>
            <td>
                    ${m.id}
            </td>
            <td>
                    ${m.name}
            </td>
        </tr>

    </c:forEach>
    </tbody>

    <a href="create.do">新增员工信息</a>


</table>
</body>
</html>