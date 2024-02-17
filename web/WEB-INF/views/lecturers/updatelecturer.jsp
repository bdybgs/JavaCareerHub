<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Lecturer</title>
</head>
<body>
<h1>Update Lecturer</h1>
<form action="${pageContext.request.contextPath}/lecturer?action=update" method="post">
    <input type="hidden" name="id" value="${lecturer.getID()}">

    <label for="name">Lecturer Name:</label>
    <input type="text" id="name" name="name" value="${lecturer.name}" required><br>

    <label for="surname">Lecturer Surname:</label>
    <input type="text" id="surname" name="surname" value="${lecturer.surname}" required><br>

    <button type="submit">Update Lecturer</button>
</form>
</body>
</html>
