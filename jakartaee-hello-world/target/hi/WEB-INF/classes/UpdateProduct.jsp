<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="p14.Product" %>

<html>
<head>
    <title>Update Product</title>
</head>
<body>
    <h1>Update Product</h1>
    <form action="${pageContext.request.contextPath}/updateProduct" method="POST">

        <input type="hidden" name="id" value="<%= request.getAttribute("product") != null ? ((Product) request.getAttribute("product")).getId() : 0 %>">
        <label for="name">Product Name:</label>
        <input type="text" name="name" value="<%= request.getAttribute("product") != null ? ((Product) request.getAttribute("product")).getName() : "" %>" required>
        <br>
        <label for="price">Product Price:</label>
        <input type="number" name="price" value="<%= request.getAttribute("product") != null ? ((Product) request.getAttribute("product")).getPrice() : "" %>" required>
        <br>
        <button type="submit">Save Product</button>
    </form>
</body>
</html>