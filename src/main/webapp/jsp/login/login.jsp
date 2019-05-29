<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<c:set var="startUrl" value="${pageContext.request.contextPath}" />

<fmt:bundle basename="locale">
	<fmt:message key="login.title" var="title" />
	<fmt:message key="login.login" var="login" />
	<fmt:message key="login.password" var="password" />
	<fmt:message key="login.button" var="button" />
	<fmt:message key="login.singup" var="singup" />
	<fmt:message key="login.worng.data.message" var="message" />

</fmt:bundle>

<html>
<head>
<title>${title}</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
<link rel="icon" type="image/png" href="${startUrl}/jsp/login/images/icons/favicon.ico" />
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="${startUrl}/jsp/login/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="${startUrl}/jsp/login/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="${startUrl}/jsp/login/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="${startUrl}/jsp/login/vendor/animate/animate.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="${startUrl}/jsp/login/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="${startUrl}/jsp/login/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="${startUrl}/jsp/login/vendor/select2/select2.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="${startUrl}/jsp/login/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="${startUrl}/jsp/login/css/util.css">
<link rel="stylesheet" type="text/css" href="${startUrl}/jsp/login/css/main.css">
<!--===============================================================================================-->
</head>
<body>
 <jsp:include page="../header/header.jsp"/>
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100 p-l-85 p-r-85 p-t-55 p-b-55">
				<form class="login100-form validate-form flex-sb flex-w"
					action="/Library/main" method="post">
				<c:if test="${wronglogin== 'wronglogin'}">
						<span class="login100-form-title p-b-64" style="color:red"> ${message} </span>
						
					</c:if>

					<span class="login100-form-title p-b-32"> ${title} </span>
					 <span	class="txt1 p-b-11"> ${login} </span>
					<div class="wrap-input100 validate-input m-b-36"
						data-validate="Username is required">
						<input class="input100" type="text" name="login"> <span
							class="focus-input100"></span>
					</div>

					<span class="txt1 p-b-11"> ${password} </span>
					<div class="wrap-input100 validate-input m-b-12"
						data-validate="Password is required">
						<span class="btn-show-pass"> <i class="fa fa-eye"></i>
						</span> <input class="input100" type="password" name="password">
						<span> </span>
					</div>

					<div class="flex-sb-m w-full p-b-48"></div>

					<div class="container-login100-form-btn">


						<div class="flex-sb-m w-full p-b-48">


							<div>
								<a href="${startUrl}/jsp/singup/singup.jsp" class="txt3">
									${singup} </a>
							</div>
						</div>
						<input type="hidden" value="login" name="command">
						<button class="login100-form-btn" type="submit">
							${button}</button>
					</div>

				</form>
				<div></div>
			</div>
		</div>
	</div>


	<div id="dropDownSelect1"></div>

	<!--===============================================================================================-->
	<script src="${startUrl}/jsp/login/vendor/jquery/jquery-3.2.1.min.js"></script>
	<!--===============================================================================================-->
	<script src="${startUrl}/jsp/login/vendor/animsition/js/animsition.min.js"></script>
	<!--===============================================================================================-->
	<script src="${startUrl}/jsp/login/vendor/bootstrap/js/popper.js"></script>
	<script src="${startUrl}/jsp/login/vendor/bootstrap/js/bootstrap.min.js"></script>
	<!--===============================================================================================-->
	<script src="${startUrl}/jsp/login/vendor/select2/select2.min.js"></script>
	<!--===============================================================================================-->
	<script src="${startUrl}/jsp/login/vendor/daterangepicker/moment.min.js"></script>
	<script src="${startUrl}/jsp/login/vendor/daterangepicker/daterangepicker.js"></script>
	<!--===============================================================================================-->
	<script src="${startUrl}/jsp/login/vendor/countdowntime/countdowntime.js"></script>
	<!--===============================================================================================-->
	<script src="${startUrl}/jsp/login/js/main.js"></script>

</body>
</html>