<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>All Lecturers</title>
</head>
<body>
<h1>All Lecturers</h1>
<ul>
  <c:forEach var="lecturer" items="${lecturers}">
    <li>${lecturer.name} - ${lecturer.surname}
      <a href="${pageContext.request.contextPath}/lecturer?action=update&id=${lecturer.getID()}">Update</a>

    </li>
  </c:forEach>
</ul>
<a href="${pageContext.request.contextPath}/lecturer?action=add">Add a New Lecturer</a>

</body>
</html>
