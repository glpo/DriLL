<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Excavation</title>
</head>
<body>
<table width="600px">
    <tr>
        <td><b>1</b></td>
        <td><b>2</b></td>
        <td><b>3</b></td>
    </tr>
    <c:forEach var="exc" items="${excavation}">
        <tr>
            <td>${exc.id}</td>
            <td>${exc.time}</td>
            <td>${exc.exc}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>