<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="list-group">
            <ul>
                <li class="list-group-item active">Panel de cliente</li>
                <li class="list-group-item"><a href="nav2.htm?opcion=pGlobal">Posicion Global</a></li>
                <li class="list-group-item"><a href="nav2.htm?opcion=operaciones">Movimientos</a></li>
                <li class="list-group-item"><a href="nav2.htm?opcion=transferencias">Realizar transferencia</a></li>
            </ul>   
            <ul>   
                <li class="list-group-item active">Datos personales</li>
                <li class="list-group-item"><a href="nav2.htm?opcion=mod_datos">Consultar datos personales</a></li>
                <li class="list-group-item"><a href="nav2.htm?opcion=mod_datos&subform=a">Modificar email</a></li>
                <li class="list-group-item"><a href="nav2.htm?opcion=mod_datos&subform=b">Modificar teléfono</a></li>
                <li class="list-group-item"><a href="nav2.htm?opcion=mod_datos&subform=c">Modificar clave</a></li>
            </ul>
        </div>
    </body>
</html>
