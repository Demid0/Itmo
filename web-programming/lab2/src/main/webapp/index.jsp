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

<div id="header">
    <h1>Рязанов Демид Витальевич P3221 вариант 2111</h1>
</div>

<div id="table">
    <button id="clear_results">Очистить таблицу</button>

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
        <c:forEach items="${table.rows}" var="row">
            <tr>
                <th>${row.x}</th>
                <th>${row.y}</th>
                <th>${row.r}</th>
                <th>${row.localTime}</th>
                <th>${row.executionTime}</th>
                <th>${row.result}</th>
            </tr>
        </c:forEach>
    </table>

</div>

<div id="image">
    <svg width="300px" height="300px">

        <!-- arrows -->
        <polygon points="150,0 145,10 155,10" stroke="#2c2d2a"></polygon>
        <polygon points="300,150 290,145 290,155" stroke="#2c2d2a"></polygon>

        <!-- rectangle -->
        <polygon points="100,250 100,150 150,150 150,250" fill="#0783ff"></polygon>

        <!-- triangle -->
        <polygon points="150,50 150,150 250,150" fill="#0783ff"></polygon>

        <!-- circle -->
        <path d="M 100,150 A 50,50 90 0,1 150,100 L 150,150 Z" fill="#0783ff"></path>


        <!-- axis -->
        <line x1="0" x2="300" y1="150" y2="150" stroke="#2c2d2a" ></line>
        <line x1="150" x2="150" y1="0" y2="300" stroke="#2c2d2a" ></line>

        <!-- labels on the axis x -->
        <line x1="50" x2="50" y1="145" y2="155" stroke="#2c2d2a"></line>
        <line x1="100" x2="100" y1="145" y2="155" stroke="#2c2d2a"></line>
        <line x1="200" x2="200" y1="145" y2="155" stroke="#2c2d2a"></line>
        <line x1="250" x2="250" y1="145" y2="155" stroke="#2c2d2a"></line>

        <!-- labels on the axis y -->
        <line x1="145" x2="155" y1="50" y2="50" stroke="#2c2d2a"></line>
        <line x1="145" x2="155" y1="100" y2="100" stroke="#2c2d2a"></line>
        <line x1="145" x2="155" y1="200" y2="200" stroke="#2c2d2a"></line>
        <line x1="145" x2="155" y1="250" y2="250" stroke="#2c2d2a"></line>

        <!-- axis labels -->
        <text x="290" y="140">x</text>
        <text x="155" y="10">y</text>

        <!-- R values on the axis x -->
        <text x="40" y="138">-R</text>
        <text x="85" y="138">-R/2</text>
        <text x="190" y="138">R/2</text>
        <text x="245" y="138">R</text>

        <!-- R values on the axis y -->
        <text x="162" y="54">R</text>
        <text x="162" y="104">R/2</text>
        <text x="162" y="204">-R/2</text>
        <text x="162" y="254">-R</text>


    </svg>
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