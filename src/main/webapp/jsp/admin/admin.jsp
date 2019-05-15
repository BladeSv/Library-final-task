
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    
<c:set var="startUrl"  value="${pageContext.request.contextPath}"/>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${startUrl}/jsp/admin/admin.css">
</head>
<body>

 <jsp:include page="../header/GuestHeader.jsp"/>
  <div class="layout">
  <div class="sidebar">
   <ul>
    <li>Главная</li><li>Все коктейли</li><li>Коллекции</li>
    <li>Бокалы</li><li>Компоненты</li><li>Фичи</li>
   </ul>
  </div>
  <div class="content">

   <h1>Яблочный эг-ног</h1>
   <p>Молоко — 40 мл, сок яблочный — 100 мл, сироп сахарный — 30 мм,
   один яичный желток.</p>
   <p>Приготовить напиток в миксере, подать в бокале хайбол 
   со льдом и соломинкой.</p>
  </div>
  <div class="footer">&copy; Приготовление коктейлей</div>
 </div>
</body>
</html>