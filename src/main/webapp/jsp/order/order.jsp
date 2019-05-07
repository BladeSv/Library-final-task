<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>


<fmt:bundle basename="locale">
	<fmt:message key="order.table.title" var="title" />
	<fmt:message key="order.table.user.name" var="Uname" />
	<fmt:message key="order.table.user.book" var="Obook" />
	<fmt:message key="order.table.book.place" var="Oplace" />
	<fmt:message key="order.table.date.taken" var="Odate" />
	<fmt:message key="order.table.book.title" var="Tbook" />
	<fmt:message key="order.table.book.autor" var="Abook" />
	<fmt:message key="order.table.date.on.confirm" var="Oconfirm" />
</fmt:bundle>
order.table.title=Order
order.table.user.name=User name
order.table.book.title=Book title
order.table.book.autor=Book autor
order.table.book.place=The place where you took the book
order.table.date.taken=Date taken
order.table.date.on.confirm=Confirmation request


<c:set var="startUrl" value="${pageContext.request.contextPath}" />

<html>
<head>
<title>${title}</title>
<link rel="stylesheet" href="${startUrl}/css/Header.css">

</head>
<body>

	<div class="main">
	
		<c:if test="${role == 'guest'}">		
			 <jsp:include page="../header/GuestHeader.jsp"/>
		</c:if>
		<c:if test="${role == 'user'}">	
		<jsp:include page=../header/GuestHeader.jsp"/>	
			 ${user.name}<br>
			
		</c:if>
<div class="table-order-conteiner">
 <form name="takeChange" method="post" action="/Library/main">
<table>
<tr>
  <th >${Uname}</th>
  <th >${Obook}</th>
  <th >${Oplace}</th>
    <th >${Odate}</th>
   <c:if test="${role == 'user'}">	
   <th >${pchoose}</th>
   <th >${scheck}</th>
   </c:if>
</tr>
<c:forEach items="${sessionScope.user.takenOrder}" var="order">

<tr >
  <td>${sessionScope.user.name}</td>
  
  
  <td ><p>${Tbook}:${order.book.title}</p><p>${Abook}:${order.book.autor.name} ${order.book.autor.surname}</p></td>
  <td>${order.place}</td>
  <c:if test="${order.takenDate == null}">		
		<td >		 
  <td>${Oconfirm}</td>
		</td>
		
		</c:if>
   <c:if test="${order.takenDate != null}">		
		<td >		 
  <td>${order.takenDate}</td>
		</td>
		
		</c:if>
</tr>

</c:forEach>

</table>
 <c:if test="${role == 'user'}">	
<input type="hidden" value="createOrder" name="command">

<button type="submit" class="registerbtn"> ${button}</button>
</c:if>
 </form>
</div>



	</div>


	</br> Hello Worlddsdsddsddddddddddddd ${login}
	</br> ${role}
</body>
</html>
