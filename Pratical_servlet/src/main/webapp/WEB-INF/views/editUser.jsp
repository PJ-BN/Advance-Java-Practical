<html>
<head>
    <title>Edit User</title>
</head>
<body>
    <h2>Edit User</h2>
    <form action="users?action=update" method="post">
        <input type="hidden" name="id" value="${user.id}">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${user.name}"><br>
        <label for="email">Email:</label>
        <input type="text" id="email" name="email" value="${user.email}"><br>
        <input type="submit" value="Submit">
    </form>
    <a href="users">Back to list</a>
</body>
</html>
