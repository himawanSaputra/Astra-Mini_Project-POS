<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://xmlns.jcp.org/jsf/html"
      xmlns:ui="http://xmlns.jcp.org/jsf/facelets"
      xmlns:f="http://xmlns.jcp.org/jsf/core">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<%--    <link rel="stylesheet"--%>
<%--          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"--%>
<%--          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"--%>
<%--          crossorigin="anonymous">--%>

    <title>Supplier Detail</title>
</head>
<body>
<div class="row">
    <div class="col-12">
        <form:form action="saveSupplier" modelAttribute="theSupplier" method="POST">
            <form:hidden path="id"/>
            <table>
                <tbody>
                <tr>
                        <%--            <td><label>Supplier Name :</label></td>--%>
                    <td colspan="2"><form:input path="name" placeholder="Supplier Name" class="form-control"/></td>
                </tr>

                <form:option value="0" label="-- Choose --" disabled="true"/>
                <tr>
                        <%--            <td><label>Address : </label></td>--%>
                    <td colspan="2"><form:input path="address" placeholder="Address" class="form-control"/></td>
                </tr>

                <tr>
                    <td>
                        <select name="source" class="custom-select">
                            <option value="rss">Province</option>
                            <option value="other">OTHER LINK</option>
                        </select>
                    </td>

                    <td>
                        <select name="source" class="custom-select">
                            <option value="rss">Region</option>
                            <option value="other">OTHER LINK</option>
                        </select>
                    </td>

                    <td>
                        <select name="source" class="custom-select">
                            <option value="rss">District</option>
                            <option value="other">OTHER LINK</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                            <%--                            <input type="text" onfocus="this.value=''" value="Postal Code"/>--%>
                        <form:input path="postalCode" placeholder="Postal Code" class="form-control"/>
                    </td>
                    <td>
                            <%--                            <input type="text" onfocus="this.value=''" value="Phone"/>--%>
                        <form:input path="phone" placeholder="Phone" class="form-control"/>
                    </td>
                    <td>
                            <%--                            <input type="text" onfocus="this.value=''" value="Email"/>--%>
                        <form:input path="email" placeholder="Email" class="form-control"/>
                    </td>
                </tr>

                <tr>
                    <td></td>
                    <td><input type="button" value="cancel" align="right" class="btn btn-primary"
                               onclick="window.location.href='list';return false;"/></td>
                    <td><input type="submit" value="save" class="btn btn-primary"/></td>
                </tr>
                </tbody>
            </table>
        </form:form>
    </div>
</div>
</body>
</html>
