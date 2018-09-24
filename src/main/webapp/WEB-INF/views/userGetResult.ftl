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
    <br><br>
    <tr>
        <td>Month</td>
        <td>Price</td>
    </tr>
    <#list userResult as result>
        <tr>
            <td>${result.month}</td>
            <td>${result.sum}</td>
        </tr>
    </#list>
    <tr></tr>
</table>

<br><br>
<a href="/motivation/users/all/">Back </a>
<br><br>
<a href="/motivation/menu">Menu</a>
</body>
</html>