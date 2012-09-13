<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="ctx" value="${pageContext.servletContext.contextPath}"></c:set>


<html>
<head>
    <title>${ctx}....</title>
    <jsp:include page="../include/common.jsp"></jsp:include>
</head>
<body>


<a href="${ctx}/member/index.do">员工信息列表</a>

员工信息
<table>
    <tr>
        <td>员工姓名</td>
        <td>入职时间</td>
        <td>工作年限</td>
    </tr>


    <tr>
        <td>
            ${member.name}
        </td>


        <td>
            ${member.enterDate}
        </td>

        <td>
            ${member.workLong}
        </td>
    </tr>
</table>

<hr>

当年请假信息

<table>
    <tr>
        <td>请假时间</td>
        <td>所属年份</td>
        <td>请假天数</td>
        <td>请假事由</td>

    </tr>

    <c:forEach items="${vacations}" var="v">
        <tr>
            <td>
                    ${v.name}
            </td>


            <td>
                    ${v.logDate}
            </td>

            <td>
                    ${v.logYear}
            </td>

            <td>
                    ${v.desc}
            </td>
        </tr>
    </c:forEach>


</table>
<hr>
本年度应有年假天数:${originalVacation},本年度剩余年假天数${leftVacation},本年度合计请假天数${sumRequiredVacations}

</body>
</html>