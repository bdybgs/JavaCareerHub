<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Course Hours</title>
</head>
<body>
<h1>Update Course Hours</h1>
<form action="${pageContext.request.contextPath}/course?action=updateHours" method="post">
    <input type="hidden" name="id" value="${course.getID()}">
    <label for="hours">Number of Hours:</label>
    <input type="number" id="hours" name="hours" value="${course.getHours()}" required><br>

    <button type="submit">Update Course Hours</button>
</form>
</body>
</html>
