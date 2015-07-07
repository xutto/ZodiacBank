
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="includes/header.jsp"/>
        <div class="container">
            <div class="row">
                <div class="col-md-6 col-lg-6">
                    <h3>Acceso usuarios</h3>
                    <c:if test="${a1 == null}" >
                        <div class="form-group">
                        <form action="logger.htm" method="post"><br/>
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
                    <h3><a href="nav1.htm?opcion=empleados">Empleados</a></h3>
                </div>
            </div>    
        </div>

    </body>
</html>
