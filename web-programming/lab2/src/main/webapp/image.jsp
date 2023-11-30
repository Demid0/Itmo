<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="table" class="lab2.Table" scope="session" />
<html>
<head>
    <title>Вторая лаба</title>
</head>
<body>
<div id="header">
    <h1>Рязанов Демид Витальевич P3221 вариант 2111</h1>
</div>

<div id="image">
    <svg width="600px" height="600px">

        <!-- arrows -->
        <polygon points="300,0 290,20 310,20" stroke="#2c2d2a"></polygon>
        <polygon points="600,300 580,290 580,310" stroke="#2c2d2a"></polygon>

        <!-- rectangle -->
        <polygon points="200,500 200,300 300,300 300,500" fill="#0783ff"></polygon>

        <!-- triangle -->
        <polygon points="300,100 300,300 500,300" fill="#0783ff"></polygon>

        <!-- circle -->
        <path d="M 200,300 A 100,100 90 0,1 300,200 L 300,300 Z" fill="#0783ff"></path>


        <!-- axis -->
        <line x1="0" x2="600" y1="300" y2="300" stroke="#2c2d2a" ></line>
        <line x1="300" x2="300" y1="0" y2="600" stroke="#2c2d2a" ></line>

        <!-- labels on the axis x -->
        <line x1="100" x2="100" y1="290" y2="310" stroke="#2c2d2a"></line>
        <line x1="200" x2="200" y1="290" y2="310" stroke="#2c2d2a"></line>
        <line x1="400" x2="400" y1="290" y2="310" stroke="#2c2d2a"></line>
        <line x1="500" x2="500" y1="290" y2="310" stroke="#2c2d2a"></line>

        <!-- labels on the axis y -->
        <line x1="290" x2="310" y1="100" y2="100" stroke="#2c2d2a"></line>
        <line x1="290" x2="310" y1="200" y2="200" stroke="#2c2d2a"></line>
        <line x1="290" x2="310" y1="400" y2="400" stroke="#2c2d2a"></line>
        <line x1="290" x2="310" y1="500" y2="500" stroke="#2c2d2a"></line>

        <!-- axis labels -->
        <text x="580" y="280">x</text>
        <text x="310" y="20">y</text>

        <!-- R values on the axis x -->
        <text x="80" y="276">-R</text>
        <text x="170" y="276">-R/2</text>
        <text x="380" y="276">R/2</text>
        <text x="490" y="276">R</text>

        <!-- R values on the axis y -->
        <text x="324" y="108">R</text>
        <text x="324" y="208">R/2</text>
        <text x="324" y="408">-R/2</text>
        <text x="324" y="508">-R</text>

        <c:forEach items="${table.rows}" var="point">
            <circle class="${point.r}" r="3" cx="${300 + (200 * point.x) / point.r}" cy="${300 - (200 * point.y) / point.r}" fill="red" visibility="hidden"></circle>
        </c:forEach>
    </svg>
</div>

</body>
</html>
