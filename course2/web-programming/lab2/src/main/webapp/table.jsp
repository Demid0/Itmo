<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="table" class="lab2.Table" scope="session"/>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <script type="module" src="js/table.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="css/styles.css"/>
    <title>Вторая лаба</title>
</head>
<body>

<jsp:include page="image.jsp"/>

<div id="table">
    <button id="clear_results">Очистить таблицу</button>
    <button id="go_to_form">Вернуться к форме</button>

    <table id='result_table'>
        <tr>
            <th>X</th>
            <th>Y</th>
            <th>R</th>
            <th>Когда выполнялся</th>
            <th>Время выполнения, ms</th>
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
</body>
</html>
