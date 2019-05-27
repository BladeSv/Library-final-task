<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="pag" uri="pagination" %>
<c:set var="startUrl"  value="${pageContext.request.contextPath}"/>

<fmt:bundle basename="locale">
    <fmt:message key="table.user.id" var="locUserId"/>
    <fmt:message key="table.user.name" var="locName"/>
     <fmt:message key="table.user.surname" var="locSurname"/>
     <fmt:message key="table.user.order" var="locOrder"/>
        <fmt:message key="table.user.order.button" var="locBOrder"/>   
      <fmt:message key="table.user.update" var="locUpdate"/> 
          <fmt:message key="table.user.update.button" var="locBUpdate"/>    
       <fmt:message key="table.user.delete" var="locDelete"/>
       <fmt:message key="table.user.delete.button" var="locBDelete"/>
</fmt:bundle>



<head>

<link rel="stylesheet" type="text/css" href="${startUrl}/jsp/table/table.css" />
</head>
<div class="table-conteiner">

<table>
<tr>
  <th >${locUserId}</th>
  <th >${locName}</th>
  <th >${locSurname}</th>
   <c:if test="${role == 'admin'}">	
    <th >${locOrder}</th>
   <th >${locUpdate}</th>
   <th >${locDelete}</th>
   </c:if>
</tr>
<c:if test="${not empty tableUsers}">


<c:forEach items="${tableUsers}" var="tuser">
<tr style="height:50px">
  <td style="width:200px;">${tuser.id}</td>
  <td style="width:200px; text-align: center;">${tuser.name}</td>
  <td>${tuser.surname}</td>
  <c:if test="${role == 'admin'}">		
  
  <td style=" width:50px"  >		 
<form action="/Library/main" method="post">
    <input type="hidden" name="command" value="toOrder" />
     <input type="hidden" name="id" value="${tuser.id}" />
    <button type="submit">${locBOrder} </button>
</form>
		</td>  
  
		<td style=" width:50px"  >		 
<form action="/Library/main" method="post">
    <input type="hidden" name="command" value="updateUser" />
     <input type="hidden" name="id" value="${tuser.id}" />
    <button type="submit">${locBUpdate} </button>
</form>
		</td>
		<td style=" width:50px"  >		 
<form action="/Library/main" method="post">
    <input type="hidden" name="command" value="deteteUser" />
     <input type="hidden" name="id" value="${tuser.id}" />
    <button type="submit">${locBDelete} </button>
</form>
	
		</c:if>
  
</tr>

</c:forEach>
</c:if>
<c:if test="${empty tableUsers} ">
	<tr> 
   <td colspan="6" > <br/></td>
  </tr>

</c:if>
</table>
 

<pag:pagination maxPage="${maxPage}" paginationUrl="${paginationUrl}" numberPage="${numberPage}"/>
 


 
</div>