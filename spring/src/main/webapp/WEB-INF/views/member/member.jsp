<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="ctx" value="${pageContext.servletContext.contextPath}"></c:set>

<html>
<head>
    <title>${title}</title>
    <jsp:include page="../include/common.jsp"></jsp:include>
</head>
<body>

<form action="${ctx}/member/save.do" method="post" id="memberForm">
    <jsp:include page="memberForm.jsp"></jsp:include>
    <input type="submit" value="保存员工信息">
    <a href="${ctx}/member/index.do">员工信息列表</a>
</form>
<script type="text/javascript">
    jQuery(document).ready(function () {
        $("#enterDate").datepicker({dateFormat:"yy-mm-dd"});

//            $("#name").rules("add", {required:true, minlength:2, maxlength:10});
//            $("#memberId").rules("add", {required:true, digits:true});
//            $("#workLong").rules("add", {required:true, digits:true, min:0, max:30});
//            $("#enterDate").rules("add", {required:true, minlength:2, maxlength:10});

        $("#memberForm").validate();
    });
</script>
</body>
</html>