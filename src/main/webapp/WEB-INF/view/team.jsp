<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="/WEB-INF/view/navbar.jsp"></jsp:include>
<table>
    <caption><c:out value="${team.team}"/></caption>
        <tr>
            <td><c:out value="${team.city}"/></td>
            <td><c:out value="${team.coach}"/></td>
            <td><c:out value="${team.captainName}"/></td>
        </tr>
        <tr>
            <td><a href="${team.team}/update"><c:out value="edit"/></a></td>
            <td>
                <a href="${team.team}/delete"><c:out value="delete"/></a>
            </td>
        </tr>
</table>
</body>
</html>
