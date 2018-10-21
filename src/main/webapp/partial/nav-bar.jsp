<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:setLocale value="${param.lang}"/>
<fmt:setBundle basename="labels"/>
<fmt:setBundle basename="languages"/>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup"
            aria-controls="navbarNavAltMarkup"
            aria-expanded="false"
            aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        <div class="navbar-nav">
            <a class="nav-item nav-link" href="task">Task list</a>
            <a class="nav-item nav-link" href="new_task.jsp">Add new Task</a>

            <div>
                <a href="language?lang=pl_PL"><fmt:message key="language.polish"/> </a>
                <a href="language?lang=de_DE"><fmt:message key="language.german"/> </a>
                <a href="language?lang=en_GB"><fmt:message key="language.english"/> </a>
            </div>
        </div>
    </div>
</nav>
