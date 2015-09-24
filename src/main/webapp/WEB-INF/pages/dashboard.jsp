<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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

    <p class="lead">Choose one button</p><br />


    <button type="button" class="btn btn-success" onclick="location.href=''">Green Button</button>
    <button type="button" class="btn btn-danger">Red Button</button>
    <br/>


    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <h2>
            Welcome : ${pageContext.request.userPrincipal.name}
            | <a href="javascript:formSubmit()"> Logout</a>
        </h2>
    </c:if>



</div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="<c:url value="/resources/theme/js/bootstrap.min.js" />"></script>
</body>
</html>