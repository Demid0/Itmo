<?php

header("Access-Control-Allow-Origin: *");
date_default_timezone_set('Europe/Moscow');
session_start();

if ($_SERVER['REQUEST_METHOD'] === 'GET'){
    $initialTime = microtime(true);
    $x = floatval($_GET['X']);
    $y = floatval($_GET['Y']);
    $r = floatval($_GET['R']);

    if (validate($x, $y, $r)) {
        $result = isHit($x, $y, $r);
        $currentTime = date('H:i:s');
        $executionTime = number_format(($initialTime - $_SERVER['REQUEST_TIME_FLOAT'])*1000, 3);

        $receivedData = [
            'X' => $x, 'Y' => $y, 'R' => $r,
            'currentTime' => $currentTime,
            'executionTime' => $executionTime,
            'result' => $result
        ];
        header('Content-Type: application/json');
        echo json_encode($receivedData);
        http_response_code(201);
    } else {
        echo json_encode(['error' => 'invalid data']);
        http_response_code(400);
    }
} else {
    echo json_encode(['error' => 'missing data']);
    http_response_code(400);
}

function validate($x, $y, $r) : bool {
    if (!(is_float($x) && is_float($y) && is_float($r))) return false;
    if (!(-2 <= $x && $x <= 2)) return false;
    if (!(-5 <= $y && $y <= 5)) return false;
    if (!(-2 <= $r && $r <= 5)) return false;
    return true;
}

function isHit($x, $y, $r): bool {
    if (inTriangle($x, $y, $r) || inRectangle($x, $y, $r) || inCircle($x, $y, $r)) return true;
    else return false;
}

function inRectangle($x, $y, $r) : bool {
    if (0 <= $x && $x <= $r && 0 <= $y && $y <= $r/2) return true;
    else return false;
}

function inTriangle($x, $y, $r) : bool {
    if (0 >= $x && 0 <= $y && $y <= $x + $r) return true;
    else return false;
}

function inCircle($x, $y, $r) : bool {
    if (0 <= $x && 0 >= $y && $x^2 + $y^2 <= ($r/2)^2) return true;
    else return false;
}