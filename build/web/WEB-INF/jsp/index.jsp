<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/jquery-1.11.0.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.js" type="text/javascript"></script>
        <!-- STILOS CSS-->

        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>Empleados Produccion</title>


        <script src="js/validatr.min.js" type="text/javascript"></script>
        <script language="javascript">
            function enviar(varI){
                form1.opcion.value = varI;
                form1.submit();
            }
        </script>
    </head>

    <body>

        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <p>Formulario de Alta de Usuarios</p>                    
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <p>
                        
                        <c:out value="${nombre}"/> <c:out value="${apellido}"/>
                    </p>                    
                </div>

            </div>
        </div>


        <div class="container">
            <div class="row">
                <div class="col-lg-4 col-md-4">
                    <ul>
                        <li>Alta nuevo cliente</li>
                        <li><a href="baja.htm">Baja cliente</a></li>
                        <li><a href="vista.htm">Vista clientes</a></li>
                    </ul>
                </div>
                <div class="col-lg-8 col-md-8">

                    <form action="alta.htm" id="form" name="form1">
                        <label>Nombre</label><br>
                        <input type="text" name="nombre" required/><br>
                        <label>Apellido1</label><br>
                        <input type="text" name="apellido1" required/><br>
                        <label>Apellido2</label><br>
                        <input type="text" name="apellido2" required/><br>
                        <label>Email</label><br>
                        <input type="text" name="email" required/><br>
                        <label>Direccion</label><br>
                        <input type="text" name="direccion" required/><br>
                        <label>DNI</label><br>
                        <input type="text" name="dni" required/><br>
                        <label>Telefono</label><br>
                        <input type="text" name="telefono" required/><br>
                        
                        <input type="hidden" name="opcion"/>

                        <input type="button" value="aceptar" onclick="enviar('alta')"/><br><br>       
                    </form>
                </div>
            </div>
        </div>





    </body>
</html>
