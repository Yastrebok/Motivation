<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <title>Marks</title>
</head>
<body>
<h1>New mark for ${userName}</h1>
<form name="Username" action="/motivation/allMarks/addMark" method="post">
    <table class="table table-striped">
        <tbody>
        <tr>
            <td>User :</td>
            <td><input title="UserName" type="text" name="userName" value=${userName}></td>
        </tr>
        <td><input title="UserId" type="hidden" name="userId" value=${userId}></td>
        <tr>
            <td>Subject :</td>
            <td><select name="subjectId">
                <#list listSubject as tmplattribute>
                    <option value="${tmplattribute.subjectId}"> ${tmplattribute.subjectName}</option>
                </#list>
            </select></td>
        </tr>
        <tr>
            <td>Marks :</td>
            <td><select name="mark">
                <#list listMarks as mark>
                    <option value="${mark}"> ${mark}</option>
                </#list>
            </select></td>
        </tr>
        <tr>
            <td>Date of receipt :</td>
            <td><input title="Date" type="date" name="month"></td>
        </tr>
        </tbody>
    </table>


    <br><br>
    <a href="/motivation/menu">Cancel </a><br>

    <input type="submit" value="OK">

</form>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
        integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
</body>
</html>