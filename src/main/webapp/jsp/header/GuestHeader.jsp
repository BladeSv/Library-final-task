<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="startUrl"  value="${pageContext.request.contextPath}"/>

<fmt:bundle basename="locale">
    <fmt:message key="index.login" var="login"/>
    <fmt:message key="index.registration" var="registration"/>
     <fmt:message key="index.order" var="order"/>
     <fmt:message key="index.logout" var="logout"/>
      <fmt:message key="index.page.admin" var="admin"/>
     
</fmt:bundle>
<head>



<link rel="stylesheet" type="text/css" href="${startUrl}/jsp/header/Header.css" />
</head>


<div class="header">
  <a href="${startUrl}/main" class="logo">Library</a>
    
  <div class="header-right">
<c:if test="${role == 'admin'}">	

 
 	  <form name="goToOrder" method="post" action="main">
	  <input type="hidden" name="command" value="userSearch">	  
    <button type="submit" class="orderbtn">${admin}</button>
</form>
 
 
</c:if>
  <c:if test="${role == 'user' or role == 'admin'}">	
  
	
	  <form name="goToOrder" method="post" action="main">
	  <input type="hidden" name="command" value="toOrder">
	  <input type="hidden" name="id" value="${user.id}">
    <button type="submit" class="orderbtn">${order}</button>
</form>
	  
	  
	  
	 <a href="${startUrl}/main" class="logo"> ${sessionScope.user.name}</a>
	<a href="${startUrl}/main?command=logout" >${logout}</a>
			
		</c:if>
    <a href="jsp/login/login.jsp">${login}</a>
    <a href="jsp/singup/singup.jsp">${registration}</a>
  </div>
  
  

			
	
</div>
