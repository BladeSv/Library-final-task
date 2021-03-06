
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<fmt:bundle basename="locale">
	<fmt:message key="admin.page.title" var="title" />
	<fmt:message key="admin.sidebar.button.books" var="BBooks" />
	<fmt:message key="admin.sidebar.button.genres" var="BGenres" />
	<fmt:message key="admin.sidebar.button.authors" var="BAuthors" />
	<fmt:message key="admin.sidebar.button.not.confirm" var="BNotConfirm" />

</fmt:bundle>

<c:set var="startUrl" value="${pageContext.request.contextPath}" />


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${startUrl}/jsp/admin/admin.css">
</head>
<body>

	<jsp:include page="../header/header.jsp" />
	<jsp:include page="../search/userSearch.jsp" />
	<div class="layout">

		<div class="sidebar">
			<ul>
				<li>
					<form method="post" action="main">
						<input type="hidden" name="command" value="search">
						<button type="submit" class="orderbtn">${BBooks}</button>
					</form>
				</li>
				<li>
					<form method="post" action="main">
						<input type="hidden" name="command" value="toAuthor">
						<button type="submit" class="orderbtn">${BAuthors}</button>
					</form>
				</li>
				<li>
					<form method="post" action="main">
						<input type="hidden" name="command" value="toGenre">
						<button type="submit" class="orderbtn">${BGenres}</button>
					</form>

				</li>
				<li>
					<form method="post" action="main">
						<input type="hidden" name="command" value="deleteOrderNotConfirm">
						<button type="submit" class="orderbtn">${BNotConfirm}</button>
					</form>

				</li>
			</ul>
		</div>
		<div class="content">
			<jsp:include page="../table/userTable.jsp" />




		</div>

		<jsp:include page="../footer/footer.jsp" />
	</div>
</body>
</html>