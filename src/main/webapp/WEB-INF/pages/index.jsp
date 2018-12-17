<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="springForm" uri="http://www.springframework.org/tags/form" %>

<html>
<head>

    <%--<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.js"/>--%>


</head>
<body>
<hr>
<h2 align="center">Hello to the cars world!</h2>
<hr>

<%--@elvariable id="newCar" type="dto.CarDTO"--%>
<springForm:form action="/car/add" method="post" commandName="newCar">
    <table>
        <tr><td><springForm:input placeholder="model" type="text" path="model"/></td></tr>
        <tr><td><springForm:input placeholder="color" type="text" path="color"/></td></tr>
        <tr><td><springForm:input placeholder="price" type="text" path="price"/></td></tr>
        <tr><td width="150"><input type="submit" value="Add Car"/></td></tr>
    </table>
</springForm:form>

<hr>

<form action="/car/getAll">
    <table>
        <tr><td width="150"><input type="submit" value="Get All Cars"></td></tr>
    </table>
</form>

<springForm:form action="/car/delete/id" method="post">
    <input type="text" name="id">
    <input type="submit" value="delete">
</springForm:form>

</body>
</html>
