<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://xmlns.jcp.org/jsf/html"
      xmlns:ui="http://xmlns.jcp.org/jsf/facelets"
      xmlns:f="http://xmlns.jcp.org/jsf/core">
<head>
    <title>Supplier Detail</title>
</head>
<body>
<h2>Supplier Detail</h2>

<form:form action="saveSupplier" modelAttribute="theSupplier" method="POST">
    <form:hidden path="id"/>
    <table>
        <tbody>
        <tr>
            <td><label>Supplier Name :</label></td>
            <td><form:input path="name"/></td>
        </tr>


        <tr>
            <td><label>Address : </label></td>
            <td><form:input path="address"/></td>
        </tr>

        <tr>
            <td>
                <select name="source" onchange="">
                    <option value="rss">Province</option>
                    <option value="other">OTHER LINK</option>
                </select>
            </td>

            <td>
                <select name="source" onchange="">
                    <option value="rss">Region</option>
                    <option value="other">OTHER LINK</option>
                </select>
            </td>

            <td>
                <select name="source" onchange="">
                    <option value="rss">District</option>
                    <option value="other">OTHER LINK</option>
                </select>
            </td>


        </tr>

        <tr>
            <td>
                    <%--                            <input type="text" onfocus="this.value=''" value="Postal Code"/>--%>
                <form:input path="postalCode"/>
            </td>

            <td>
                    <%--                            <input type="text" onfocus="this.value=''" value="Phone"/>--%>
                <form:input path="phone"/>
            </td>

            <td>
                    <%--                            <input type="text" onfocus="this.value=''" value="Email"/>--%>
                <form:input path="email"/>
            </td>
        </tr>

        <tr>
            <td></td>
            <td><input type="button" value="cancel" onclick="window.location.href='list';return false;"/></td>
            <td><input type="submit" value="save"/></td>

        </tr>
        </tbody>
    </table>

</form:form>

</body>
</html>
