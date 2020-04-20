
<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>


        <div class="container">
            <div class="header">
                <%@include file="header.jsp" %>
            </div>
            <div class="main">
                <div class="wellcome">Welcome <span class="username"><%=u.getUsername()%></span></div>

            </div>
        </div>


    </body>
</html>
