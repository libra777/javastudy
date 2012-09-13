<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="ctx" value="${pageContext.servletContext.contextPath}"></c:set>


<html>
<head>
    <title>${ctx}....</title>
    <jsp:include page="../include/common.jsp"></jsp:include>
</head>
<body>

<table>

    <thead>
    <td>员工编号</td>
    <td>员工姓名</td>
    <td>工作年限</td>
    <td>入职时间</td>
    <td>信息查询</td>
    </thead>
    <tbody>
    <c:forEach items="${memberList}" var="m">
        <tr>
            <td>
                <a href="${ctx}/member/updateMember.do?id=${m.id}">${m.memberId}</a>
            </td>
            <td>
                    ${m.name}
            </td>
            <td>
                    ${m.workLong}
            </td>
            <td>
                    ${m.enterDate}
            </td>
            <td>
                <a href="">年假信息</a>
            </td>

        </tr>

    </c:forEach>
    </tbody>
    <a href="${ctx}/member/create.do">新增员工信息</a>
</table>
</body>
</html>