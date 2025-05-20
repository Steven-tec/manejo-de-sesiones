<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8"%>
<!-- Directiva JSP que establece el tipo de contenido de la página como HTML codificado en UTF-8 -->

<!-- Documento HTML estándar -->
<!DOCTYPE html>
<html lang="en">

<!-- Encabezado del documento -->
<head>
    <!-- Especifica la codificación de caracteres para el navegador -->
    <meta charset="UTF-8">

    <!-- Título que aparece en la pestaña del navegador -->
    <title>Login</title>
</head>

<!-- Cuerpo del documento -->
<body>

<!-- Encabezado de nivel 1 que indica el propósito de la página -->
<h1>Login de usuario</h1>

<!-- Contenedor del formulario -->
<div>
    <!-- Formulario de autenticación que envía los datos por método POST al servlet /login -->
    <form action="/manejo-de-sesiones/login" method="post">

        <!-- Campo de entrada para el nombre de usuario -->
        <div>
            <label for="username">Nombre de usuario:</label>
            <div>
                <input type="text" name="username" id="username">
            </div>
        </div>

        <!-- Campo de entrada para la contraseña -->
        <div>
            <label for="pass">Password:</label>
            <div>
                <input type="password" name="password" id="pass">
            </div>
        </div>

        <!-- Botón para enviar el formulario -->
        <div>
            <input type="submit" value="Enviar">
        </div>
    </form>
</div>

</body>
</html>
