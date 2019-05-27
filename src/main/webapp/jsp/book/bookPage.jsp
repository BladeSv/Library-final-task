<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>


<fmt:bundle basename="locale">
	<fmt:message key="page.book.title" var="locTitle" />
	<fmt:message key="page.book.book.title" var="locBTitle" />
	<fmt:message key="page.book.book.annotation" var="locAnnotation" />
	<fmt:message key="page.book.book.autor" var="locAutor" />
	<fmt:message key="page.book.book.genre" var="locGenre" />
	<fmt:message key="page.book.book.number" var="locNumber" />
	<fmt:message key="page.book.book.button.create" var="locCBButton" />

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
			<input type="hidden" name="command" value="createBook" /> 
			
			<label for="bookTitle">${locBTitle}</label>
			<input type="text" id="bookTitle" name="bookTitle">
			
			<label for="bookAutor">${locAutor}</label>
			<input type="text" id="bookAutor" name="bookAutor">
			
			<label for="bookGenre">${locGenre}</label>
			<input type="text" id="bookGenre" name="bookGenre">
			
			<label for="bookNumber">${locNumber}</label>
			<input type="number" id="bookNumber" name="bookNumber">
			
			<label for="bookAnnotation">${locAnnotation}</label>
			<textarea name="bookAnnotation" rows="10" cols="30" id="bookAnnotation">

			</textarea>
			
			
			<button type="submit">${locCBButton}</button>
		</form>




	</div>



</body>
</html>
