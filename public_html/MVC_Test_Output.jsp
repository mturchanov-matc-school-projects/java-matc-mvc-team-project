<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MVC Test</title>
</head>
<body>
<%@ taglib prefix="a" uri="http://java.sun.com/jsp/jstl/core" %>

<a:forEach items="${books}" var="book">
    <div>
        <p><a:out value="${book.title} - ${book.publisher}"/></p>
    </div>
</a:forEach>

</body>

</html>