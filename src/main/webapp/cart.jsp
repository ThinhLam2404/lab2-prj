<%-- 
    Document   : cart
    Created on : Oct 22, 2023, 10:41:40 PM
    Author     : thinh
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart</title>
        <link rel="stylesheet" href="./css/listStyle.css"/>
    </head>
    <body>
        <!--<h1>hello ${user}</h1>-->
        <table>
            <tr>
                <th>order_id</th>
                <th>username</th>
                <th>order_total</th>
                <th>order_date</th>
                <th>order_des </th>
                
            </tr>

            <c:forEach items="${listOrder}" var="o">
                <tr>    
                    <td>${o.order_id}</td>
                    <td>${o.username}</td>
                    <td>${o.order_total}</td>
                    <td>${o.order_date}</td>
                    <td>${o.order_des}</td>


                    
                    <td>
                        <a href="updateOrder?oid=${o.order_id}">update</a>
                        <a  href="#" onclick="showMess('${o.order_id}')">delete</a>
                    </td>
                </tr>

            </c:forEach>

        </table>
        <a href="listBack"><button>BACK</button></a>



    </body>
    <script>
        function showMess(id) {
            var option = confirm('Are you sure to delete this order?');
            if (option === true) {
                window.location = "deleteOrder?oid=" + id;
            }
        }


    </script>
</html>
