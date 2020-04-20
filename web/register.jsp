
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
        <%
            String message = (String) request.getAttribute("message");
            String username = (String) request.getAttribute("username");
            String email = (String) request.getAttribute("email");
            String type = (String) request.getAttribute("type");
        %>
    </head>
    <body>
        <div class="container">
            <div class="header">
                <%@include file="header.jsp" %>
            </div>
            <div class="main">
                <div class="title-form">Registration form</div>


                <form action="register" method="post">
                    <table>
                        <tbody>
                        <colgroup>
                            <col class="labelCol">
                            
                        </colgroup>
                        <tr>
                            <%if (message != null) {%>
                            <td class="message" colspan="2"><%=message%></td>
                            <%}%>


                        </tr>
                        <tr>
                            <td>User Name: </td>
                            <td><input type="text" value="<%=username == null ? "" : username%>" name="username" required=""></td>
                        </tr>
                        <tr>
                            <td>Password: </td>
                            <td><input type="password"  name="password" required=""></td>
                        </tr>
                        <tr>
                            <td>Type</td>
                            <td>
                                <select name='type' value="">
                                    <%if (type != null) {%>
                                    <option value='false' <%=type.equals("false") ? "selected" : ""%>>Student</option>
                                    <option value='true' <%=type.equals("true") ? "selected" : ""%>>Teacher</option>
                                    <%}
                                        else {%>
                                    <option value='false' >Student</option>
                                    <option value='true' >Teacher</option>
                                    <%}%>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Email: </td>
                            <td><input type="email" value="<%=email == null ? "" : email%>" name='email' required=""></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><input type="submit" value="Register"></td>
                        </tr>
                        </tbody>
                    </table>
                </form>
            </div>
        </div>

    </body>
</html>
