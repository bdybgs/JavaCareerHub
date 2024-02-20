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
    <li>
        ${lecturer.getID()} ${lecturer.getName()} ${lecturer.getSurname()}
      <form style="display:inline" action="${pageContext.request.contextPath}/lecturer?action=delete" method="post">
        <input type="hidden" name="id" value="${lecturer.getID()}">
        <button type="submit">Delete</button>
      </form>
          <form style="display:inline" action="${pageContext.request.contextPath}/lecturer?action=edit" method="post">
          <input type="hidden" name="id" value="${lecturer.getID()}">
          <button type="submit">Edit</button>
      </form>
    </li>
  </c:forEach>
</ul>
<a href="${pageContext.request.contextPath}/lecturer?action=add">Add a New Lecturer</a>
</body>
</html>
