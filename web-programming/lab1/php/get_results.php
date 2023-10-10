<?php
session_start();

$previousData = $_SESSION['result_table'] ?? array();

header('Content-type: application/json');
echo json_encode($previousData);