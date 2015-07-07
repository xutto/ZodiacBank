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



        <div class="container">
            <div class="row">
                <div class="col-md-4">
                    
                </div>
                <div class="col-md-12 center-block">
                    <img src="img-custom/banner2.png" alt="" width="100%"/>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    
                    <h3> <c:out value="${n}"/> <c:out value="${a1}"/></h3>
                    <c:if test="${n != null}">
                    <p><a href="nav1.htm?opcion=wellcome">Logout</a></p>
                    </c:if>
                </div>
            </div>


        </div>
    </body>
</html>
