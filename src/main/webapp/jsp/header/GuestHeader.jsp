<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="startUrl"  value="${pageContext.request.contextPath}"/>

<fmt:bundle basename="locale">
    <fmt:message key="index.login" var="login"/>
    <fmt:message key="index.registration" var="registration"/>
     <fmt:message key="index.order" var="order"/>
</fmt:bundle>
<head>



<link rel="stylesheet" type="text/css" href="${startUrl}/jsp/header/Header.css" />
</head>


<div class="header">
  <a href="${startUrl}/" class="logo">Library</a>
    
  <div class="header-right">

  <c:if test="${role == 'user'}">	
	  <a href="${startUrl}/main?command=оrder" class="logo">${order}</a>
	
			
		</c:if>
    <a href="jsp/login/login.jsp">${login}</a>
    <a href="jsp/singup/singup.jsp">${registration}</a>
  </div>
  
</div>
