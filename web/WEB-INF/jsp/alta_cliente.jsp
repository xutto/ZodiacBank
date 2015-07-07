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
            function enviar(varI) {
                form1.opcion.value = varI;
                form1.submit();
            }
        </script>
    </head>

    <body>

        <jsp:include page="includes/header.jsp" flush="false"/>

        <div class="container">
            <div class="row">
                <div class="col-lg-12">

                    <ol class="breadcrumb">
                        <li class="active">Formulario de Alta de Usuarios</li>
                    </ol>

                </div>
            </div>

            <div class="row">
                <div class="col-lg-4 col-md-4">
                    <jsp:include page="includes/menu1.jsp" flush="false"/>
                </div>
                <div class="col-lg-4 col-md-4">
                    <form action="alta.htm" id="form" name="form1" role="form">
                        <div class="form-group">
                            <label for="nombre">Nombre</label><br>
                            <input type="text" name="nombre" class="form-control" required/>
                        </div>
                        <div class="form-group">
                            <label for="Apellido1">Apellido1</label>
                            <input type="text" name="apellido1" class="form-control" required/>
                        </div>
                        <div class="form-group">
                            <label for="Apellido2">Apellido2</label>
                            <input type="text" name="apellido2" class="form-control" required/>
                        </div>
                </div>
                <div class="col-lg-4 col-md-4">
                    <div class="form-group">
                        <label for="Email">Email</label>
                        <input type="email" name="email" class="form-control" required/>
                    </div>
                    <div class="form-group">
                        <label for="Direccion">Direccion</label>
                        <input type="text" name="direccion" class="form-control" required/>
                    </div>
                    <div class="form-group">
                        <label for="DNI">DNI</label>
                        <input type="text" name="dni" class="form-control" required/>
                    </div>
                    <div class="form-group">
                        <label for="Telefono">Telefono</label>
                        <input type="text" name="telefono" class="form-control" required/>
                    </div>
                    <input type="hidden" name="opcion"/>
                    <input type="button" class="btn btn-default" value="aceptar" onclick="enviar('alta')"/><br><br>       
                    </form>
                </div>

            </div>
            <div class="row">
                <div class="col-lg-12 col-md-12">
                    <c:out value="${error}"/>
                </div>
            </div>
        </div>
    </div>




    <jsp:include page="includes/footer.jsp"/>
</body>
</html>
