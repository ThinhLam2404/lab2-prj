<%-- 
    Document   : updateProduct
    Created on : Oct 22, 2023, 5:37:25 PM
    Author     : thinh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update</title>
    </head>
    <body>
        <form style="display: flex;justify-content: center; font-size: 24px" action="updateProduct" method="post" id="updateProduct">
            <table>
                <tr>
                    <td>ID</td>
                    <td>
                        <input value="${p.pro_id}" type="text" name="id" readonly>
                    </td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td>
                        <input value="${p.pro_name}" type="text" name="name" required>
                    </td>
                </tr>
                <tr>
                    <td>Quantity</td>
                    <td>
                        <input value="${p.pro_quan}" type="number" name="quan" min="0">
                    </td>
                </tr>
                <tr>
                    <td>Price</td>
                    <td>
                        <input value="${p.pro_price}" type="number" name="price"  min="0">
                    </td>
                </tr>
                <tr>
                    <td>Picture URL: </td>
                    <td>
                        <input value="${p.pro_pic}" type="text" name="pic" required>
                    </td>
                </tr>
                <tr>
                    <td>Decription</td>
                    <td>
                        <input value="${p.pro_des}" type="text" name="des" required>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <button type="submit">Update product</button>
                    </td>
                </tr>

            </table>

        </form>
    </body>
    <script src="js/jquery-3.7.0.min.js"></script>
    <script src="js/jquery.validate.min.js"></script>
    
</html>
