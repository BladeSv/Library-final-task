<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="startUrl"  value="${pageContext.request.contextPath}"/>

<fmt:bundle basename="locale">
    <fmt:message key="table.books" var="books"/>
    <fmt:message key="table.autor" var="autor"/>
     <fmt:message key="table.annotation" var="annotation"/>
      <fmt:message key="table.genre" var="genre"/>
      
       <fmt:message key="table.choose.place" var="pchoose"/>
       <fmt:message key="table.out" var="out"/>
       <fmt:message key="table.hall" var="hall"/>
        <fmt:message key="table.check" var="scheck"/>
      <fmt:message key="table.button" var="button"/>
</fmt:bundle>

<head>

<link rel="stylesheet" type="text/css" href="${startUrl}/jsp/table/table.css" />
</head>
<div class="table-conteiner">
 <form name="takeOrder" method="post" action="/Library/main">
<table>
<tr>
  <th >${books}</th>
  <th >${annotation}</th>
  <th >${genre}</th>
   <c:if test="${role == 'user'}">	
   <th >${pchoose}</th>
   <th >${scheck}</th>
   </c:if>
</tr>
<c:forEach items="${tableBooks}" var="book">
<tr style="height:100px">
  <td style="width:200px;"><p>${book.title}</p> <p>${autor}:${book.autor.name} ${book.autor.surname}</p></td>
  <td style="width:700px;">${book.annotation}</td>
  <td>${book.genre}</td>
  <c:if test="${role == 'user'}">		
		<td style=" text-align:left, width:100px"  >		 
<input type="radio" name="place-${book.id}" value="out"> ${out}<Br>
 <input type="radio" name="place-${book.id}" value="hall"> ${hall}<Br>
		</td>
		<td style=" width:50px"  >		 
 <input type="checkbox" name="checkOrder" value="${book.id}"><Br> 
		</td>
		</c:if>
  
</tr>

</c:forEach>

</table>
<input type="hidden" value="createOrder" name="command">
<button type="submit" class="registerbtn"> ${button}</button>
 </form>
</div>