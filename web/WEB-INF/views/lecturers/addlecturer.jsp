<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Add Lecturer</title>
</head>
<body>
<h1>Add Lecturer</h1>
<form action="${pageContext.request.contextPath}/lecturer?action=add" method="post">
  <label for="name">Name:</label>
  <input type="text" id="name" name="name" required><br>

  <label for="surname">Surname:</label>
  <input type="text" id="surname" name="surname" required><br>

  <button type="submit">Add Lecturer</button>
</form>
</body>
</html>
