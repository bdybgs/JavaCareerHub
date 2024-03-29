<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Course</title>
</head>
<body>
<h2>Edit Course</h2>
<form action="${pageContext.request.contextPath}/course" method="post">
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="id" value="${course.getID()}">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" value="${course.getName()}">
    <br>
    <label for="hours">Hours:</label>
    <input type="text" id="hours" name="hours" value="${course.getHours()}">
    <br>
    <button type="submit">Update Course</button>
</form>
<br>
<a href="${pageContext.request.contextPath}/course?action=all">Back to All Courses</a>
</body>
</html>
