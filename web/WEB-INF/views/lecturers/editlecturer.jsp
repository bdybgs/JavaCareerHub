<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Lecturer</title>
</head>
<body>
<h2>Edit Lecturer</h2>
<form action="${pageContext.request.contextPath}/lecturer" method="post">
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="id" value="${lecturer.getID()}">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" value="${lecturer.getName()}">
    <br>
    <label for="surname">Surname:</label>
    <input type="text" id="surname" name="surname" value="${lecturer.getSurname()}">
    <br>
    <button type="submit">Update Lecturer</button>
</form>
<br>
<a href="${pageContext.request.contextPath}/lecturer?action=all">Back to All Lecturers</a>
</body>
</html>
