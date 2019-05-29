<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="pag" uri="pagination"%>
<c:set var="startUrl" value="${pageContext.request.contextPath}" />

<fmt:bundle basename="locale">
	<fmt:message key="table.book.books" var="books" />
	<fmt:message key="table.book.author" var="author" />
	<fmt:message key="table.book.annotation" var="annotation" />
	<fmt:message key="table.book.genre" var="genre" />
	<fmt:message key="table.book.update" var="locUpdate" />
	<fmt:message key="table.book.update.button" var="locBUpdate" />
	<fmt:message key="table.book.delete" var="locDelete" />
	<fmt:message key="table.book.delete.button" var="locBDelete" />
	<fmt:message key="table.book.choose.place" var="pchoose" />
	<fmt:message key="table.book.out" var="out" />
	<fmt:message key="table.book.hall" var="hall" />
	<fmt:message key="table.book.check" var="scheck" />
	<fmt:message key="table.book.button" var="button" />
	<fmt:message key="table.book.add.button" var="locAbutton" />

</fmt:bundle>

<head>

<link rel="stylesheet" type="text/css"
	href="${startUrl}/jsp/table/table.css" />
</head>
<div class="table-conteiner">
<form method="get" action="/Library/main">
	<table>
		<tr>
			<th>${books}</th>
			<th>${annotation}</th>
			<th>${genre}</th>
			<c:if test="${role == 'user'}">
				<th>${pchoose}</th>
				<th>${scheck}</th>
			</c:if>
			<c:if test="${role == 'admin'}">
				<th>${locUpdate}</th>
				<th>${locDelete}</th>
			</c:if>

		</tr>
		<c:forEach items="${tableBooks}" var="book">
			<tr style="height: 100px">

				<td style="width: 200px;"><a
					href="${startUrl}/main?command=toBook&id=${book.id}"
					style="color: white">
						<p>${book.title}</p>
						<p>${author}:${book.author.name} ${book.author.surname}</p>
				</a></td>
				<td style="width: 600px;">${book.annotation}</td>
				<td>${book.genre.title}</td>
				<c:if test="${role == 'user'}">
					<td style="text-align: left, width:200px"><input type="radio"
						name="place-${book.id}" value="out" checked> ${out}<Br>
						<input type="radio" name="place-${book.id}" value="hall">
						${hall}<Br></td>
					<td style="width: 50px"><input type="checkbox"
						name="checkBookOrder" value="${book.id}"><Br></td>
				</c:if>

				<c:if test="${role == 'admin'}">


					<td style="width: 50px">
						<form action="/Library/main" method="post">
							<input type="hidden" name="command" value="toUpdateBook" /> <input
								type="hidden" name="id" value="${book.id}" />
							<button type="submit">${locBUpdate}</button>
						</form>
					</td>
					<td style="width: 50px">
						<form action="/Library/main" method="post">
							<input type="hidden" name="command" value="deteteBook" /> <input
								type="hidden" name="id" value="${book.id}" />
							<button type="submit">${locBDelete}</button>
						</form>
				</c:if>



			</tr>

		</c:forEach>

	</table>
	<c:if test="${role == 'user'}">
		<form method="get" action="/Library/main">
			<input type="hidden" value="createOrder" name="command">

			<button type="submit" class="registerbtn">${button}</button>
		</form>
	</c:if>
	<c:if test="${role == 'admin'}">
		<form method="get" action="/Library/main">
			<input type="hidden" value="toCreateBook" name="command">

			<button type="submit" class="registerbtn">${locAbutton}</button>
		</form>
	</c:if>



	<pag:pagination maxPage="${maxPage}" paginationUrl="${paginationUrl}"
		numberPage="${numberPage}" />




</div>