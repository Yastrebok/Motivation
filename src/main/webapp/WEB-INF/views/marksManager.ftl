<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Marks</title>
</head>
<body>
<table>
    <tr>
        <th>Date</th>
        <th>Subject</th>
        <th>Marks</th>
    </tr>
        <#list marksDao as mark>
        <tr>
            <td>${mark.month}</td>
            <td>${mark.subjectName}</td>
            <td>${mark.mark}</td>
        </tr>
        </#list>
</table>

<br><br>
<a href="/allMarks/addMark/${userId}">Add mark</a>
<br><br>
<a href="/users/all"> Back</a>
</body>
</html>