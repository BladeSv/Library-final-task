<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>


<fmt:bundle basename="locale">
	<fmt:message key="page.genre.title" var="locTitle" />
	<fmt:message key="page.genre.genre.title" var="locGenre" />
	<fmt:message key="page.genre.genre.update" var="locUpdate" />
	<fmt:message key="page.genre.genre.update.button" var="locBUpdate" />
	<fmt:message key="page.genre.genre.delete" var="locDelete" />
	<fmt:message key="page.genre.genre.delete.button" var="locBDelete" />
	<fmt:message key="page.genre.genre.add.button" var="locBAdd" />




</fmt:bundle>

<c:set var="startUrl" value="${pageContext.request.contextPath}" />

<html>
<head>
<title>${locTitle}</title>
<link rel="stylesheet" href="${startUrl}/jsp/genre/genre.css">

</head>
<body>

	<div class="main">


		<jsp:include page="../header/GuestHeader.jsp" />

		
		
			
		<div class="table-conteiner">
		<table style="width: 200px">
			<tr>
				<th>${locGenre}</th>
							<c:if test="${role == 'admin'}">
					<th>${locUpdate}</th>
					<th>${locDelete}</th>
				</c:if>

			</tr>
		<c:forEach items="${tableGenre}" var="genre">
		<tr style="height: 100px">
		<td>${genre.title}</td>
			<c:if test="${role == 'admin'}">


						<td style="width: 50px">
							<form action="/Library/main" method="post">
								<input type="hidden" name="command" value="toUpdateGenre" /> 
								<input	type="hidden" name="id" value="${genre.id}" />
								<button type="submit">${locBUpdate}</button>
							</form>
						</td>
						<td style="width: 50px">
							<form action="/Library/main" method="post">
								<input type="hidden" name="command" value="deteteGenre" /> <input
									type="hidden" name="id" value="${genre.id}" />
								<button type="submit">${locBDelete}</button>
							</form>
							</td>
					</c:if>
		
		
		
		</tr>
		
		</c:forEach>
			</table>
	
		
			<c:if test="${role == 'admin'}">
			<form action="/Library/main" method="post">
			<input type="hidden" value="toCreateGenre" name="command">
	<button type="submit" class="registerbtn">${locBAdd}</button>
			

		</c:if>
			
		</div>
		</form>
	



	</div>



</body>
</html>
