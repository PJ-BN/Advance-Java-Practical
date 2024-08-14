<%@ page import="java.util.List" %>
<%@ page import="com.example.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of Users</title>
</head>
<body>
    <h2>List of Users</h2>
    <a href="users?action=new">Add New User</a>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
        <%
            List<User> userList = (List<User>) request.getAttribute("listUser");
            if (userList != null) {
                for (User user: userList) {
        %>
            
                <tr>
                    <td><%= user.getId() %></td>
                    <td><%= user.getName() %></td>
                    <td><%= user.getEmail() %></td>
                    <td>
                        <a href="users?action=edit&id=<%= user.getId() %>">Edit</a>
                        <a href="users?action=delete&id=<%= user.getId() %>" onclick="return confirm('Are you sure?')">Delete</a>
                    </td>
                </tr>
            <%
            }
        } else {
        %>
        <tr>
            <td colspan="5"> No users found.</td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</body>
</html>
