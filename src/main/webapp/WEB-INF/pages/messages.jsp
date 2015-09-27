<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    <title>Messages</title>
</head>
<body>

<jsp:include page="top.jsp" />

<div class="container">
    <div class="starter-template">

        <div class="row" style="background-color:#D8F6CE;">
            <div class="col-sm-6">
                <h1 align="left">Messages</h1>
            </div>
        </div>


        <h2>Messages</h2>

        <c:forEach items="${messages}" var="message">
            <div class="list-group">
                <a href="#" class="list-group-item active">
                List of messages
                </a>
            </div>
        </c:forEach>
    </div>
</div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="<c:url value='/resources/theme/js/bootstrap.min.js' />"></script>
</body>
</html>
