<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>login</title>
        <%
            String message = (String) request.getAttribute("message");
            String username = (String) request.getAttribute("username");
            String password = (String) request.getAttribute("password");
        %>
    </head>
    <body>
        
        
        <div class="container">
            <div class="header">
                <%@include file="header.jsp" %>
            </div>
            <div class="main">
                <div class="title-form">Login Form</div>

                <form action="login" method="post">
                    <table>
                        <tbody>
                            <tr>
                                <%if (message != null) {%>
                                <td class="message" colspan="2"><%=message%></td>
                                <%}%>
                            </tr>
                            <tr>
                                <td class="user-pading">User Name: </td>
                                <td><input type="text" value="<%=username == null ? "" : username%>"  name="username" required=""></td>
                            </tr>
                            <tr>
                                <td>Password: </td>
                                <td><input type="password" value="<%=password == null ? "" : password%>" name="password" required=""></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>
                                    <input type="submit" value="Sign In">
                                    <a href="register">Register</a>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </form>
            </div>
        </div>

    </body>
</html>
