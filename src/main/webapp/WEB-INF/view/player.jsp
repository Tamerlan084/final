<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Player</title>
</head>
<body>
<jsp:include page="/WEB-INF/view/navbar.jsp"></jsp:include>
<ol class="players-list">
    <table>
        <caption>Player</caption>
            <tr>
                <td><li></li></td>
                <td><c:out value="${player.name}"/></td>
                <td><c:out value="${player.team}"/></td>
                <td><c:out value="${player.position}"/></td>
                <td><c:out value="${player.skillLevel}"/></td>
            </tr>
        <tr>
            <td><a href="${player.playerId}/update"><c:out value="edit"/></a></td>
            <td>
                <a href="${player.playerId}/delete"><c:out value="delete"/></a>
            </td>
        </tr>
    </table>
</ol>
<br/>
<br/>
<a href="players/new"><c:out value="Add new player"/></a>
</body>
</html>
