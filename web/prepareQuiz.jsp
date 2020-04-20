
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link href="css/prepareQuiz.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>

        <%
            String message = (String) request.getAttribute("message");
            int quiz = 0;
            if (message != null) {
                quiz = (int) request.getAttribute("quiz");
            }
        %>
    </head>
    <body>
        <div class="container">
            <div class="header">
                <%@include file="header.jsp" %>
            </div>
            <div class="main">
                <div class="wellcome">Welcome <span class="username"><%=u.getUsername()%></span></div>
                    <% if (message != null) {%>
                <div><%=message%></div>
                <% }%>
                <form action="prepareQuiz" method="post">

                    <div>Enter number of question: </div>
                    <input class="input" type="text" value="" name="numOfQuiz" required="">
                    <br>
                    <br>
                    <input type="submit" value="Start">
                </form>
            </div>
        </div>

    </body>
</html>
