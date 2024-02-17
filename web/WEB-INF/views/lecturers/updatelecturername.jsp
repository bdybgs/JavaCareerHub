<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Lecturer Name</title>
</head>
<body>
<h1>Edit Lecturer Name</h1>
<form action="${pageContext.request.contextPath}/lecturer?action=updateName" method="post">
    <input type="hidden" name="id" value="${lecturer.id}">
    <label for="name">Lecturer Name:</label>
    <input type="text" id="name" name="name" value="${lecturer.name}" required><br>

    <button type="submit">Update Lecturer Name</button>
</form>
</body>
</html>
