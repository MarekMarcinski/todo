<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:if test="${empty cookie.language.value}">
    <fmt:setLocale value="${pageContext.response.locale}"/>
</c:if>
<c:if test="${!empty cookie.language.value}">
    <fmt:setLocale value="${cookie.language.value}"/>
</c:if>
<fmt:setBundle basename="labels"/>

<html>
<head>
    <title>Add a new taskDto</title
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

    <link rel="stylesheet" href="webjars/bootstrap/4.1.3/css/bootstrap.min.css" type="text/css">
</head>
<body>

    <div class="container">

        <jsp:include page="partial/nav-bar.jsp"/>

        <form action="task" method="POST">
            <div class="form-group">
                <label for="description"><fmt:message key="desc"/> </label>
                <textarea type="text" class="form-control"
                          name="description" id="description"></textarea>
            </div>
            <div class="form-group">
                <label for="priority"><fmt:message key="priority"/> </label>
                <select class="form-control" id="priority" name="priority">
                    <option name="IMPORTANT" value="IMPORTANT"><fmt:message key="important"/> </option>
                    <option name="MODERATELY_IMPORTANT" value="MODERATELY_IMPORTANT"><fmt:message key="moderatelyImportant"/></option>
                    <option name="NOT_IMPORTANT" value="NOT_IMPORTANT"><fmt:message key="notImportant"/></option>
                </select>
            </div>
            <button type="submit" class="btn btn-primary"><fmt:message key="button"/> </button>
        </form>

    </div>

    <script src="webjars/jquery/3.3.1-1/jquery.min.js"></script>
    <script src="webjars/popper.js/1.14.4/popper.min.js"></script>
    <script src="webjars/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</body>
</html>
