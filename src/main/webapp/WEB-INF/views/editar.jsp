<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Torcedor</title>
</head>
<body>

	<form:form method="POST" modelAttribute="torcedor" action="../update/${id}">
		<p>Nome: <form:input path="nome" /></p>
		<p>Time: <form:input path="time" /></p>
		<p><form:button>Enviar</form:button></p>
		<p>${mensagem}</p>
	</form:form>

</body>
</html>