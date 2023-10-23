<%-- 
    Document   : index
    Created on : Oct 19, 2023, 11:02:40 AM
    Author     : thinh
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

    <head>
        <title>Login</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://unicons.iconscout.com/release/v2.1.9/css/unicons.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/loginStyle.css">

    </head>

    <body>
        <div class="section">
            <div class="container">
                <div class="row full-height justify-content-center">
                    <div class="col-12 text-center align-self-center py-5">
                        <div class="section pb-5 pt-5 pt-sm-2 text-center">
                            <h6 class="mb-0 pb-3"></h6>
                            <input class="checkbox" type="checkbox" id="reg-log" name="reg-log" />

                            <div class="card-3d-wrap mx-auto">
                                <div class="card-3d-wrapper">
                                    <div class="card-front">
                                        <div class="center-wrap">
                                            <div class="section text-center">
                                                <h4 class="mb-4 pb-3">Log In</h4>
                                                <form action="login_servlet" method="pre" id="loginF">
                                                    <div class="form-group">
                                                        <input class="form-style" value="${username}" type="text" placeholder="Username" name="username" id="username" >
                                                        <i class="input-icon uil uil-at"></i>
                                                    </div>
                                                    <div class="form-group mt-2">
                                                        <input type="password" class="form-style" value="${password}" placeholder="Password" id="password" name="password">
                                                        <i class="input-icon uil uil-lock-alt"></i>
                                                    </div>
                                                    ${ms}
                                                    <button class="btn mt-4" type="submit">Login</button>
                                                    
                                                </form>        
                                            </div>
                                        </div>
                                    </div>
                                   
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

                                                   
        <script src="js/jquery-3.7.0.min.js"></script>
        <script src="js/jquery.validate.min.js"></script>
        <script src="js/validate.js"></script>

    </body>

</html>




