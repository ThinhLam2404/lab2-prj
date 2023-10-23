<%-- 
    Document   : addProduct
    Created on : Oct 22, 2023, 5:06:06 PM
    Author     : thinh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add</title>
    </head>
    <body>
        <form style="display: flex;justify-content: center; font-size: 24px" action="addProduct" method="post">
            <table>
                <tr>
                    <td>ID</td>
                    <td>
                        <input type="text" name="id" required>
                    </td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td>
                        <input type="text" name="name" required>
                    </td>
                </tr>
                <tr>
                    <td>Quantity</td>
                    <td>
                        <input type="number" name="quan" required min="1">
                    </td>
                </tr>
                <tr>
                    <td>Price</td>
                    <td>
                        <input type="number" name="price" min="1">
                    </td>
                </tr>
                <tr>
                    <td>Picture URL: </td>
                    <td>
                        <input type="text" name="pic" required>
                    </td>
                </tr>
                <tr>
                    <td>Decription</td>
                    <td>
                        <input type="text" name="des" required>
                    </td>
                </tr>
                 <tr>
                    <td></td>
                    <td>
                        <button type="submit">Add product</button>
                    </td>
                </tr>
              
            </table>

        </form>
    </body>
</html>
