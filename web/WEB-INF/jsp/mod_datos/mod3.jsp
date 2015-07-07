<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="js/jquery-1.11.0.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.js" type="text/javascript"></script>
        <!-- STILOS CSS-->

        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>Transferencias</title>
        <script language="javascript">
            function enviar(varI) {
                form1.opcion.value = varI;
                form1.submit();
            }
        </script>
    </head>
    <body>    
        <jsp:include page="../includes/header.jsp"/>
  
        <div class="container">
            <div class="row">
                <div class="col-md-3">
                    <jsp:include page="../includes/menu2.jsp"/>
                </div>   
                <div class="col-md-9">
                    <h2>Modificacion de datos personales</h2>

                    <table class="table table-striped table-bordered">
                        <tr>
                            <th>Nombre</th>
                            <th>Primer apellido</th>
                            <th>Segundo Apellido</th>
                            <th>Direccion</th>
                            <th>DNI</th>
                            <th>Telefono</th>
                            <th>Email</th>
                            <th>Password</th>                                      
                        </tr>
                        <c:forEach var="mod_user" items="${ultra}">
                        <tr>                            
                            <td><c:out value="${mod_user.nombre}"/></td>
                            <td><c:out value="${mod_user.apellido1}"/></td>
                            <td><c:out value="${mod_user.apellido2}"/></td>
                            <td><c:out value="${mod_user.direccion}"/></td>
                            <td><c:out value="${mod_user.dni}"/></td>
                            <td><c:out value="${mod_user.telefono}"/></td>
                            <td><c:out value="${mod_user.email}"/></td>
                            <td><c:out value="${mod_user.password}"/></td>
                        </tr>
                        </c:forEach>

                    </table>


                    <form action="nav2.htm" method="post" name="form1">
                        <label>introduzca nueva clave </label>           
                        <input type="text" name="el_mod"/>
                        <input type="hidden" name="opcion"/>
                        <input type="hidden" name="modu" value="c"/>

                        <input type="button" class="btn btn-default" value="aceptar" onclick="enviar('mod_datos')"/>
                    </form>
                </div>   
            </div>
            <jsp:include page="../includes/footer.jsp"/>
        </div>
    </body>
</html>
