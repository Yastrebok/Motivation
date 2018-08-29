<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Subject</title>
</head>
<body>
<form name="Subject name" action="/subjects/update" method="post">
    <p>Id</p>
    <input title="Subject Id" type="text" name="subject_id" value="${subject.subject_id}">
    <p>Subject name</p>
    <input title="Subject name" type="text" name="subject_name" value="${subject.subject_name}">
    <p>Rate</p>
    <input title="Rate" type="text" name="rate" value="${subject.rate}">
    <br>
    <a href="/subjects/all">Cancel </a>
    <br>
    <input type="submit" value="OK">

</form>

</body>
</html>