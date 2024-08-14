<html>
<head>
    <title>Add New User</title>
</head>
<body>
    <h2>Add New User</h2>
    <form action="users?action=insert" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name"><br>
        <label for="email">Email:</label>
        <input type="text" id="email" name="email"><br>
        <input type="submit" value="Submit">
    </form>
    <a href="users">Back to list</a>
</body>
</html>
