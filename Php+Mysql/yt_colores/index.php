<?php

include_once 'conexion.php';

//LEER
$sql_leer = 'SELECT * FROM colores';
$gsent = $pdo->prepare($sql_leer);
$gsent->execute();
$resultado = $gsent->fetchAll();

//var_dump($resultado);

//AGREGAR
if($_POST){
    $color =  $_POST['color'];
    $descripcion = $_POST['descripcion'];

    $sql_agregar = 'INSERT INTO colores (color,descripcion) VALUES (?,?)';
    $sentencia_agregar = $pdo->prepare($sql_agregar);
    $sentencia_agregar->execute(array($color,$descripcion));

    //cerramos conexión base de datos y sentencia
    $sentencia_agregar = null;
    $pdo = null;
    header('location:index.php');

}

if($_GET){
    $id = $_GET['id'];
    $sql_unico = 'SELECT * FROM colores WHERE id=?';
    $gsent_unico = $pdo->prepare($sql_unico);
    $gsent_unico->execute(array($id));
    $resultado_unico = $gsent_unico->fetch();

    //var_dump($resultado_unico);
    $gsent_unico = null;
}


?>

<!doctype html>
<html lang="es">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.10/css/all.css" integrity="sha384-+d0P83n9kaQMCwj8F4RJB66tzIwOKmrdb46+porD/OvrJ+37WqIM7UoBtwHO6Nlg" crossorigin="anonymous">

    <title>Hello, world!</title>
  </head>
  <body>
    
    <div class="container mt-5">
        <div class="row">
            
            <div class="col-md-6">
                <h2>MIS COLORES</h2>
                <?php foreach($resultado as $dato): ?>
                
                <div 
                class="alert alert-<?php echo $dato['color'] ?> text-uppercase" 
                role="alert">
                    <?php echo $dato['color'] ?>
                    - 
                    <?php echo $dato['descripcion'] ?>

                    <a href="eliminar.php?id=<?php echo $dato['id'] ?>" class="float-right ml-3">
                        <i class="far fa-trash-alt"></i>
                    </a>

                    <a href="index.php?id=<?php echo $dato['id'] ?>" class="float-right">
                        <i class="fas fa-pencil-alt"></i>
                    </a>
                </div>

                <?php endforeach ?>
            
            </div>

            <div class="col-md-6">
                <?php if(!$_GET): ?>
                <h2>AGREGAR ELEMENTOS</h2>
                <form method="POST">
                    <input type="text" class="form-control" name="color">
                    <input type="text" class="form-control mt-3" name="descripcion">
                    <button class="btn btn-primary mt-3">Agregar</button>
                </form>
                <?php endif ?>

                <?php if($_GET): ?>
                <h2>EDITAR ELEMENTOS</h2>
                <form method="GET" action="editar.php">
                    <input type="text" class="form-control" name="color"
                    value="<?php echo $resultado_unico['color'] ?>">
                    <input type="text" class="form-control mt-3" name="descripcion"
                    value="<?php echo $resultado_unico['descripcion'] ?>">
                    <input type="hidden" name="id"
                    value="<?php echo $resultado_unico['id'] ?>">
                    <button class="btn btn-primary mt-3">Agregar</button>
                </form>
                <?php endif ?>
            </div>
        
        </div>
        
    </div>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
  </body>
</html>

<?php 

//cerramos conexión base de datos y sentencia
$pdo = null;
$gsent = null;

?>