<?php

$bd_path = __DIR__ . '/bancotreinar.sqlite';
$pdo = new PDO('sqlite:'. $bd_path);

$sql = "INSERT INTO videos (url, title) VALUES (?, ?)";
$statement = $pdo->prepare($sql);
$statement->bindValue(1, $_POST['url']);
$statement->bindValue(2, $_POST['titulo']);

if ($statement->execute() === false) {
    header('Location: /index.php?sucesso=0');
} else {
    header('Location: /index.php?sucesso=1');
};
