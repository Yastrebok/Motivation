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
            <td><a href="/users/user/${user.id}"> ${user.id}</a></td>
            <td>${user.username}</td>
            <td>${user.email}</td>
            <td>${user.age}</td>
            <br>
            <td><a href="/users/update/${user.id}"> Edit  </a> </td>
            <br>
            <td><a href="/allMarks/${user.id}"> Marks  </a> </td>
            <br>
            <td><a href="/users/${user.id}/sum"> Result  </a> </td>
        </tr>
        </#list>

</table>
<br>
<a href="/menu">Menu</a>
<br><br>
<a href="/users/addUser">New User</a>
</body>
</html>