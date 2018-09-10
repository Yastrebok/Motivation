<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User result</title>
</head>
<body>
<h1>User result</h1>
<table>
    <tr>
        <td> Username</td>
        <td>${user_name}</td>
    </tr>
    <tr>
        <td>Month </td><br><br>
        <td>Price </td>
    </tr>
    <#list userResult as result>
        <tr>
            <td>${result.month}</td><br><br>
            <td>${result.sum}</td><br><br>
        </tr>
    </#list>


    <tr></tr>
</table>

<br><br>
<a href="/users/all/">Back </a>
<br><br>
<a href="/menu">Menu</a>
</body>
</html>