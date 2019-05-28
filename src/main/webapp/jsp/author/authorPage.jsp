<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>


<fmt:bundle basename="locale">
	<fmt:message key="page.author.title" var="locTitle" />
	<fmt:message key="page.author.author.name" var="locName" />
	<fmt:message key="page.author.author.surname" var="locSurname" />	
	<fmt:message key="page.author.author.update" var="locUpdate" />
	<fmt:message key="page.author.author.update.button" var="locBUpdate" />
	<fmt:message key="page.author.author.delete" var="locDelete" />
	<fmt:message key="page.author.author.delete.button" var="locBDelete" />
	<fmt:message key="page.author.author.add.button" var="locBAdd" />




</fmt:bundle>





<c:set var="startUrl" value="${pageContext.request.contextPath}" />

<html>
<head>
<title>${locTitle}</title>
<link rel="stylesheet" href="${startUrl}/jsp/author/author.css">

</head>
<body>

	<div class="main">


		<jsp:include page="../header/GuestHeader.jsp" />

		
		
			
		<div class="table-conteiner">
		<table style="width: 200px">
			<tr>
				<th>${locName}</th>
				<th>${locSurname}</th>
							<c:if test="${role == 'admin'}">
					<th>${locUpdate}</th>
					<th>${locDelete}</th>
				</c:if>

			</tr>
		<c:forEach items="${tableAuthor}" var="autor">
		<tr style="height: 100px">
		<td>${autor.name}</td>
		<td>${autor.surname}</td>
			<c:if test="${role == 'admin'}">


						<td style="width: 50px">
							<form action="/Library/main" method="post">
								<input type="hidden" name="command" value="toUpdateAuthor" /> 
								<input	type="hidden" name="id" value="${autor.id}" />
								<button type="submit">${locBUpdate}</button>
							</form>
						</td>
						<td style="width: 50px">
							<form action="/Library/main" method="post">
								<input type="hidden" name="command" value="deteteAuthor" /> <input
									type="hidden" name="id" value="${autor.id}" />
								<button type="submit">${locBDelete}</button>
							</form>
							</td>
					</c:if>
		
		
		
		</tr>
		
		</c:forEach>
			</table>
	
		
			<c:if test="${role == 'admin'}">
			<form action="/Library/main" method="post">
			<input type="hidden" value="toCreateAuthor" name="command">
	<button type="submit" class="registerbtn">${locBAdd}</button>
			</form>

		</c:if>
			
		</div>
		
	



	</div>



</body>
</html>
