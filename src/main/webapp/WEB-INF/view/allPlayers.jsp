<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All players</title>
</head>
<body>
<jsp:include page="/WEB-INF/view/navbar.jsp"></jsp:include>
<ol class="players-list">
    <table>
        <caption>All players</caption>
        <c:forEach var="player" items="${players}">
            <tr>
                <td><li></li></td>
                <td><a href="players/${player.playerId}"><c:out value="${player.name}"/></a></td>
                <td><c:out value="${player.team}"/></td>
                <td><c:out value="${player.position}"/></td>
                <td><c:out value="${player.skillLevel}"/></td>
            </tr>
        </c:forEach>
    </table>
</ol>
<br/>
<br/>
<a href="players/new"><c:out value="Add new team"/></a>
</body>
</html>
