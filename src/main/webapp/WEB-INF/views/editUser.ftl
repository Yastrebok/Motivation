<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit user</title>
</head>
<body>
<form name="Username" action="/motivation/users/update" method="post">
    <table>
        <tr>
            <td>Id</td>
            <td><input title="Id" type="text" name="id" value="${user.id}"></td>
        </tr>
        <tr>
            <td>Username</td>
            <td><input title="Username" type="text" name="username" value="${user.username}"></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input title="Email" type="text" name="email" value="${user.email}"></td>
        </tr>
        <tr>
            <td>Age</td>
            <td><input title="Age" type="text" name="age" value="${user.age}"></td>
        </tr>
    </table>


    <br>
    <input type="submit" value="OK">
    <a href="/motivation/users/all">Cancel </a><br>

</form>

</body>
</html>