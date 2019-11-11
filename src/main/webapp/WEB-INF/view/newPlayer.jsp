<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Add new team</title>
</head>
<body>
<jsp:include page="/WEB-INF/view/navbar.jsp"></jsp:include>
<form:form id="addPlayer" modelAttribute="newPlayer" method="post" action="submit">
    <form:input path="name"/>
    <form:input path="team"/>
    <form:input path="position"/>
    <form:input path="skillLevel"/>
    <form:button value="submit" name="save"/>
</form:form>
</body>
</html>
