<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>


<fmt:bundle basename="locale">
	<fmt:message key="index.title" var="title" />
</fmt:bundle>

<c:set var="startUrl" value="${pageContext.request.contextPath}" />

<html>
<head>
<title>${title}</title>

</head>
<body>

	<div class="main">


		<jsp:include page="header/header.jsp" />


		<div>
			<jsp:include page="search/search.jsp" />
		</div>
		<div>
			<jsp:include page="table/table.jsp" />
		</div>

		<jsp:include page="/jsp/footer/footer.jsp" />
	</div>


</body>
</html>
