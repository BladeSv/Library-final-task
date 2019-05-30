<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>


<fmt:bundle basename="locale">
	<fmt:message key="page.book.title" var="locTitle" />
	<fmt:message key="page.book.book.title" var="locBTitle" />
	<fmt:message key="page.book.book.annotation" var="locAnnotation" />
	<fmt:message key="page.book.book.author" var="locAuthor" />
	<fmt:message key="page.book.book.genre" var="locGenre" />
	<fmt:message key="page.book.book.empty" var="locEmpty" />
</fmt:bundle>





<c:set var="startUrl" value="${pageContext.request.contextPath}" />

<html>
<head>
<title>${locTitle}</title>
<link rel="stylesheet" href="${startUrl}/jsp/book/book.css">

</head>
<body>

	<div class="main">


		<jsp:include page="../header/header.jsp" />
		<c:if test="${not empty viewBook}">


			<div class="box">
				<h4>${locBTitle}</h4>
				<p>${viewBook.title}</p>
			</div>
			<div class="box">
				<h4>${locAuthor}</h4>
				<p>${viewBook.author.name} ${viewBook.author.surname}</p>
			</div>
			<div class="box">
				<h4>${locGenre}</h4>
				<p>${viewBook.genre.title}</p>
			</div>
			<div class="box">
				<h4>${locAnnotation}</h4>
				<p>${viewBook.annotation}</p>
			</div>
		</c:if>
		<c:if test="${ empty viewBook}">

			<h3>${locEmpty}</h3>
		</c:if>

		<jsp:include page="../footer/footer.jsp" />
	</div>



</body>
</html>
