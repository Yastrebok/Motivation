<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Marks</title>
</head>
<body>
<table>
    <tr>
        <th>User</th>
        <th>Subject</th>
        <th>Marks</th>
        <th>Rate</th>
        <th>Date</th>
    </tr>
        <#list marksDao as mark>
        <tr>
            <td>${mark.user_id}</a></td>
            <td>${mark.subject_id}</td>
            <td>${mark.mark}</td>
            <td>${mark.rate}</td>
            <td>${mark.date}</td>
        </tr>
        </#list>
</table>

<br><br>
<a href="/allMarks/addMark/${user_id}">Add mark</a>
<br><br>
<a href="/users/all"> Back</a>
</body>
</html>