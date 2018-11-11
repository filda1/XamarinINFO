<?php

//Cabeceras
header('Content-Type: application/json');
header("Access-Control-Allow-Origin: *");


if($_GET['moneda']== 'euro' || $_GET['moneda']== 'dolar'){
    
    include_once 'conexion.php';

    $sql = 'SELECT * FROM '.$_GET['moneda'];
    $sentencia = $pdo->prepare($sql);
    $sentencia->execute();
    $datos = $sentencia->fetchAll();


}else{
    echo 'Solicitud no encontrada';
}

echo json_encode($datos);