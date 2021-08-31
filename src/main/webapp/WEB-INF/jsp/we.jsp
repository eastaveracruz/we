<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Word Generator</title>
</head>
<body>
<c:url var="add_book_url" value="/generator"/>
<form:form action="${add_book_url}" method="post" modelAttribute="params">
    <form:label path="letters">LETTERS: </form:label> <form:input type="text" path="letters"/>
    <input type="submit" value="submit"/>
</form:form>

<table>
    <thead>
    <tr>
        <th>WORDS</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${words}" var="word">
        <tr>
            <td>${word}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>