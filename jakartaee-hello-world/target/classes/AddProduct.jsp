<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Product</title>
</head>
<body>
    <h1>Add/Edit Product</h1>
    <form action="${pageContext.request.contextPath}/addProduct" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${product.name}"/><br/>
        <label for="price">Price:</label>
        <input type="text" id="price" name="price" value="${product.price}"/><br/>
        <input type="submit" value="Submit"/>
    </form>
</body>
</html>