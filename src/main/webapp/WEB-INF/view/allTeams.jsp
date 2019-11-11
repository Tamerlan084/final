<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All teams</title>
</head>
<body>
<jsp:include page="/WEB-INF/view/navbar.jsp"></jsp:include>
<ol class="teams-list">
    <table>
        <caption>Турнирная таблица</caption>
        <c:forEach var="team" items="${teams}">
            <tr>
                <td><li></li></td>
                <td><a href="teams/${team.team}"><c:out value="${team.team}"/></a></td>
            </tr>
        </c:forEach>
    </table>
</ol>
<br/>
<br/>
<a href="teams/new"><c:out value="Add new team"/></a>
</body>
</html>
