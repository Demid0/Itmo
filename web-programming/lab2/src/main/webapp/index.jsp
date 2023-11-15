<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html lang="ru">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
    <script src="js/script.js" defer></script>
    <link rel="stylesheet" type="text/css" href="css/styles.css"/>
    <title>Вторая лаба</title>
</head>
<body>

<div id="header">
    <h1>Рязанов Демид Витальевич P3221 вариант 2111</h1>
</div>

<div id="table">

    <button id="clear_results">Очистить таблицу</button> <%-- onclick="clearResults()" --%>

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

    <form id="form">

        <div class="error_string">
            <p></p>
        </div>

        <label>
            <b>Выберите значение X</b><br>
            <%
                for (int i = -4; i <= 4; i++) {
                    out.println("<input type=\"checkbox\" name=\"x\" value=\"" + i + "\">" + i + "<br>");
                }
            %>
        </label><br>

        <div class="error_string">
            <p></p>
        </div>

        <label>
            <b>Введите значение Y (-3..5)</b><br>
            <input required name="y" type="text" maxlength="7"><br>
        </label><br>

        <div class="error_string">
            <p></p>
        </div>

        <b>Введите значение R</b><br>
        <%
            for (int i = 1; i <= 5; i++) {
                out.println("<input type=\"button\" class=\"r\" name=\"r\" value=\"" + i + "\" onclick=\"changeColor(this)\">");
            }
        %>
        <br>

        <input id="send" type="submit" value="Отправить">

    </form>
</div>
</body>
</html>