<?php

$bd_path = __DIR__ . '/bancotreinar.sqlite';
$pdo = new PDO('sqlite:'. $bd_path);
$pdo->exec('CREATE TABLE videos (id INTEGER PRIMARY KEY, url TEXT, title TEXT);');