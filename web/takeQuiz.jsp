

<%@page import="java.util.ArrayList"%>
<%@page import="model.Question"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/takeQuiz.css" rel="stylesheet" type="text/css"/>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <script src="javascript/js.js" type="text/javascript"></script>
        <title>JSP Page</title>
        <%
            ArrayList<Question> listQuiz = (ArrayList<Question>) session.getAttribute("listQuiz");
            long totalTime = (long) request.getAttribute("totalTime");
        %>
    </head>
    <body>
        <div class="container">
            <div class="header">
                <%@include file="header.jsp" %>
            </div>
            <div class="main">


                <form id="quizForm" action="resultQuiz" method="post">
                    <table border="0">

                        <colgroup>
                            <col class="col1">
                            <col class="col2">
                        </colgroup>
                        <tbody>

                            <tr>
                                <td><div>Welcome <span class="username"><%=u.getUsername()%></span></div></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td><div class="time">Time remaining: <span id="timeDisplay"></span></div></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td><div id="currentQuiz" class="quiz">Question: 0/0</div></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td >
                                    <%for (int i = 0; i < listQuiz.size(); i++) {%>
                                    <div id="q<%=i%>" class="hidden">
                                        <div class="quiz"><%=listQuiz.get(i).getContent()%></div>
                                        <div class="quiz">
                                            <input type="checkbox" value="1" name="ans<%=i%>">
                                            <%=listQuiz.get(i).getOption1()%>
                                        </div>
                                        <div class="quiz">
                                            <input type="checkbox" value="2" name="ans<%=i%>">
                                            <%=listQuiz.get(i).getOption2()%>
                                        </div>
                                        <div class="quiz">
                                            <input type="checkbox" value="3" name="ans<%=i%>">
                                            <%=listQuiz.get(i).getOption3()%>
                                        </div>
                                        <div class="quiz">
                                            <input type="checkbox" value="4" name="ans<%=i%>">
                                            <%=listQuiz.get(i).getOption4()%>
                                        </div>
                                    </div>
                                    <%}%>
                                </td>
                                <td></td>
                            </tr>
                            <tr>
                                <td><input class="next"  type="submit" value="Finish"> </td>
                                <td><button class="next" type="button" onclick="nextQuestion('<%=listQuiz.size()%>')">Next</button></td>
                            </tr>
                        </tbody>
                    </table>

                </form>
            </div>
        </div>
        <script>
            countDown('<%=totalTime%>');
            nextQuestion('<%=listQuiz.size()%>');
        </script>
    </body>
</html>
