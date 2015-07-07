<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/jquery-1.11.0.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.js" type="text/javascript"></script>
        <!-- STILOS CSS-->

        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>Página empleado</title>
    </head>
    <body>
        <c:set var="a1" scope="session" value="${ape1}"/>
        <c:set var="n" scope="session" value="${nombre}"/>
        <jsp:include page="includes/header.jsp" flush="false"/>

        <div class="container">
            <div class="row">
                <div class="col-md-4">
                    <jsp:include page="includes/menu1.jsp" flush="false"/>
                </div>
                <div class="col-md-8">
                    <h2>Area de gestion de usuarios</h2>
                </div>
            </div>
        </div>
    </body>
</html>
