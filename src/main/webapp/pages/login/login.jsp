<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<link rel="stylesheet" href=<c:url value="/template/css/bootstrap.css"/>>
<link rel="stylesheet"
	href=<c:url value="/template/css/font-awesome.min.css"/>>
<link rel="stylesheet" href=<c:url value="/template/css/font.css"/>>
<link rel="stylesheet" href=<c:url value="/template/css/style.css"/>>
<link rel="stylesheet" href=<c:url value="/template/css/plugin.css"/>>
<link rel="stylesheet" href=<c:url value="/template/css/landing.css"/>>
<link rel="stylesheet" href=<c:url value="/template/css/mycss.css"/>>

<!-- datepicker -->
<script
	src=<c:url value="/template/js/datepicker/bootstrap-datepicker.js"/>></script>
<!-- / footer -->
<script src=<c:url value="/template/js/jquery.min.js"/>></script>
<!-- Bootstrap -->
<script src=<c:url value="/template/js/bootstrap.js"/>></script>
<!-- app -->
<script src=<c:url value="/template/js/app.js"/>></script>
<script src=<c:url value="/template/js/app.plugin.js"/>></script>
<script src=<c:url value="/template/js/app.data.js"/>></script>
<!-- fuelux -->
<script src=<c:url value="/template/js/fuelux/fuelux.js"/>></script>
<!-- slider -->
<script src=<c:url value="/template/js/slider/bootstrap-slider.js"/>></script>
<!-- file input -->
<script
	src=<c:url value="/template/js/file-input/bootstrap.file-input.js"/>></script>
<!-- combodate -->
<script src=<c:url value="/template/js/combodate/moment.min.js"/>></script>
<script src=<c:url value="/template/js/combodate/combodate.js"/>></script>
<!-- parsley -->
<script src=<c:url value="/template/js/parsley/parsley.min.js"/>></script>
<!-- select2 -->
<script src=<c:url value="/template/js/select2/select2.min.js"/>></script>

<!--[if lt IE 9]>
    <script src="/template/js/ie/respond.min.js" cache="false"></script>
    <script src="/template/js/ie/html5.js" cache="false"></script>
    <script src="/template/js/ie/excanvas.js" cache="false"></script>
  <![endif]-->
</head>

<body>
	<section id="content">
		<div class="main padder">
			<div class="row">
				<div class="col-lg-4 col-lg-offset-4 m-t-large">
					<section class="panel">
						<header class="panel-heading text-center"> Connectez-vous
							à votre compte Shop </header>
						<form action="../j_spring_security_check" method="POST"
							class="panel-body">
							<div class="block">
								<label class="control-label">Email</label> <input type="email"
									placeholder="test@example.com" class="form-control"
									name="j_username">
							</div>
							<div class="block">
								<label class="control-label">Mot de passe</label> <input
									type="password" id="inputPassword" placeholder="Password"
									class="form-control" name="j_password">
							</div>

							<button type="submit" class="btn btn-info">Connexion</button>

								<a href="../client/init.do" class="col-lg-12 col-lg-offset-5">Créer un compte</a>


						</form>
					</section>


				</div>
			</div>
		</div>
	</section>
</body>

</html>