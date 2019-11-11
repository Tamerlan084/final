<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Player</title>
</head>
<body>
<jsp:include page="/WEB-INF/view/navbar.jsp"></jsp:include>
<ol class="game-list">
    <table>
        <caption>Game</caption>
        <tr>
            <td><li></li></td>
            <td><a href="games/${game.gameId}"><c:out value="${game.gameId}"/></a></td>
            <td><c:out value="${game.date}"/></td>
            <td><c:out value="${game.hostTeam}"/></td>
            <td><c:out value="${game.guestTeam}"/></td>
            <td><c:out value="${game.hostScore}"/></td>
            <td><c:out value="${game.guestScore}"/></td>
        </tr>
        <tr>
            <td><a href="${game.gameId}/update"><c:out value="edit"/></a></td>
            <td>
                <a href="${game.gameId}/delete"><c:out value="delete"/></a>
            </td>
        </tr>
    </table>
</ol>
<br/>
<br/>
<a href="players/new"><c:out value="Add new player"/></a>
</body>
</html>
