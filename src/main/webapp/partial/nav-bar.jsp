<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:setLocale value="${param.lang}"/>

<c:if test="${empty cookie.language.value}">
    <fmt:setLocale value="${pageContext.response.locale}"/>
</c:if>
<fmt:setBundle basename="labels"/>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup"
            aria-controls="navbarNavAltMarkup"
            aria-expanded="false"
            aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        <div class="navbar-nav">
            <a class="nav-item nav-link" href="task"><fmt:message key="title"/> </a>
            <a class="nav-item nav-link" href="new_task.jsp"> <fmt:message key="add"/> </a>
        </div>
    </div>
    <div>
        <fmt:setBundle basename="languages"/>
        <a href="language?lang=pl_PL"><fmt:message key="language.polish"/> </a>
        <a href="language?lang=de_DE"><fmt:message key="language.german"/> </a>
        <a href="language?lang=en_GB"><fmt:message key="language.english"/> </a>
    </div>
</nav>
