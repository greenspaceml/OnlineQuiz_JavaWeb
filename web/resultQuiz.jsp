<%-- 
    Document   : quizResult
    Created on : Mar 19, 2020, 6:08:22 PM
    Author     : dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/takeQuiz.css" rel="stylesheet" type="text/css"/>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <%
        String status = (String) request.getAttribute("status");
        String strScore = (String) request.getAttribute("strScore");
        String strPercent = (String) request.getAttribute("strPercent");
        String message = (String) request.getAttribute("message");

    %>
    <body>
        <div class="container">
            <div class="header">
                <%@include file="header.jsp" %>
            </div>
            <div class="main">

                <p>Your score
                    <%if (message == null) {%>
                    <span class="username">
                        <%=strScore%> (<%=strPercent%>%) - <%=status%>
                    </span>
                    <%}
                    else {%>
                <span class="username"><%=message%></span>

                <%}%>
                </p>

                <form action="prepareQuiz" method="get">
                    <br>Take another test
                    <input type="submit" value="Start">
                </form>

            </div>
        </div>
    </body>
</html>
