<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="js/jquery-1.11.0.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.js" type="text/javascript"></script>
        <!-- STILOS CSS-->

        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>Cliente</title>
    </head>


    <body>

        <!--  SESSION ON    -->
        <c:if test="${Clist != null}">
            <c:set var="cuentas" scope="session" value="${Clist}"/>
            <c:set var="a1" scope="session" value="${ape1}"/>
            <c:set var="n" scope="session" value="${nombre}"/>
            <c:set var="id" scope="session" value="${Cid}"/>
            <c:set var="sClist" scope="session" value="${Clist}"/>
        </c:if>



        <!--  SESSION ON    -->

        <jsp:include page="includes/header.jsp"/>

        <div class="container">
            <div class="row">
                <div class="col-md-3">
                    <jsp:include page="includes/menu2.jsp"/>
                </div>   
                <div class="col-md-9">
                    <h2>PAGINA DE CLIENTE</h2>

                    <table class="table table-striped table-bordered">
                        <tr>
                            <th>Numero de cuenta</th>
                            <th>Alias</th>
                            <th>Saldo</th>
                        </tr>

                        <c:forEach var="cl" items="${sClist}">
                            <tr>                    
                                <td> <c:out value="${cl.cnum}"/><br/></td>
                                <td> <c:out value="${cl.cnom}"/><br/></td>
                                <td> <c:out value="${cl.saldo}"/><br/></td>
                            </tr>
                        </c:forEach>


                    </table>


                </div>                
            </div>


        </div>
        <jsp:include page="includes/footer.jsp"/>
    </body>
</html>
