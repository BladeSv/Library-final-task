<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>


<fmt:bundle basename="locale">
	<fmt:message key="index.login" var="login" />
</fmt:bundle>

<c:set var="startUrl" value="${pageContext.request.contextPath}" />

<html>
<head>
<title>Library</title>
<link rel="stylesheet" href="${startUrl}/css/Header.css">

</head>
<body>

	<div class="main">
	
	
			 <jsp:include page="../header/GuestHeader.jsp"/>
		




	</div>


	
</body>
</html>
