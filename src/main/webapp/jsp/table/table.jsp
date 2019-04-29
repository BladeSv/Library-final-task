<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="startUrl"  value="${pageContext.request.contextPath}"/>

<fmt:bundle basename="locale">
    <fmt:message key="index.login" var="login"/>
    <fmt:message key="index.registration" var="registration"/>
</fmt:bundle>

<head>



<link rel="stylesheet" type="text/css" href="${startUrl}/jsp/table/table.css" />
</head>

<table>
<tr>
  <th >Книги</th>
  
</tr>
<c:forEach items="${tableBooks}" var="book">
<tr>
  <td><p>${book.title}</p> <p>${book.autor}</p></td>
  <td>${book.annotatoin}</td>
  <td>${book.genre}</td>
  <td>1</td>
  <td>2500</td>
</tr>

</c:forEach>

<tr>
  <td>ddddddddddddddddd</td>
  <td>Платье с боковыми вставками</td>
  <td>3000</td>
  <td>1</td>
  <td>3000</td>
</tr>
<tr>
  <td>ddddddddddddddddd</td>
  <td>Платье с боковыми вставками</td>
  <td>3000</td>
  <td>1</td>
  <td>3000</td>
</tr>
<tr>
  <td>ddddddddddddddddd</td>
  <td>Платье с боковыми вставками</td>
  <td>3000</td>
  <td>1</td>
  <td>3000</td>
</tr>
</table>