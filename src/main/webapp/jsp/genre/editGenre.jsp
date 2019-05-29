<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>


<fmt:bundle basename="locale">
	<fmt:message key="page.genre.edit.title" var="locTitle" />
	<fmt:message key="page.genre.edit.genre.title" var="locGenre" />

	<fmt:message key="page.genre.edit.genre.update.button" var="locBUpdate" />

	<fmt:message key="page.genre.edit.genre.create.button" var="locBCreate" />
<fmt:message key="page.genre.edit.genre.wrongdate.message" var="locMessage" />



</fmt:bundle>

<c:set var="startUrl" value="${pageContext.request.contextPath}" />

<html>
<head>
<title>${locTitle}</title>
<link rel="stylesheet" href="${startUrl}/css/Header.css">

</head>
<body>

	<div class="main">


		<jsp:include page="../header/header.jsp" />

		<form action="/Library/main" method="post">
		
<c:if test="${wrongGenre== 'wrongGenre'}">
		<h3 style="color:red">${locMessage} </h3>

</c:if>
<br>
			<label for="genreTitleid">${locGenre}</label> <input type="text"
				id="genreTitleid" name="genreTitle" value="${changeGenre.title}">

			<c:if test="${empty changeGenre}">
				<input type="hidden" name="command" value="createGenre" />
				<button type="submit">${locBCreate}</button>
			</c:if>
			<c:if test="${not empty changeGenre}">
				<input type="hidden" name="command" value="updateGenre" />
					<input type="hidden" name="id" value="${changeGenre.id}" />
				<button type="submit">${locBUpdate}</button>
			</c:if>
			
		</form>




	</div>



</body>
</html>
