<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>TODO LIST</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

    <link rel="stylesheet" href="webjars/bootstrap/4.1.3/css/bootstrap.min.css" type="text/css">
</head>
<body>
<div class="container">

    <c:if test="${empty cookie.language.value}">
        <fmt:setLocale value="${pageContext.response.locale}"/>
    </c:if>
    <c:if test="${!empty cookie.language.value}">
        <fmt:setLocale value="${cookie.language.value}"/>
    </c:if>

    <fmt:setBundle basename="labels"/>
    <jsp:include page="partial/nav-bar.jsp"/>

    <div>
        <table border="1">
            <thead>
            <tr>
                <th><fmt:message key="desc"/> </th>
                <th><fmt:message key="done"/></th>
                <th><fmt:message key="priority"/></th>
                <th><fmt:message key="addingTime"/></th>
            </tr>
            </thead>
            <tbody>

            <c:forEach var="item" items="${task}">
                    <c:url var="deleteUrl" value="task">
                        <c:param name="id" value="${item.id}"/>
                    </c:url>
                    <tr>
                        <td>${item.description}</td>
                        <td>${item.done}</td>
                        <td>${item.priority}</td>
                        <td>${item.addingDateTime}</td>
                        <td><a href="${deleteUrl}"><fmt:message key="remove"/> </a> </td>
                    </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<script src="webjars/jquery/3.3.1-1/jquery.min.js"></script>
<script src="webjars/popper.js/1.14.4/popper.min.js"></script>
<script src="webjars/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</body>
</html>
