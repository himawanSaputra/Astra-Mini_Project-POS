<%--
  Created by IntelliJ IDEA.
  User: dannp
  Date: 11/21/2019
  Time: 2:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>List Supplier</title>

    <!-- reference our style sheet -->
<%--    <link type="text/css"--%>
<%--          rel="stylesheet"--%>
<%--          href="${pageContext.request.contextPath }/resources/css/style.css"/>--%>
</head>
<body>

<div id="wrapper">
    <div id="header">
        <h2>Suppliers</h2>
    </div>
</div>



<div id="container">
    <div id="content">

        <!-- put new Button: Add Button -->
        <input type="button" value="Create"
<%--               onClick="window.location.href='showFormForAdd'; --%>
<%--               return false;"--%>
<%--               class="add-button"--%>
        />
        <br/>

<%--        <form:form action="search" method="GET">--%>
<%--            Search Customer: <input type="text" name="theSearchName"/>--%>
<%--            <input type="submit" value="Search" class="add-button"/>--%>
<%--        </form:form>--%>
        <!-- add out html table -->
        <table>
            <tr>
                <th>Name</th>
                <th>Phone</th>
                <th>Email</th>
                <th colspan="2">#</th>
            </tr>



            <!-- loop over and print out customers -->
            <c:forEach var="tempCustomer" items="${customer}">

                <!-- construct an "update" link with customer id -->
                <c:url var="updateLink" value="/customer/showFormForUpdate">
                    <c:param name="customerId" value="${tempCustomer.id}"/>
                </c:url>

                <c:url var="deleteLink" value="/customer/deleteCustomer">
                    <c:param name="customerId" value="${tempCustomer.id}"/>
                </c:url>

                <tr>
                    <td>${tempCustomer.firstName}</td>
                    <td>${tempCustomer.lastName}</td>
                    <td>${tempCustomer.email}</td>
                    <td>
                        <!-- display the update link -->
                        <a href="${updateLink}">Update</a>
                    </td>
                    <td>
                        <!-- direct delete -->
                        <a href="${deleteLink}">Delete</a>
                    </td>
                </tr>

            </c:forEach>
        </table>
    </div>
</div>

</body>

</html>