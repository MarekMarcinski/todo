<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add a new task</title
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

    <link rel="stylesheet" href="webjars/bootstrap/4.1.3/css/bootstrap.min.css" type="text/css">
</head>
<body>

    <div class="container">

        <jsp:include page="partial/nav-bar.jsp"/>

        <form action="index.jsp" method="POST">
            <div class="form-group">
                <label for="description">Description</label>
                <textarea type="text" class="form-control"
                          name="description" id="description"></textarea>
            </div>
            <div class="form-group">
                <label for="priority">Ważność</label>
                <select class="form-control" id="priority" name="priority">
                    <option name="IMPORTANT" value="IMPORTANT">Ważne</option>
                    <option name="MODERATELY_IMPORTANT" value="MODERATELY_IMPORTANT">Średnio ważne</option>
                    <option name="NOT_IMPORTANT" value="NOT_IMPORTANT">Nieważne</option>
                </select>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>

    </div>

    <script src="webjars/jquery/3.3.1-1/jquery.min.js"></script>
    <script src="webjars/popper.js/1.14.4/popper.min.js"></script>
    <script src="webjars/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</body>
</html>
