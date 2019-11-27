<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://xmlns.jcp.org/jsf/html"
      xmlns:ui="http://xmlns.jcp.org/jsf/facelets"
      xmlns:f="http://xmlns.jcp.org/jsf/core">
<head>
    <title>Purchase Order</title>

    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>

<div class="container-fluid">

    <div class="row">
        <div class="col-sm">

        </div>
        <div class="col-sm">
            <h1>Purchase Order</h1>
        </div>
        <div class="col-sm">

        </div>
    </div>



    <table>
        <tbody>
        <tr>
            <td><input type="text"/> </td>
            <td>
                <select name="source"  class="custom-select">
                    <option value="rss">Status</option>
                    <option value="other">OTHER LINK</option>
                    <option value="other2">OTHER LINK 2</option>
                </select>
            </td>
            <td><input type="text" placeholder="Search"/> </td>
            <td><input type="button" value="Export"/> </td>

        </tr>

        </tbody>
    </table>

    <form>
        <table>
            <thead>
            <tr>
                <td>Create Date</td>
                <td>Supplier</td>
                <td>PO No.</td>
                <td>Total</td>
                <td>Status</td>
                <td colspan="2">#</td>
            </tr>
            </thead>
            <tbody>
            <td>01/01/2016</td>
            <td>PT Mobil Nusantara</td>
            <td>PO001</td>
            <td>Rp. 500.000</td>
            <td>Approved</td>
            <td>edit</td>
            <td>view</td>
            </tbody>
        </table>

    </form>
</div>

</body>
</html>
