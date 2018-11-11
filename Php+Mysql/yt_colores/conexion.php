<?php

$link = 'mysql:host=localhost;dbname=yt_colores';
$usuario = 'root';
$pass = 'root';

try{

    $pdo = new PDO($link,$usuario,$pass);

    echo 'Conectado <br>';

}catch (PDOException $e) {
    print "¡Error!: " . $e->getMessage() . "<br/>";
    die();
}