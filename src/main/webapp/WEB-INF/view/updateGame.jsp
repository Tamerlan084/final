<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Update game</title>
</head>
<body>
<jsp:include page="/WEB-INF/view/navbar.jsp"></jsp:include>
<form:form id="updateGame" modelAttribute="updateGame" method="post" action="submit">
    <form:input type="date" path="date"/>
    <form:input path="hostTeam"/>
    <form:input path="guestTeam"/>
    <form:input path="hostScore"/>
    <form:input path="guestScore"/>
    <form:button value="submit" name="save"/>
</form:form>
</body>
</html>
