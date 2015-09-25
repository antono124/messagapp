<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">
    <link href="<c:url value="/resources/theme/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/theme/css/starter-template.css" />" rel="stylesheet">
    <title>Dashboard</title>
</head>
<body>

<!--Logout Code-->
<c:url value="/j_spring_security_logout" var="logoutUrl" />


<form action="${logoutUrl}" method="post" id="logoutForm">
</form>

<script>
    function formSubmit() {
        document.getElementById("logoutForm").submit();
    }
</script>

<jsp:include page="top.jsp" />

<div class="container">

    <h1>Dashboard</h1>

    <p class="lead"> ${pageContext.request.userPrincipal.name} Choose one button</p><br />

    <form:form action="/messagapp/chooseColor" commandName="colorForm" method="get" cssClass="form-signin">

        <h2 class="form-signin-heading">Choose color</h2>

        <form:select path="color" cssClass="form-control">
            <form:option value="green" label="Green" cssClass="form-control"/>
            <form:option value="red" label="Red" cssClass="form-control"/>
        </form:select>

        <button class="btn btn-default" type="submit">OK</button>

    </form:form>

    <br/>

   <a href="javascript:formSubmit()"> Logout</a>

</div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="<c:url value="/resources/theme/js/bootstrap.min.js" />"></script>
</body>
</html>