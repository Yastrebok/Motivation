<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit user</title>
</head>
<body>
<form  name = "Username" action = "/updateUser" method="post">
    <p>Id</p>
    <input title="Id" type="text" name="id" value="${user.id}">
    <p>Username</p>
    <input title="Username" type="text" name="username" value="${user.username}">
    <p>Email</p>
    <input title="Email" type="text" name="email" value="${user.email}">
    <p>Age</p>
    <input title="Age" type="text" name="age" value="${user.age}">
    <input type="submit" value="OK">
</form>

</body>
</html>