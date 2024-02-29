<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="table" class="lab2.Table" scope="session"/>
<!DOCTYPE HTML>
<html lang="ru">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <script type="module" src="./js/script.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="css/styles.css"/>
    <title>Вторая лаба</title>
</head>
<body>

<jsp:include page="image.jsp"/>

<div id="form_div">

    <form id="form" action="controller" method="post">

        <label>
            <b>Выберите значение X</b><br>
            <%
                for (int i = -4; i <= 4; i++) {
                    out.println("<input type=\"checkbox\" name=\"x\" value=\"" + i + "\">" + i + "<br>");
                }
            %>
        </label><br>

        <label>
            <b>Введите значение Y (-3..5)</b><br>
            <input required name="y" type="text" maxlength="7"><br>
        </label><br>

        <b>Введите значение R</b><br>
        <%
            for (int i = 1; i <= 5; i++) {
                out.println("<input type=\"button\" name=\"r_possible_values\" value=\"" + i + "\">");
            }
        %>
        <input type="hidden" name="r" value="">
        <input type="hidden" name="currentTime" value="<%=java.time.format.DateTimeFormatter.ofPattern("MM dd yyyy, hh:mm:ss a").format(java.time.LocalDateTime.now())%>">
        <br>
        <input id="send" type="submit" value="Отправить" disabled>
    </form>
    <button id="go_to_table">Посмотреть таблицу</button>
</div>
</body>
</html>