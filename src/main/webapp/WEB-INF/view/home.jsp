<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" type="text/css" href="/WEB-INF/css/table.css">
</head>
<body>
<ol class="teams-list">
    <table>
        <caption>Турнирная таблица</caption>
        <c:forEach var="team" items="${teams}">
        <tr>
            <td><li></li></td>
            <td><c:out value="${team.team}"/></td>
        </tr>
        </c:forEach>
    </table>
</ol>
<br/>
<a href="teams"><c:out value="Show all teams"/></a>
<br/>
<ol class="players-list">
    <table>
        <caption>Игроки с наибольшим количеством штрафов</caption>
        <c:forEach var="player" items="${players}">
            <tr>
                <td><li></li></td>
                <td><c:out value="${player.name}"/></td>
            </tr>
        </c:forEach>
    </table>
</ol>
<br/>
<a href="players"><c:out value="Show all players"/></a>
<br/>
<ol class="games-list">
    <table>
        <caption>Крайние пять игр</caption>
        <tr>
            <td>№</td>
            <td>Дата</td>
            <td>Гость</td>
            <td>Хозяин</td>
            <td>Гости забили</td>
            <td>Хозяева забили</td>
        </tr>
        <c:forEach var="game" items="${games}">
            <tr>
                <td><li></li></td>
                <td><c:out value="${game.date}"/></td>
                <td><c:out value="${game.guestTeam}"/></td>
                <td><c:out value="${game.hostTeam}"/></td>
                <td><c:out value="${game.guestScore}"/></td>
                <td><c:out value="${game.hostScore}"/></td>
            </tr>
        </c:forEach>
    </table>
    <br/>
    <a href="games"><c:out value="Show all games"/></a>
</ol>
</body>
</html>
