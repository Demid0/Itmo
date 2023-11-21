<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html lang="ru">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <script type="module" src="./js/script.js"></script>
    <link rel="stylesheet" type="text/css" href="css/styles.css"/>
    <title>Вторая лаба</title>
</head>
<body>

<div id="header">
    <h1>Рязанов Демид Витальевич P3221 вариант 2111</h1>
</div>

<div id="table">

    <button id="clear_results">Очистить таблицу</button> <%-- onclick="clearResults()" --%>

    <div id="response_error">
        <p></p>
    </div>

    <table id='result_table'>
        <tr>
            <th>X</th>
            <th>Y</th>
            <th>R</th>
            <th>Когда выполнялся</th>
            <th>Время выполнения, sec</th>
            <th>Результат</th>
        </tr>
    </table>

</div>

<div id="image">
    <img src="images/graph.png" alt="">
</div>

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
        <input type="hidden" name="executionTime" value="<%=new java.util.Date()%>">
        <br>
        <input id="send" type="submit" value="Отправить" disabled>
    </form>

</div>
</body>
</html>