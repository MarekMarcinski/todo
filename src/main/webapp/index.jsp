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
            String priorityString = request.getParameter("priority");
            if (description !=null && !description.isEmpty() && priorityString != null){

                TaskPriority priority = TaskPriority.valueOf(priorityString);
                Task task = new Task();
                task.setDescription(description);
                task.setPriority(priority);

                Gson gson = new Gson();
                String taskString = gson.toJson(task);
                String codedTask = Base64.getEncoder().encodeToString(taskString.getBytes());
                Cookie taskCookie = new Cookie("task" + task.getUuid(), codedTask);
                response.addCookie(taskCookie);
            }

        %>

        <%
            Cookie[] cookies = request.getCookies();
            for (Cookie cookie : cookies) {
                String cookieName = cookie.getName();
                String cookieFirstFourLetters = cookieName.substring(0, 4);
                if (cookieFirstFourLetters.equals("task")){
                    String decoded = new String(Base64.getDecoder().decode(cookie.getValue()));
                    Gson gson = new Gson();
                    Task task = gson.fromJson(decoded, Task.class);
                    out.println(task.toString() + "<br>");
                }
            }

        %>

    </div>

    <script src="webjars/jquery/3.3.1-1/jquery.min.js"></script>
    <script src="webjars/popper.js/1.14.4/popper.min.js"></script>
    <script src="webjars/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</body>
</html>
