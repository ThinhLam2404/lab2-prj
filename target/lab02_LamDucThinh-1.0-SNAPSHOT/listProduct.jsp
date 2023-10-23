<%-- 
    Document   : list
    Created on : Oct 19, 2023, 12:25:35 PM
    Author     : thinh
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Information</title>
        <link rel="stylesheet" href="./css/listStyle.css"/>
    </head>
    <body>
        <h1 style="text-align: right" name="name">Hello ${name} <form action="login_servlet" method="post"><button>Sign out</button></form> </h1>

        <a style=" font-size: 25px" href="listOrder">Cart</a><br>

        <a  style=" font-size: 25px" href="addProduct.jsp" >Add new product</a>
        <table >
            <tr>
                <th>pro_id</th>
                <th>pro_name</th>
                <th>pro_quan</th>
                <th>pro_price</th>
                <th>pro_pic</th>
                <th>pro_des</th>
            </tr>

            <c:forEach items="${listProduct}" var="product">
                <tr>
                    <td>${product.getPro_id()}</td>
                    <td> ${product.getPro_name()}</td>
                    <td>${product.getPro_quan()}</td>
                    <td>${product.getPro_price()}</td>
                    <td><img style="width: 70%" src="${product.getPro_pic()}" alt="alt"/></td>
                    <td>${product.getPro_des()}</td>
                    <td>
                        <a href="updateProduct?pid=${product.pro_id}">update</a>
                        <a  href="#" onclick="showMess('${product.pro_id}')">delete</a>
                        <a href="addOrder?oid=${product.pro_id}">order</a>
                    </td>

                </tr>
            </c:forEach>

        </table>
    </body>
    <script>
        function showMess(id) {
            var option = confirm('Are you sure to delete this product?');
            if (option === true) {
                window.location = "delete?pid=" + id;
            }
        }


    </script>
</html>
