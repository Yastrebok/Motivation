<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <title>Subjects</title>
</head>
<body>

<a role="button" class="btn btn-primary"  href="/motivation/menu" >Menu</a>
<a role="button" class="btn btn-secondary" href="/motivation/subjects/newSubject">New suject</a>

<h1>Subject list</h1>
<table class="table table-striped">
    <thead>
    <tr>
        <th>Id</th>
        <th>Subject</th>
        <th>Rate</th>
    </tr>
    </thead>
    <tbody>
        <#list subjects as subject>
        <tr>
            <td><a href="/motivation/subjects/subject/${subject.subjectId}"> ${subject.subjectId}</a></td>
            <td>${subject.subjectName}</td>
            <td>${subject.rate}</td>
            <td><a href="/motivation/subjects/update/${subject.subjectId}">Edit</a></td>
        </tr>
        </#list>
    </tbody>
</table>

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