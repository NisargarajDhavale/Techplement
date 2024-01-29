<%@ page import="java.io.*,java.util.*" %>
<%@ page isErrorPage="true" %>
<%@ page import="java.lang.*" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Error Page</title>
</head>
<body>
<div>
    <h2>Exception Details:</h2>
    <p><b>Exception Type:</b> <%= exception.getClass().getName() %></p>
    <p><b>Message:</b> <%= exception.getMessage() %></p>
    <h3>Stack Trace:</h3>
    <pre>
        <% exception.printStackTrace(new java.io.PrintWriter(out)); %>
    </pre>

</div>
</body>
</html>
