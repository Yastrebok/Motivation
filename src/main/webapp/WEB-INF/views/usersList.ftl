<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <title>Users</title>

</head>
<body>
<a role="button" class="btn btn-primary"  href="/motivation/menu" >Menu</a>
<a role="button" class="btn btn-secondary" href="/motivation/users/addUser">New User</a>


<h1>Users list</h1>
<table class="table table-striped">
    <thead>
    <tr>
        <th>Id</th>
        <th>Username</th>
        <th>Email</th>
        <th>Age</th>
    </tr>
    </thead>
    <tbody>
        <#list users as user>
        <tr>
            <td><a href="/motivation/users/user/${user.id}"> ${user.id}</a></td>
            <td><a href="/motivation/users/user/${user.id}">${user.username}</a></td>
            <td>${user.email}</td>
            <td>${user.age}</td>
            <td><a href="/motivation/users/update/${user.id}"> Edit </a></td>
            <td><a href="/motivation/allMarks/${user.id}"> Marks </a></td>
            <td><a href="/motivation/users/${user.id}/sum"> Result </a></td>
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