<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>University Login</title>
    <style>
        body { font-family: Arial; margin: 50px; }
        .error { color: red; margin-bottom: 10px; }
        input { margin-bottom: 10px; padding: 5px; width: 250px; }
        button { padding: 5px 15px; cursor: pointer; }
    </style>
</head>
<body>

    <h2>University Course Registration - Login</h2>

    <% if (request.getAttribute("error") != null) { %>
        <div class="error"><%= request.getAttribute("error") %></div>
    <% } %>

    <form action="login" method="post">
        <div>
            <label>Email:</label><br>
            <input type="email" name="email" required>
        </div>
        <div>
            <label>Password:</label><br>
            <input type="password" name="password" required>
        </div>
        <button type="submit">Login</button>
    </form>

</body>
</html>