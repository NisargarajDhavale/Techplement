<%@ page import="java.util.List" %>
<%@ page import="com.todolist.Task" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>To-Do List</title>
</head>
<body>

<div>
    <h1>To-Do List</h1>
    <form action="addTask" method="post">
        <input type="text" name="description" placeholder="New task" required>
        <button type="submit">Add</button>
    </form>

    <h2>Tasks:</h2>
    <ul>
        <% List<Task> tasks = (List<Task>) request.getAttribute("tasks");
        if (tasks != null) {
            for (Task task : tasks) { %>
                <li><%= task.getDescription() %></li>
            <% }
        } %>
    </ul>
</div>

</body>
</html>
