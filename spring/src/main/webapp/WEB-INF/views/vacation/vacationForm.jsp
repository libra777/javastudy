<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<table>
    <tr>
        <td>请假天数</td>
        <td>

            <select name="days">
                <option value="1">1</option>
                <option value="1">1</option>
                <option value="1">1</option>
                <option value="1">1</option>
            </select>
        </td>
    </tr>
    <tr>
        <td>请假事由</td>
        <td>
            <textarea rows="10" cols="120" name="desc">
                ${v.desc}
            </textarea>
        </td>
    </tr>

</table>