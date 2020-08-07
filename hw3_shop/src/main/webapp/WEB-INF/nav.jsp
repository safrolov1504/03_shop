<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"/>
    <title>New product</title>
</head>

<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <c:url value="/products" var="productsUrl"/>
                <a class="nav-link" href="${productsUrl}">Product</a>
            </li>
        </ul>
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <c:url value="/order/" var="orderUrl"/>
                <a class="nav-link" href="${orderUrl}">Order</a>
            </li>
        </ul>
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <c:url value="/about/" var="aboutUrl"/>
                <a class="nav-link" href="${aboutUrl}">About</a>
            </li>
        </ul>
    </div>
</nav>
</body>