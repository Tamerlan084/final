<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Update team</title>
</head>
<body>
<jsp:include page="/WEB-INF/view/navbar.jsp"></jsp:include>
<form:form id="updateTeam" modelAttribute="updateTeam" method="post" action="submit">
    <form:input path="team"/>
    <form:input path="city"/>
    <form:input path="coach"/>
    <form:input path="captain"/>
    <form:button value="submit" name="save"/>
</form:form>
</body>
</html>
