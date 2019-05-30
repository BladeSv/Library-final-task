<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<fmt:bundle basename="locale">
	<fmt:message key="order.table.title" var="title" />
	<fmt:message key="order.table.user.name" var="Uname" />
	<fmt:message key="order.table.user.book" var="Obook" />
	<fmt:message key="order.table.book.place" var="Oplace" />
	<fmt:message key="order.table.date.taken" var="Odate" />
	<fmt:message key="order.table.book.title" var="Tbook" />
	<fmt:message key="order.table.book.author" var="Abook" />
	<fmt:message key="order.table.date.on.confirm" var="Odconfirm" />
	<fmt:message key="order.table.checkbox.cancel.confirm" var="CCancelConfirm" />
	<fmt:message key="order.table.checkbox.choose.confirm" var="CChooseConfirm" />
	<fmt:message key="order.table.checkbox.return" var="CReturnBook" />
<fmt:message key="order.admin.button.reset" var="Areset" />
<fmt:message key="order.admin.button" var="Abutton" />
	<fmt:message key="order.button" var="button" />

</fmt:bundle>



<c:set var="startUrl" value="${pageContext.request.contextPath}" />

<html>
<head>
<title>${title}</title>

<link rel="stylesheet"  type="text/css"  href="${startUrl}/jsp/order/orderS.css">
</head>
<body>

	<div class="main">

		
			<jsp:include page="../header/header.jsp" />
		




		<div class="table-conteiner">
			<form name="takeChange" method="post" action="/Library/main">
				<table>
					<tr>
						<th>${Uname}</th>
						<th>${Obook}</th>
						<th>${Oplace}</th>
						<th>${Odate}</th>
						<c:if test="${role == 'user'}">
							<th>${pchoose}</th>
							<th>${scheck}</th>
						</c:if>

						<c:if test="${role == 'admin'}">
							<th>${pchoose}</th>
							<th>${scheck}</th>
						</c:if>

					</tr>
					<c:if test="${role == 'user'}">
							<c:set var="currentUser" value="${sessionScope.user}" />
						</c:if>
						<c:if test="${role == 'admin'}">
							<c:set var="currentUser" value="${orderUser}" />
						</c:if>
					<c:forEach items="${currentUser.takenOrder}" var="order">

						<tr>
							<td style="width: 100px">${orderUser.name} ${orderUser.surname}</td>


							<td style="width: 300px"><p>${Tbook}:${order.book.title}</p>
								<p>${Abook}:${order.book.author.name} ${order.book.author.surname}</p></td>
							<td style="width: 150px">${order.place}</td>
							
							
							<c:if test="${order.takenDate == null and role == 'user'}">
								<c:set var="checkDelete" value="true" />
								<td style="width: 200px">${Oconfirm}<Br> <input
									type="checkbox" name="checkOrderDelete" value="${order.id}">
								</td>
									</c:if>
								
							<c:if test="${order.takenDate == null and role == 'admin'}">
													
								<td style="width: 200px">${CCancelConfirm}<Br> <input
									type="radio"  name="notConfirmOrder" value="checkOrderDelete-${order.id}">
								</td>
								<td style="width: 200px">${CChooseConfirm}<Br> <input
									type="radio"  name="notConfirmOrder" value="checkOrderConfirm-${order.id}">
								</td>
								
							</c:if>

							<c:if test="${order.takenDate != null}">
								<td style="width: 200px"><fmt:formatDate type="date"
										value="${order.takenDate}" /></td>

							</c:if>
							
							<c:if test="${order.takenDate != null and role == 'admin'}">
									<td style="width: 200px">${CReturnBook}<Br> <input
									type="checkbox" name="checkBookReturn" value="${order.id}">
								</td>

							</c:if>
							
						</tr>

					</c:forEach>

				</table>
				<c:if test="${role == 'user' and checkDelete=='true'}">
					<input type="hidden" value="deleteOrder" name="command">

					<button type="submit" class="registerbtn">${button}</button>
				</c:if>
				
				<c:if test="${role == 'admin'}">
					<input type="hidden" value="adminOrder" name="command">
					<input type="hidden" name="id" value="${orderUser.id}" >
					<button type="submit" class="registerbtn">${Abutton}</button>
					<button type="reset" class="registerbtn">${Areset}</button>
				</c:if>
			</form>
		</div>

<jsp:include page="../footer/footer.jsp"/>

	</div>



</body>
</html>
