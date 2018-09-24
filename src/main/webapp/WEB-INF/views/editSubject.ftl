<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Subject</title>
</head>
<body>
<form name="Subject name" action="/motivation/subjects/update" method="post">
    <p>Id</p>
    <input title="Subject Id" type="text" name="subject_id" value="${subject.subjectId}">
    <p>Subject name</p>
    <input title="Subject name" type="text" name="subject_name" value="${subject.subjectName}">
    <p>Rate</p>
    <input title="Rate" type="text" name="rate" value="${subject.rate}">
    <br><br>
    <input type="submit" value="OK">
    <a href="/motivation/subjects/all">Cancel </a>



</form>

</body>
</html>