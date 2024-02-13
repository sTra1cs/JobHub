<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customers List</title>
</head>
<body>
<h2>List of Customers</h2>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Full Name</th>
        <th>Email</th>
        <th>Actions</th>
    </tr>
    <%@ page import="java.util.List" %>
    <%@ page import="com.jobhub.model.Customer" %>
    <%
        List<Customer> customers = (List<Customer>) request.getAttribute("customers");
        for (Customer customer : customers) {
    %>
    <tr>
        <td><%= customer.getId() %></td>
        <td><%= customer.getName() %></td>
        <td><%= customer.getEmail() %></td>
        <td>
            <a href="customer?action=edit&id=<%= customer.getId() %>">Edit</a>
            &nbsp;
            <a href="customer?action=delete&id=<%= customer.getId() %>" onclick="return confirm('Are you sure?')">Delete</a>
        </td>
    </tr>
    <% } %>
</table>
<br>
<a href="customer?action=add">Add New Customer</a>
</body>
</html>