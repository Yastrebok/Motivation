<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Subjects</title>
</head>
<body>
<h1>Subject list</h1>

<table>
    <tr>
        <th>Id</th>
        <th>Subject</th>
        <th>Rate</th>
    </tr>
        <#list subjects as subject>
        <tr>
            <td><a href="/subjects/subject/${subject.subject_id}"> ${subject.subject_id}</a></td>
            <td>${subject.subject_name}</td>
            <td>${subject.rate}</td>
            <br>
            <td><a href="/subjects/update/${subject.subject_id}">Edit</a></td>
        </tr>
        </#list>

</table>
<br>
<a href="/menu">Menu</a>
<br><br>
<a href="/subjects/newSubject">New suject</a>
</body>
</html>