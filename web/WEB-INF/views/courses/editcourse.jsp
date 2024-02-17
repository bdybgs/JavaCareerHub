<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Course</title>
</head>
<body>
<h1>Edit Course</h1>
<form action="${pageContext.request.contextPath}/course?action=update" method="post">
    <input type="hidden" name="id" value="${course.getID()}">
    <label for="name">Course Name:</label>
    <input type="text" id="name" name="name" value="${course.getName()}" required><br>

    <label for="hours">Number of Hours:</label>
    <input type="number" id="hours" name="hours" value="${course.getHours()}" required><br>

    <button type="submit">Update Course</button>
</form>
</body>
</html>
