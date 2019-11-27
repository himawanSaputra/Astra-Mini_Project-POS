<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <link rel="stylesheet" href="<c:url value="/resources/css/home.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap-min.css" />">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<%--    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstr    ap/4.3.1/css/bootstrap.min.css">--%>
<%--    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>--%>
<%--    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">--%>
<%--    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>--%>
<%--    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>--%>
    <link rel="stylesheet" href="<c:url value="/resources/bootstrap/js/bootstrap-min.js" />">
    <!------ Include the above in your HEAD tag ---------->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-T8Gy5hrqNKT+hzMclPo118YTQO6cYprQmhrYwIiQ/3axmI1hQomh7Ud2hPOy8SP1" crossorigin="anonymous">
</head>
<body class="home">
    <div class="container-fluid display-table">
        <div class="row display-table-row">
            <div class="col-md-3 col-sm-2 hidden-xs display-table-cell v-align box" id="navigation">
                <div class="navi">
                    <ul class="pl-0">
                        <li>
                            <h2 class="text-white bi" align="center">Point Of Sales</h2>
                        </li>
                        <li class="active">
                            <a href="#">
                                <i class="fa fa-home" aria-hidden="true"></i>
                                <span class="hidden-xs hidden-sm">Home</span>
                            </a>
                        </li>
                        <li>
                            <a data-toggle="collapse" href="#mstCollapse" role="button" aria-expanded="false" aria-controls="mstCollapse">
                                <i class="fa fa-tasks" aria-hidden="true"></i>
                                <span class="hidden-xs hidden-sm">Master Data</span>
                            </a>
                            <div class="collapse" id="mstCollapse">
                                <ul>
                                    <li><a href="#">Category</a></li>
                                    <li><a href="#">Supplier</a></li>
                                    <li><a href="#">Outlet</a></li>
                                    <li><a href="#">Items</a></li>
                                    <li><a href="#">Employee</a></li>
                                </ul>
                            </div>
                        </li>
                        <li>
                            <a data-toggle="collapse" href="#txCollapse" role="button" aria-expanded="false" aria-controls="txCollapse">
                                <i class="fa fa-bar-chart" aria-hidden="true"></i>
                                <span class="hidden-xs hidden-sm">Transaction</span>
                            </a>
                            <div class="collapse" id="txCollapse">
                                <ul>
                                    <li><a href="#">Purchase Request</a></li>
                                    <li><a href="#">Purchase Order</a></li>
                                    <li><a href="#">Adjustment</a></li>
                                    <li><a href="#">Transfer Stock</a></li>
                                    <li><a href="#">Sales Order</a></li>
                                    <li><a href="#">Summary</a></li>
                                </ul>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="col-md-9 col-sm-10 display-table-cell v-align">
                <div class="row">
                    <header class="align-middle">
                        <div class="col-md-12">
                            <h1 class="float-left">Dashboard</h1>
                            <div class="float-right align-items-center">
                                <ul class="list-inline header-top pull-right align-items-center">
                                    <li>
                                        <h4 align="center" class="mb-0">
                                            Hello, ${user.username}
                                        </h4>
                                    </li>
                                    <li>
                                        <a class="btn btn-danger" href="<c:url value="/logout"/>">Logout</a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </header>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
