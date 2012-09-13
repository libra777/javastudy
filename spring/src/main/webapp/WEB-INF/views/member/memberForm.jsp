<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<table>
    <tr>
        <td>姓名</td>
        <td>
            <input name="name" id="name" value="${member.name}">
        </td>
    </tr>
    <tr>
        <td>员工编号</td>
        <td>
            <input name="memberId" id="memberId" value="${member.memberId}">
        </td>
    </tr>
    <tr>
        <td>工作年限</td>
        <td>
            <input name="workLong" id="workLong" value="${member.workLong}">
        </td>
    </tr>
    <tr>
        <td>入职时间</td>
        <td>
            <input name="enterDate" readonly="readonly" id="enterDate" value="${member.enterDate}">
        </td>
    </tr>
</table>