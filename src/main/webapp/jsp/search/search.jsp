<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="startUrl"  value="${pageContext.request.contextPath}"/>

<fmt:bundle basename="locale">
    <fmt:message key="index.login" var="login"/>
    <fmt:message key="index.registration" var="registration"/>
</fmt:bundle>
<head>



<link rel="stylesheet" type="text/css" href="${startUrl}/jsp/search/styles.css" />
</head>
 <form id="searchForm" method="get" action="/Library/main">
		<fieldset>
        
           	<input id="search" type="text" name="search"/>
            
            <input type="submit" value="Submit" id="submitButton" />
            <input type="hidden" value="search" name="command"/>
            <div id="searchInContainer">
                <input type="radio" name="check" value="site" id="searchSite" checked />
                <label for="searchSite" id="siteNameLabel">Seadsdh</label>
                
                <input type="radio" name="check" value="web" id="searchWeb" />
                <label for="searchWeb">Search The Web</label>
			</div>
                        
            
            
        </fieldset>
    </form>
   
<script src="${startUrl}/jsp/search/script.js"></script>
