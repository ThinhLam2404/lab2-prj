<%-- 
    Document   : updateOrder
    Created on : Oct 23, 2023, 1:02:17 AM
    Author     : thinh
--%>

<%@page import="java.time.ZoneId"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update</title>
    </head>
    <body>
        <form style="display: flex;justify-content: center; font-size: 24px" action="updateOrder" method="post">
            <table>
                <tr>
                    <td>Enter order id</td>
                    <td>
                        <input value="${o.order_id}" type="text" name="id" readonly>
                    </td>
                </tr>
                <tr>
                    <td>Enter total</td>
                    <td>
                        <input value="${o.order_total}" type="number" name="total" min="1" max="">
                    </td>
                </tr>
                <tr>

                    <td>Date</td>
                    <td>
                        <input type="date" name="date" value="<%= new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()%>" readonly>
                    </td>
                </tr>
                <tr>
                    <td>Username</td>
                    <td>
                        <input type="text" name="user" value="${user}" readonly>
                    </td>
                </tr>
                <tr>
                    <td>Enter decription</td>
                    <td>
                        <input value="${o.order_des}" type="text" name="des">
                    </td>
                </tr>

                <tr>
                    <td></td>
                    <td>
                        <button type="submit">Update</button>
                    </td>
                </tr>

            </table>

        </form>
    </body>
</html>
