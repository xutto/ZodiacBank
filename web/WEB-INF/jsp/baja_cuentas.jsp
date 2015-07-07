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
                alert(varI);
                form1.opcion.value = varI;
                alert('hola');

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
                        <li class="active">Baja de cuentas</li>
                    </ol>           
                </div>
            </div>

            <div class="row">
                <div class="col-lg-4 col-md-4">
                    <jsp:include page="includes/menu1.jsp" flush="false"/>
                </div>
                <div class="col-lg-8 col-md-8">                   
                    <form action="AltaCuentas.htm" name="form1">  
                        <div class="form-group">
                            <label>Elija una cuenta: </label>
                            <input type="text" name="cuenta" class="form-control"/>
                        </div>

                        <div class="form-group">
                            <label>Elija el cliente propietario: </label>
                            <input type="text" name="id_cliente" class="form-control"/>  
                        </div>
                        <input type="hidden" name="opcion"/>
                        <input type="button" value="aceptar" class="btn btn-default" onclick="enviar('baja')"/>                     
                    </form>    
                    <c:out value="${error}"/>
                </div>
            </div>
        </div>
        <jsp:include page="includes/footer.jsp"/>
    </body>
</html>
