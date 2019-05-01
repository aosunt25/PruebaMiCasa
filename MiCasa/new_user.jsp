<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <title>New User</title>
    <meta charset=utf-8>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <link rel="stylesheet" type="text/css" href="css/new_user-styles.css">

</head>

<body>
    <header>
        <img src="img/1.jpg"> Comercializadora MiCasa
    </header>

    <br>
    <br>
    <br>
    <br>
    <br>

    <h1>Registrar Nuevo Usuario</h1>
    <br>
    <form method="post" action="./CrearUsuario">
        <ul class="user-list">

            <li><input type="text" placeholder="Nombre" name="Nombre" class="formx" required></li>
            <br>
            <li><input type="text" placeholder="Apellidos" name="Apellidos" clasS="formx" required></li>
            <br>

            <li><input type="text" name="Usuario" clasS="formx" placeholder="Usuario"></li>
            <br>

            <li><input class="formx" type="password" name="password" placeholder="Contrasena" required></li>
            <br>



            <br>
            <li><a href="menu.jsp"><input class="button_settings-1" type="submit" value="Agregar"></a></li>
            <br>
            <br>
            <a href="./menu.jsp"><input class="button_settings-1" type="button" value="Regresar"></a>

            <br>
        </ul>
    </form>

</body>

</html>
