<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Delete Course</title>
</head>
<body>
<h1>Delete Course</h1>
<form action="${pageContext.request.contextPath}/course?action=delete" method="post">
  <input type="hidden" name="id" value="${course.getID()}">
  <p>Are you sure you want to delete the course "${course.getName()}"?</p>

  <button type="submit">Delete Course</button>
</form>
</body>
</html>
