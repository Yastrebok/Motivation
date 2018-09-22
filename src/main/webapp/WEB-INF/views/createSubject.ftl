<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create user</title>
</head>
<body>
<form  name = "Subject name" action = "/subjects/newSubject" method="post">
    <p>Username</p>
    <input title="Subject name" type="text" name="subjectName">
    <p>Rate</p>
    <input title="Rate" type="text" name="rate">
    <br>
    <a href="/subjects/all">Cancel </a>
    <br>
    <input type="submit" value="OK">
</form>


</body>
</html>