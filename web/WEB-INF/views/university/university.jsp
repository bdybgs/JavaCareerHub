<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Main Page</title>
</head>
<body>
<h1>Main Page</h1>
<ul>
    <li><a href="${pageContext.request.contextPath}/course">Courses</a></li>
    <li><a href="${pageContext.request.contextPath}/lecturer">Lecturers</a></li>
    <li><a href="${pageContext.request.contextPath}/lecturer?showCourses=true">Lecturers with courses</a></li>
</ul>
</body>
</html>
