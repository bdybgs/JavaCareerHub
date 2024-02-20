<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Lecturer Name</title>
</head>
<body>
<h1>Update Lecturer Name</h1>
<form action="${pageContext.request.contextPath}/lecturer?action=updateName" method="post">
    <input type="hidden" name="id" value="${lecturer.getID()}">
    <label for="name">New Name:</label>
    <input type="text" id="name" name="name" value="${lecturer.getName()}" required>
    <button type="submit">Update Name</button>
</form>
</body>
</html>
