<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h1>Login Page</h1>
    <form action="${pageContext.request.contextPath}/login" method="post">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required/><br/><br/>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required/><br/>
            <input type="submit" value="Login"/>
        </form>
</body>
</html>