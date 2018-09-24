<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User info</title>
</head>
<body>
<h1>User info</h1>
<table>
    <tr>
        <td>Id</td>
        <td>${user.id}</td>
    </tr>
    <tr>
        <td> Username</td>
        <td>${user.username}</td>
    </tr>
    <tr>
        <td> Email</td>
        <td>${user.email}</td>
    </tr>
    <tr>
        <td> Age</td>
        <td>${user.age}</td>
    </tr>
    <tr></tr>
</table>
<br>
<a href="/motivation/users/all">Back <br></a>
<br>
<a href="/motivation/users/delete/${user.id}">Delete</a>
</body>
</html>