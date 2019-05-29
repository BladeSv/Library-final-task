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

<link rel="stylesheet" href="${startUrl}/jsp/footer/footer.css">

</head>
 <footer class="footer">&copy; Приготовление коктейлей</footer>
