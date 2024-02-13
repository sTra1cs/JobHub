<%@ page import="com.jobhub.model.Customer" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add/Edit Customer</title>
</head>
<body>
<%
    String action = "add";
    Customer customer = null;
    if (request.getAttribute("customer") != null) {
        customer = (Customer) request.getAttribute("customer");
        action = "update";
    }
%>
<h2><%= action.equals("add") ? "Add New" : "Edit" %> Customer</h2>
<form action="customer" method="post">
    <% if (action.equals("update")) { %>
    <input type="hidden" name="id" value="<%= customer.getId() %>" />
    <% } %>
    Full Name: <input type="text" name="name" value="<%= customer != null ? customer.getName() : "" %>" /><br />
    Email: <input type="email" name="email" value="<%= customer != null ? customer.getEmail() : "" %>" /><br />
    <input type="hidden" name="action" value="<%= action %>" />
    <input type="submit" value="<%= action.equals("add") ? "Add" : "Update" %> Customer" />
</form>
</body>
</html>