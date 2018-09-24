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
        <td>${subject.subjectId}</td>
    </tr>
    <tr>
        <td> Username</td>
        <td>${subject.subjectName}</td>
    </tr>
    <tr>
        <td> Rate</td>
        <td>${subject.rate}</td>
    </tr>
    <tr></tr>
</table>
<br><br>
<a href="/motivation/subjects/delete/${subject.subjectId}">Delete</a>
<br><br>
<a href="/motivation/menu">Menu</a>
</body>
</html>