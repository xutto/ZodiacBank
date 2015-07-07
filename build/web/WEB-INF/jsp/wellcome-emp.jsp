<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/jquery-1.11.0.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.js" type="text/javascript"></script>
        <!-- STILOS CSS-->

        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>wellcome-emp</title>
    </head>
    <body>
        <jsp:include page="includes/header.jsp"/>
        <div class="container">
            <div class="row">
                <div class="col-md-6 col-lg-6">
                    <h3>Acceso usuarios</h3>
                    <c:if test="${a1 == null}" >
                        <div class="form-group">
                            <form action="logger_emp.htm" method="post"><br/>
                                <label>Usuario</label><br/>
                                <input type="text" name="user" class="form-control"/>
                        </div>

                        <div class="form-group">
                            <label>Contraseña</label><br/>
                            <input type="password" name="pass" class="form-control"/><br/>
                            <input type="submit" value="aceptar" class="btn btn-default"/>
                            <c:out value="${error}" />
                        </div>
                        </form>

                    </c:if>
                </div>
                <div class="col-lg-4 text-right">
                    <h3><a href="nav1.htm?opcion=wellcome">Clientes</a></h3>
                </div>
            </div>    
        </div>
    </body>
</html>
