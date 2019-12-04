<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <link rel="stylesheet" href="<c:url value="/resources/css/home.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap-min.css" />">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<%--    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>--%>
    <link href = "https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
          rel = "stylesheet">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="<c:url value="/resources/bootstrap/js/bootstrap-min.js" />">

    <!------ Include the above in your HEAD tag ---------->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-T8Gy5hrqNKT+hzMclPo118YTQO6cYprQmhrYwIiQ/3axmI1hQomh7Ud2hPOy8SP1" crossorigin="anonymous">
</head>
<body class="home m-0 p-0">
    <div class="container-fluid display-table">
        <div class="row display-table-row">
            <div class="col-md-3 col-sm-2 hidden-xs display-table-cell v-align box" id="navigation">
                <div class="navi">
                    <ul class="pl-0">
                        <li>
                            <h2 class="text-white bi" align="center">Point Of Sales</h2>
                        </li>
                        <li class="sidebar-menu">
                            <a href="<c:url value="/home"/>">
                                <i class="fa fa-home" aria-hidden="true"></i>
                                <span class="hidden-xs hidden-sm">Home</span>
                            </a>
                        </li>
                        <li class="sidebar-menu">
                            <a data-toggle="collapse" href="#mstCollapse" role="button" aria-expanded="false" aria-controls="mstCollapse">
                                <i class="fa fa-database" aria-hidden="true"></i>
                                <span class="hidden-xs hidden-sm">Master Data</span>
                            </a>
                            <div class="collapse" id="mstCollapse">
                                <ul>
                                    <c:if test="${
                                        (sessionScope.user.mstRole.id == 1) ||
                                        (sessionScope.user.mstRole.id == 2)}">
                                        <li><a href="<c:url value="/category"/>" class="pr-5 text-center bg-secondary">Category</a></li>
                                    </c:if>
                                    <c:if test="${
                                        (sessionScope.user.mstRole.id == 1) ||
                                        (sessionScope.user.mstRole.id == 2)}">
                                        <li><a href="<c:url value="/supplier/list"/>" class="pr-5 text-center bg-secondary">Supplier</a></li>
                                    </c:if>
                                    <c:if test="${sessionScope.user.mstRole.id == 1}">
                                        <li><a href="<c:url value="/outlet"/>" class="pr-5 text-center bg-secondary">Outlet</a></li>
                                    </c:if>
                                    <c:if test="${
                                        (sessionScope.user.mstRole.id == 1) ||
                                        (sessionScope.user.mstRole.id == 2) ||
                                        (sessionScope.user.mstRole.id == 3)}">
                                        <li><a href="<c:url value="/item"/>" class="pr-5 text-center bg-secondary">Items</a></li>
                                    </c:if>
                                    <c:if test="${
                                        (sessionScope.user.mstRole.id == 1) ||
                                        (sessionScope.user.mstRole.id == 2)}">
                                        <li><a href="<c:url value="/employee"/>" class="pr-5 text-center bg-secondary">Employee</a></li>
                                    </c:if>
                                </ul>
                            </div>
                        </li>
                        <li class="sidebar-menu">
                            <a data-toggle="collapse" href="#txCollapse" role="button" aria-expanded="false" aria-controls="txCollapse">
                                <i class="fa fa-exchange" aria-hidden="true"></i>
                                <span class="hidden-xs hidden-sm">Transaction</span>
                            </a>
                            <div class="collapse" id="txCollapse">
                                <ul>
                                    <c:if test="${sessionScope.user.mstRole.id == 2}">
                                        <li><a href="#" class="pr-5 text-center bg-secondary">Purchase Request</a></li>
                                    </c:if>
                                    <c:if test="${sessionScope.user.mstRole.id == 2}">
                                        <li><a href="#" class="pr-5 text-center bg-secondary">Purchase Order</a></li>
                                    </c:if>
                                    <c:if test="${sessionScope.user.mstRole.id == 2}">
                                        <li><a href="#" class="pr-5 text-center bg-secondary">Adjustment</a></li>
                                    </c:if>
                                    <c:if test="${sessionScope.user.mstRole.id == 2}">
                                        <li><a href="<c:url value="/transfer_stock"/>" class="pr-5 text-center bg-secondary">Transfer Stock</a></li>
                                    </c:if>
                                    <c:if test="${
                                        (sessionScope.user.mstRole.id == 2) ||
                                        (sessionScope.user.mstRole.id == 3)}">
                                        <li><a href="#" class="pr-5 text-center bg-secondary">Sales Order</a></li>
                                    </c:if>
                                    <c:if test="${sessionScope.user.mstRole.id == 2}">
                                        <li><a href="#" class="pr-5 text-center bg-secondary">Summary</a></li>
                                    </c:if>
                                </ul>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="col-md-9 col-sm-10 display-table-cell v-align">
                <div class="row">
                    <header>
                        <div class="col-md-12">
                            <div class="row h-100 p-0 m-0 align-middle">
                                <div class="col-6 h-100 align-middle p-0 m-0">
                                    <h1 class="m-0 p-0">${page_title}</h1>
                                </div>
                                <div class="col-5 align-middle text-right m-0 p-0">
                                    <h4 align="right">
                                        Hello, ${sessionScope.user.username}
                                    </h4>
                                </div>
                                <div class="col-1 align-middle text-right m-0 p-0">
                                    <button class="btn btn-danger" onclick="location.href='<c:url value="/logout"/>'">
                                        Logout
                                    </button>
                                </div>
                            </div>
                        </div>
                    </header>
                    <!-- CONTENT GOES HERE -->
                    <div id="content" class="h-100 w-100 m-5">
                        <jsp:include page="${content_page_url}"/>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script>
        $(document).ready(function(){
            //TO HANDLE THE ACTIVE TAB SELECTED
            $(".sidebar-menu").each(function(index){
                $(this).on("click", function () {
                    $(".sidebar-menu").each(function(index){
                       $(this).removeClass("active");
                    });
                   $(this).addClass("active");
                });
            });
        });
    </script>
</body>
</html>



