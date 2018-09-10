<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Marks</title>
</head>
<body>
<form name="Username" action="/allMarks/addMark" method="post">

    <table>
        <tr>
            <td>User :</td>
            <td><input title="User_id" type="text" name="user_id" value=${user_id}></td>
        </tr>
        <tr>
            <td>Subject :</td>
            <td><select name="subject_id">
                <#list listSubject as tmplattribute>
                    <option value="${tmplattribute.subjectId}">${tmplattribute.subjectName}</option>
                </#list>
            </select></td>
        </tr>
        <tr>
            <td>Marks :</td>
            <td><input title="Mark" type="text" name="mark"></td>
        </tr>
        <tr>
            <td>Date of receipt :</td>
            <td><input title="Date" type="date" name="date"></td>
        </tr>
    </table>


    <br><br>
    <a href="/menu">Cancel </a><br>

    <input type="submit" value="OK">

</form>

</body>
</html>