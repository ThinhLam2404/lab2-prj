<%-- 
    Document   : order
    Created on : Oct 21, 2023, 4:35:31 PM
    Author     : thinh
--%>

<%@page import="java.time.ZoneId"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order</title>
    </head>
    <body>
        <form style="display: flex;justify-content: center; font-size: 24px" action="addOrder" method="post">
            <table>
                <tr>
                    <td>Product name</td>
                    <td>
                        <input type="text" name="proName" value="${proName}" readonly>

                    </td>
                </tr>

                <tr>
                    <td>Enter order id</td>
                    <td>
                        <input type="text" name="id" required>
                    </td>
                </tr>
                <tr>
                    <td>Enter total</td>
                    <td>
                        <input type="number" name="total" required min="1" max="${maxQuan}">
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
                        <input type="text" name="des">
                    </td>
                </tr>

                <tr>
                    <td></td>
                    <td>
                        <button type="submit">Add to cart</button>
                    </td>
                </tr>

            </table>

        </form>
        <script src="js/jquery-3.7.0.min.js"></script>
        <script src="js/jquery.validate.min.js"></script>
        <script>

        </script>

    </body>
</html>
