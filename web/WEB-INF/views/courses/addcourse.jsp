<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Course</title>
</head>
<body>
<h1>Add a New Course</h1>
<form action="${pageContext.request.contextPath}/course?action=add" method="post">
    <label for="name">Course Name:</label>
    <input type="text" id="name" name="name" required><br>

    <label for="hours">Number of Hours:</label>
    <input type="number" id="hours" name="hours" required><br>

    <button type="submit">Add Course</button>
</form>
</body>
</html>
