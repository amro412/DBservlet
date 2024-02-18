<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="p14.Product" %>

<html>
<head>
    <title>Product List</title>
</head>
<body>
    <h1>Product List</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Action</th>
            <th>Action</th>
        </tr>
        <% List<Product> products = (List<Product>) request.getAttribute("products"); %>
        <% if (products != null && !products.isEmpty()) { %>
            <% for (Product product : products) { %>
                <tr>
                    <td><%= product.getId() %></td>
                    <td><%= product.getName() %></td>
                    <td><%= product.getPrice() %></td>
                    <td><a href="<%= request.getContextPath() %>/updateProduct?id=<%= product.getId() %>">Update</a></td>
                    <td><a href="<%= request.getContextPath() %>/deleteProduct?id=<%= product.getId() %>">Delete</a></td>
                </tr>
            <% } %>
        <% } else { %>
            <tr>
                <td colspan="5">No products available</td>
            </tr>
        <% } %>
    </table>
    <p><a href="<%= request.getContextPath() %>/addProduct">Add New Product</a></p>
</body>
</html>