<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Subject info</title>
</head>
<body>
<h1>Subject info</h1>
<table>
    <tr>
        <td>Id</td>
        <td>${subject.subject_id}</td>
    </tr>
    <tr>
        <td> Username</td>
        <td>${subject.subject_name}</td>
    </tr>
    <tr>
        <td> Rate</td>
        <td>${subject.rate}</td>
    </tr>
    <tr></tr>
</table>
<br><br>
<a href="/subjects/delete/${subject.subject_id}">Delete</a>
<br><br>
<a href="/menu">Menu</a>
</body>
</html>