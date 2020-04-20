

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/makeQuiz.css" rel="stylesheet" type="text/css"/>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
        <%
            boolean isInsert = false;
            String message = (String) request.getAttribute("message");
            String content = "";
            String option1 = "";
            String option2 = "";
            String option3 = "";
            String option4 = "";
            String[] answer = {"", "", "", ""};

            if (message != null) {
                content = (String) request.getAttribute("content");
                option1 = (String) request.getAttribute("opt1");
                option2 = (String) request.getAttribute("opt2");
                option3 = (String) request.getAttribute("opt3");
                option4 = (String) request.getAttribute("opt4");
                answer = (String[]) request.getAttribute("answer");
                isInsert = (boolean) request.getAttribute("isInsert");
            }
        %>
    </head>
    <body>
        <div class="container">
            <div class="header">
                <%@include file="header.jsp" %>
            </div>
            <div class="main">
                <%if (isInsert) {%>
                <h2>Question added successfully</h2>
                <a href="makeQuiz">Add another question</a>
                <%}
                else {%>
                <form action="makeQuiz" method="post">
                    <table>
                        <tbody>
                            <tr>
                                <td class="text-top">Question: </td>
                                <td><textarea class="content" name="content"><%=content%></textarea></td>
                            </tr>
                            <tr>
                                <td class="text-top">Option 1:</td>
                                <td><textarea name="opt1"><%=option1%></textarea></td>
                            </tr>
                            <tr>
                                <td class="text-top">Option 2:</td>
                                <td><textarea name="opt2" ><%=option2%></textarea></td>
                            </tr>
                            <tr>
                                <td class="text-top">Option 3:</td>
                                <td><textarea name="opt3" ><%=option3%></textarea></td>
                            </tr>
                            <tr>
                                <td class="text-top">Option 4:</td>
                                <td><textarea name="opt4"><%=option4%></textarea></td>
                            </tr>
                            <tr>
                                <td class="text-top">Answer(s):</td>
                                <td>
                                    <input type="checkbox" name="answer" value="1" <%=answer[0]%>> Option 1
                                    <input type="checkbox" name="answer" value="2" <%=answer[1]%>> Option 2
                                    <input type="checkbox" name="answer" value="3" <%=answer[2]%>> Option 3
                                    <input type="checkbox" name="answer" value="4" <%=answer[3]%>> Option 4
                                </td>
                            </tr>
                            <tr>
                                <td></td>
                                <td><input type="submit" value="Save"></td>
                            </tr>
                        </tbody>
                    </table>
                </form>
                <% if (message != null) {%>
                <span class="failed"><%=message%></span>
                <% }%>
                <%}%>


            </div>
        </div>


    </body>
</html>
