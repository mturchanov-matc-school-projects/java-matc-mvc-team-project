<%@ page import="java112.project3.TeamMVC.FlexPagination" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
          crossorigin="anonymous">
    <title>Document</title>
</head>
<body>
<h1>Output</h1>
<nav aria-label="Navigation for countries">

    <%--    <c:if test="${currentPage > 0}">--%>
    <%--        <a href="${pageContext.request.contextPath}/decrementPageServlet">Prev</a>--%>
    <%--    </c:if>--%>
    <%--    ${currentPage}--%>

    <%--        <a href="${pageContext.request.contextPath}/incrementPageServlet">Next</a>--%>

    <c:if test="${currentPage > 0}">
    <button>
        <a href="${pageContext.request.contextPath}/testTeamMVCServlet?currentPage=${currentPage - 1}&searchVal=${searchVal}">Prev</a>
        </c:if>

        <button>
            <a href="${pageContext.request.contextPath}/testTeamMVCServlet?currentPage=${1+currentPage}&searchVal=${searchVal}">Next</a>
        </button>

        <ul class="pagination">

        </ul>
</nav>
</nav>


<c:forEach items="${books}" var="book">
    <div>
        <p><c:out value="${book.title} - ${book.publisher}"/></p>
    </div>
</c:forEach>


${pages}


<c:set var="pages" value='FlexPagination.test(${currentPage}, ${books[0].totalItems}, ${searchVal})'/>



<%--${FlexPagination:test(currentPage, books[0].totalItems, searchVal)}--%>






</body>
</html>