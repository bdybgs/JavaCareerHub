<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>All Courses</title>
</head>
<body>
<h1>All Courses</h1>
<ul>
    <c:forEach var="course" items="${courses}">
        <li>
                ${course.getID()} ${course.getName()} - ${course.getHours()} hours
            <form style="display:inline" action="${pageContext.request.contextPath}/course" method="post">
                <input type="hidden" name="action" value="edit">
                <input type="hidden" name="id" value="${course.getID()}">
                <button type="submit">Edit</button>
            </form>
            <form style="display:inline" action="${pageContext.request.contextPath}/course?action=delete" method="post">
                <input type="hidden" name="id" value="${course.getID()}">
                <button type="submit">Delete</button>
            </form>
        </li>
    </c:forEach>
</ul>
<a href="${pageContext.request.contextPath}/course?action=add">Add a New Course</a>
</body>
</html>
