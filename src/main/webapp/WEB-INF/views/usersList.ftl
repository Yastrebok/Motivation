<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Users</title>
</head>
<body>
<h1>Users list</h1>

<table>
    <tr>
        <th>Id</th>
        <th>Username</th>
        <th>Email</th>
        <th>Age</th>
    </tr>
        <#list users as user>
        <tr>
            <td><a href="/user/${user.id}"> ${user.id}</a></td>
            <td>${user.username}</td>
            <td>${user.email}</td>
            <td>${user.age}</td>
            <td><a href="/delete/${user.id}">Delete</a> </td>
            <td><a href="/update/${user.id}">Edit</a> </td>
        </tr>
        </#list>

</table>

<a href="menu.ftl">Menu</a>
</body>
</html>