	<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>


<fmt:bundle basename="locale">
	<fmt:message key="page.author.edit.title" var="locTitle" />
	<fmt:message key="page.author.edit.author.name" var="locName" />
	<fmt:message key="page.author.edit.author.surname" var="locSurname" />
	
	<fmt:message key="page.author.edit.author.update.button" var="locBUpdate" />

	<fmt:message key="page.author.edit.author.create.button" var="locBCreate" />
	<fmt:message key="page.author.edit.author.wrongdate.message"
		var="locMessage" />



</fmt:bundle>

<c:set var="startUrl" value="${pageContext.request.contextPath}" />

<html>
<head>
<title>${locTitle}</title>
<link rel="stylesheet" href="${startUrl}/css/Header.css">

</head>
<body>

	<div class="main">


		<jsp:include page="../header/GuestHeader.jsp" />

		<form action="/Library/main" method="post">

			<c:if test="${wrongAuthor== 'wrongAuthor'}">
				<h3 style="color: red">${locMessage}</h3>

			</c:if>
			<br> <label for="autorNameId">${locName}</label> <input
				type="text" id="autorNameId" name="authorName"
				value="${changeAuthor.name}"> <br><br>
				 <label	for="autorSurnameId">${locSurname}</label>
				  <input type="text" id="autorSurnameId" name="authorSurname"
				value="${changeAuthor.surname}">
<br><br>
			<c:if test="${empty changeAuthor}">
				<input type="hidden" name="command" value="createAuthor" />
				<button type="submit">${locBCreate}</button>
			</c:if>
			<c:if test="${not empty changeAuthor}">
				<input type="hidden" name="command" value="updateAuthor" />
				<input type="hidden" name="id" value="${changeAuthor.id}" />
				<button type="submit">${locBUpdate}</button>
			</c:if>

		</form>




	</div>



</body>
</html>
