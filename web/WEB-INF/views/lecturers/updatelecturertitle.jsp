<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Edit Lecturer Title</title>
</head>
<body>
<h1>Edit Lecturer Title</h1>
<form action="${pageContext.request.contextPath}/lecturer?action=updateTitle" method="post">
  <input type="hidden" name="id" value="${lecturer.id}">
  <label for="title">Lecturer Title:</label>
  <input type="text" id="title" name="title" value="${lecturer.title}" required><br>

  <button type="submit">Update Lecturer Title</button>
</form>
</body>
</html>
