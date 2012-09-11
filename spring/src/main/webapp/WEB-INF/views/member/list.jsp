<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title></title>
</head>
<body>

<table>

    <thead>
    <td>姓名</td>
    <td>姓名</td>
    <td>姓名</td>
    <td>姓名</td>
    <td>姓名</td>
    </thead>
    <c:forEach items="${memberList}" var="m">
        <tr>
            <td>
                    ${m.name}
            </td>
            <td>
                    ${m.name}
            </td>
            <td>
                    ${m.name}
            </td>
            <td>
                    ${m.name}
            </td>
            <td>
                    ${m.name}
            </td>
        </tr>

    </c:forEach>

    <a href="/member/create.htm">新增员工信息</a>
</table>
</body>
</html>