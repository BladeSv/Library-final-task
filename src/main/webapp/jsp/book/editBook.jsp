<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>


<fmt:bundle basename="locale">
	<fmt:message key="page.book.edit.title" var="locTitle" />
	<fmt:message key="page.book.edit.book.title" var="locBTitle" />
	<fmt:message key="page.book.edit.book.annotation" var="locAnnotation" />
	<fmt:message key="page.book.edit.book.author" var="locAuthor" />
	<fmt:message key="page.book.edit.book.genre" var="locGenre" />
	<fmt:message key="page.book.edit.book.number" var="locNumber" />
	<fmt:message key="page.book.edit.book.update.button" var="locBUpdate" />
	<fmt:message key="page.book.edit.book.add.button" var="locBAdd" />
	<fmt:message key="page.book.edit.book.create.button" var="locBCreate" />
	<fmt:message key="page.book.edit.book.select" var="locSelect" />
	<fmt:message key="page.book.edit.book.wrongdate.message"
		var="locMessage" />
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


	<c:if test="${wrongBook== 'wrongBook'}">
				<h3 style="color: red">${locMessage}</h3>

			</c:if>
		<form action="/Library/main" method="post">

			<div class="box">
				<h4>${locBTitle}</h4>
				<input type="text" id="bookTitle" name="bookTitle"
					value="${changeBook.title}">
			</div>

			<div class="box">
				<h4>${locAuthor}</h4>

				<select name="bookAutor" required>
					<c:if test="${empty changeBook}">

						<option disabled="disabled" selected="selected" value="0">${locSelect}</option>

						<c:forEach items="${tableAuthor}" var="author">

							<option value="${author.id}">${author.name}
								${author.surname}</option>

						</c:forEach>

					</c:if>
					<c:if test="${not empty changeBook}">

						<c:forEach items="${tableAuthor}" var="author">

							<option value="${author.id}"
								<c:if test="${author.id==changeBook.author.id}">selected="selected"</c:if>>
								${author.name} ${author.surname}</option>

						</c:forEach>


					</c:if>

				</select> <br> <a href="${startUrl}/main?command=toCreateAuthor">${locBAdd}</a>



			</div>


			<div class="box">
				<h4>${locGenre}</h4>
				<select name="bookGenre">


					<c:if test="${empty changeBook}">

						<option disabled="disabled" selected="selected" value="0">${locSelect}</option>

						<c:forEach items="${tableGenre}" var="genre">

							<option value="${genre.id}">${genre.title}</option>

						</c:forEach>
					</c:if>

					<c:if test="${not empty changeBook}">

						<c:forEach items="${tableGenre}" var="genre">

							<option
								<c:if test="${genre.id==changeBook.genre.id}">selected="selected"</c:if>
								value="${genre.id}">${genre.title}</option>


						</c:forEach>


					</c:if>


				</select> <br> <a href="${startUrl}/main?command=toCreateGenre">${locBAdd}</a>

			</div>


			<div class="box">
				<h4>${locNumber}</h4>
				<input type="number" name="bookNumber" value="${changeBookNumber}">
			</div>

			<div class="box">
				<h4>${locAnnotation}</h4>
				<textarea name="bookAnnotation" rows="10" cols="60">
			${changeBook.annotation}
			</textarea>
			</div>

			<c:if test="${empty changeBook}">
				<input type="hidden" name="command" value="createBook" />
				<button type="submit">${locBCreate}</button>
			</c:if>
			<c:if test="${not empty changeBook}">
				<input type="hidden" name="command" value="updateBook" />
				<input type="hidden" name="id" value="${changeBook.id}" />
				<button type="submit">${locBUpdate}</button>
			</c:if>
		</form>



<jsp:include page="../footer/footer.jsp"/>
	</div>



</body>
</html>
