<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Marks</title>
</head>
<body>
<form name="Username" action="/allMarks/addMark" method="post">


    <p>User</p>
    <input title="User_id" type="text" name="user_id">
    <p>Subject</p>
    <input title="Subject_id" type="text" name="subject_id">
    <p>Marks</p>
    <input title="Mark" type="text" name="mark">
    <p>Rate</p>
    <input title="Rate" type="text" name="rate">
    <p>Date</p>
    <input title="Date" type="date" name="timestamp">
    <br><br>
    <a href="/menu">Cancel </a><br>

    <input type="submit" value="OK">

</form>

</body>
</html>