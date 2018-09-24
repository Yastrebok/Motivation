<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Marks</title>
</head>
<body>
<h1>New mark for ${userName}</h1>
<form name="Username" action="/motivation/allMarks/addMark" method="post">
    <table>
        <tr>
            <td>User :</td>
            <td><input title="UserName" type="text" name="userName" value=${userName}></td>
        </tr>
        <td><input title="UserId" type="hidden" name="userId" value=${userId}></td>
        <tr>
            <td>Subject :</td>
            <td><select name="subjectId" >
                <#list listSubject as tmplattribute>
                    <option  value="${tmplattribute.subjectId}"> ${tmplattribute.subjectName}</option>
                </#list>
            </select></td>
        </tr>
        <tr>
            <td>Marks :</td>
            <td><select name="mark" >
                <#list listMarks as mark>
                    <option  value="${mark}"> ${mark}</option>
                </#list>
            </select></td>
        </tr>
        <tr>
            <td>Date of receipt :</td>
            <td><input title="Date" type="date" name="month"></td>
        </tr>
    </table>


    <br><br>
    <a href="/motivation/menu">Cancel </a><br>

    <input type="submit" value="OK">

</form>

</body>
</html>