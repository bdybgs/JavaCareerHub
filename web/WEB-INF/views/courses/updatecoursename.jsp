<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Course Name</title>
</head>
<body>
<h2>Update Course Name</h2>
<form action="${pageContext.request.contextPath}/course" method="post">
    <input type="hidden" name="action" value="updateName">
    <input type="hidden" name="id" value="${course.getID()}">
    <label for="name">New Name:</label>
    <input type="text" id="name" name="name" value="${course.getName()}">
    <button type="submit">Update Name</button>
</form>
<br>
<a href="${pageContext.request.contextPath}/course?action=all">Back to All Courses</a>
</body>
</html>
