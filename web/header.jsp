<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/header.css" rel="stylesheet" type="text/css"/>
        <title>header</title>
        <%
            User u = (User) session.getAttribute("user");
        %>
    </head>
    <body>
        <div class="top_box">
        </div>
        <div class="menu_bg">
            <div class="menu">
                <table border="0">
                    <tr>
                        <th><a href="home">Home</a></th>
                        <th><a href="prepareQuiz">Take Quiz</a></th>
                        <th><a href="makeQuiz">Make Quiz</a></th>
                        <th><a href="manageQuiz">Manage Quiz</a></th>
                        <th>
                            <%if (u != null) {%>
                            <a href="logout">Logout</a>
                            <%}%>
                        </th>
                    </tr>
                </table>
            </div>
        </div>

    </body>
</html>
