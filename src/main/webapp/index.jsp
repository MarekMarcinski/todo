<%@ page import="org.marcinski.todo.model.Task" %>
<%@ page import="org.marcinski.todo.model.TaskPriority" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="com.google.gson.Gson" %>
<%@ page import="java.util.Base64" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TODO LIST</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

    <link rel="stylesheet" href="webjars/bootstrap/4.1.3/css/bootstrap.min.css" type="text/css">
</head>
<body>

    <div class="container">

        <jsp:include page="partial/nav-bar.jsp"/>

        <%
            String description = request.getParameter("description");
            TaskPriority priority = TaskPriority.IMPORTANT;
            if (description !=null && !description.isEmpty() && priority != null){

                Task task = new Task();
                task.setDescription(description);
                task.setDone(false);
                task.setPriority(priority);
                task.setAddingDateTime(LocalDateTime.now());

                Gson gson = new Gson();
                String taskString = gson.toJson(task);
                String codedTask = Base64.getEncoder().encodeToString(taskString.getBytes());
                Cookie taskCookie = new Cookie("task", codedTask);
                response.addCookie(taskCookie);
            }

        %>

    </div>

    <script src="webjars/jquery/3.3.1-1/jquery.min.js"></script>
    <script src="webjars/popper.js/1.14.4/popper.min.js"></script>
    <script src="webjars/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</body>
</html>
