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

<!-- datepicker -->
<script src=<c:url value="/template/js/datepicker/bootstrap-datepicker.js"/>></script>
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
<script src=<c:url value="/template/js/file-input/bootstrap.file-input.js"/>></script>
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

	<div class="container">
		<div class="row">
			<div class="col-lg-6">
			
<!-- 			Solution 1 -->
<%-- 			${actionName } --%>

<!-- 				Solution 2 -->
<%-- 			<c:if test="${isUpdate == false}"> --%>
<!-- 				Création d'un nouveau client -->
<%-- 			</c:if> --%>
			
<%-- 			<c:if test="${isUpdate == true}"> --%>
<%-- 				Mise à jour du client ${cl.nom } --%>
<%-- 			</c:if> --%>
			
<!-- 			Solution 3 : avec l'equivalent if else -->
			<c:choose>
				<c:when test="${isUpdate }">
				<spring:message code="titre.formulaire.update"></spring:message>
					${cl.nom }
				</c:when>
				<c:otherwise>
					Création d'un nouveau client
				</c:otherwise>
			</c:choose>
			
			
			
				<form:form action="save.do" commandName="cl" method="POST"
					cssClass="form-horizontal">

					<form:hidden name="id" path="id" />
					
					<form:errors path="nom" />

					<div class="form-group">
						<form:label path="nom">Nom</form:label>
						<form:input name="nom" path="nom" cssClass="bg-focus form-control" />

					</div>
					
					<form:errors path="prenom" />

					<div class="form-group">
						<form:label path="prenom">Prenom</form:label>
						<form:input name="prenom" path="prenom" cssClass="bg-focus form-control" />

					</div>

					<br />
					
					<form:errors path="password" />

					<div class="form-group">
						<form:label path="password">Password</form:label>
						<form:input type="password" name="password" path="password" cssClass="bg-focus form-control" />
					</div>

					<br />

					<form:errors path="dateInscription" />
					<div class="form-group">
						<div class="m-b row">
							<div class="col-lg-6">
								<form:label path="dateInscription">Date inscription</form:label>
								<form:input name="dateInscription" path="dateInscription"
									cssClass="input-sm form-control datepicker" size="16"
									type="text" data-date-format="dd-mm-yyyy" />
							</div>
						</div>
					</div>
					<br />

					<form:errors path="age" />
					<div class="form-group">
						<form:label path="age">Age</form:label>
						<form:input name="age" path="age" cssClass="bg-focus form-control" />

					</div>
					<br />

					<form:errors path="email" />
					<div class="form-group">
						<form:label path="email">Email</form:label>
						<form:input name="email" path="email"
							cssClass="bg-focus form-control" />
					</div>

					<br />
					
					<form:errors path="adresse" />

					<div class="form-group">
						<form:label path="adresse">Addresse</form:label>
						<form:input name="adresse" path="adresse" cssClass="bg-focus form-control" />

					</div>
					<br />
					
<%-- 					<form:errors path="role" /> --%>
<!-- 					<div class="form-group" id="paysformgroup"> -->
<%-- 						<form:label path="role">Role</form:label> --%>
<%-- 						<form:select name="role" id="role" path="role"> --%>
<!-- 							<option></option> -->
<!-- 							<option value=ADMIN">ADMIN</option> -->
<!-- 							<option value=USER">USER</option> -->
<%-- 						</form:select> --%>
<!-- 					</div> -->
					
					<br />
					<input type="submit" value="Valider" class="btn btn-primary" />
				</form:form>
			</div>
		</div>
	</div>




</body>

</html>