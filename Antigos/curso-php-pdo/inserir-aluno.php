<?php

require 'vendor/autoload.php';

use \Alura\Pdo\Domain\Model\Student;

$caminhoBanco = __DIR__ . '/banco.sqlite';
$pdo = new PDO('sqlite:' . $caminhoBanco);


$student = new Student(null, 'Felipe da Silva Passos', new \DateTimeImmutable('1986-05-26'));

$sqlInsert = "INSERT INTO students (name, birth_date) VALUES ('{$student->name()}','{$student->birthDate()->format('Y-m-d')}')";

var_dump($pdo->exec($sqlInsert));