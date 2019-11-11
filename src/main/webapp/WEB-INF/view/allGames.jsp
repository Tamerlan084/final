<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All games</title>
</head>
<body>
<jsp:include page="/WEB-INF/view/navbar.jsp"></jsp:include>
<ol class="games-list">
    <table>
        <caption>All games</caption>
        <c:forEach var="game" items="${games}">
            <tr>
                <td><li></li></td>
                <td><a href="games/${game.gameId}"><c:out value="${game.gameId}"/></a></td>
                <td><c:out value="${game.date}"/></td>
                <td><c:out value="${game.hostTeam}"/></td>
                <td><c:out value="${game.guestTeam}"/></td>
                <td><c:out value="${game.hostScore}"/></td>
                <td><c:out value="${game.guestScore}"/></td>
            </tr>
        </c:forEach>
    </table>
</ol>
<br/>
<br/>
<a href="games/new"><c:out value="Add new game"/></a>
</body>
</html>
