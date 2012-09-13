<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<table>
    <tr>
        <td>姓名</td>
        <td>
            <input name="name" id="name" value="${member.name}" class="required minlength maxlength">
        </td>
    </tr>
    <tr>
        <td>员工编号</td>
        <td>
            <input name="memberId" id="memberId" value="${member.memberId}" class="required digital">
        </td>
    </tr>
    <tr>
        <td>工作年限</td>
        <td>
            <input name="workLong" id="workLong" value="${member.workLong}" class="required digital min max">
        </td>
    </tr>
    <tr>
        <td>入职时间</td>
        <td>
            <input name="enterDate" readonly="readonly" id="enterDate" value="${member.enterDate}" class="required">
        </td>
    </tr>
</table>