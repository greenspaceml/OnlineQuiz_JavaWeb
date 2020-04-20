

<%@page import="java.util.ArrayList"%>
<%@page import="model.Question"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/manageQuiz.css" rel="stylesheet" type="text/css"/>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <script src="javascript/js.js" type="text/javascript"></script>
        <title>JSP Page</title>

        <%
            int totalQuestions = (int) request.getAttribute("totalQuestions");
            int pageCount = (int) request.getAttribute("pageCount");
            ArrayList<Question> listQuestions = (ArrayList<Question>) request.getAttribute("listQuestions");
            int index = (int) request.getAttribute("index");
            String error = (String) request.getAttribute("error");
        %>
    </head>
    <body>
        <div class="container">
            <div class="header">
                <%@include file="header.jsp" %>
            </div>
            <div class="main">
                <%if (error == null) {%>
                <div class="wellcome">Number of questions: <span class="username"><%=totalQuestions%></span></div>
                <table>
                    <colgroup>
                        <col class="labelCol">
                        <col class="fieldCol">
                        <col class="fieldAction">
                    </colgroup>
                    <thead>
                        <tr class="quiz">
                            <td class="username">Question</td>
                            <td class="username">DateCreated</td>
                            <td class="username">Action</td>
                        </tr>
                    </thead>
                    <tbody>
                        <%for (Question elem : listQuestions) {%>
                        <tr>
                            <td ><div class="quiz"><%=elem.getContent()%></div></td>
                            <td><%=elem.getDateFormat()%></td>
                            <td><a onclick="delQuestion('<%=elem.getId()%>','<%=index%>')">Delete</a></td>
                        </tr>
                        <%}%>


                    </tbody>
                </table>
                <div class="paging">
                    <%for (int i = 1; i <= pageCount; i++) {%>
                    <%if (i == index) {%>
                    
                    <a class="here"><%=i%></a>
                    <%}
                    else {%>
                    <a href="manageQuiz?index=<%=i%>"><%=i%></a>
                    <%}%>
                    <%}%>
                </div>
                <%}
                else {%>
                <%=error%>
                <%}%>


            </div>
        </div>
    </body>
</html>
