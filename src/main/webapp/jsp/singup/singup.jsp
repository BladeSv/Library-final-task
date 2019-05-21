<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>


<fmt:bundle basename="locale">
	<fmt:message key="singup.singup" var="singup" />
	<fmt:message key="singup.title" var="title" />
	<fmt:message key="singup.login" var="login" />
	<fmt:message key="singup.login.placeholder" var="plogin" />
	<fmt:message key="singup.password" var="password" />
	<fmt:message key="singup.password.placeholder" var="ppassword" />
	<fmt:message key="singup.name" var="name" />
	<fmt:message key="singup.name.placeholder" var="pname" />
		<fmt:message key="singup.surname" var="surname" />
		<fmt:message key="singup.surname.placeholder" var="psurname" />
	<fmt:message key="singup.button" var="button" />
	<fmt:message key="singup.worng.data.message" var="message" />

</fmt:bundle>

<c:set var="startUrl" value="${pageContext.request.contextPath}" />

<html>

<head>
<title>${singup}</title>

<link rel="stylesheet" type="text/css"
	href="${startUrl}/jsp/singup/css/singup.css">
</head>
<body>
 <jsp:include page="../header/GuestHeader.jsp"/>
	<form action="/Library/main" method="post">
		<div class="container">
			<h1>${singup}</h1>
			<c:if test="${wrongsingup== 'wrongsingup'}">
						<span  style="color:red"> ${message} </span>
						
					</c:if>
			<h3>${title}</h3>
			<hr>

			<label for="login"><b>${login}</b></label> <input type="text"
				placeholder="${plogin}" name="login" required> <label
				for="psw"><b>${password}</b></label> <input type="password"
				placeholder="${ppassword}" name="password" required> <label
				for="psw-repeat"><b>${name}</b></label> <input type="text"
				placeholder="${pname}" name="name" required>
				<label for="psw-repeat"><b>${surname}</b></label> <input type="text"
				placeholder="${psurname}" name="surmame" required>
				
			<hr>

			<input type="hidden" name="command" value="singup">
			<button type="submit" class="registerbtn">${button}</button>
		</div>

	</form>

</body>
</html>