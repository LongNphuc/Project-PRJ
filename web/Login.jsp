<%-- 
    Document   : Login
    Created on : Jul 9, 2023, 8:03:58 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet"  href="cssForLogin.css">
        <title>ĐĂNG NHẬP WEB PHIM LẬU</title>
    </head>
    <body>
        <form action="login" method="Post" style="margin:auto">
            <h1 style="color: crimson">WEB PHIM LẬU IS</h2>
            <table>
                <tr>
                    <td style="color: antiquewhite">Account:</td>
                    <td><input type="text" name="acc"></td>
                </tr>
                <tr>
                    <td style="color: antiquewhite">Password:</td>
                    <td><input type="password" name="pass"></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><button>Login</button></td>
                </tr>
            </table>
        </form>
    </body>
</html>



