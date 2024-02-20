<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Update Lecturer Surname</title>
</head>
<body>
<h1>Update Lecturer Surname</h1>
<form action="${pageContext.request.contextPath}/lecturer?action=updateSurname" method="post">
  <input type="hidden" name="id" value="${lecturer.getID()}">
  <label for="surname">Surname:</label>
  <input type="text" id="surname" name="surname" value="${lecturer.getSurname()}" required><br>

  <button type="submit">Update Lecturer Surname</button>
</form>
</body>
</html>
