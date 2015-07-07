<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="js/jquery-1.11.0.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.js" type="text/javascript"></script>
        <!-- STILOS CSS-->

        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <script language="javascript">
            function enviar(varI) {
                form1.opcion.value = varI;
                form1.submit();
            }
        </script>
    </head>


    <body>

        <!--  SESSION ON    -->
        <c:if test="${Clist != null}">
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

                    <c:if test="${cuentas != null}">    
                        <div class="form-group">
                            <form action="oper_list.htm" name="form1" >
                                <div class="form-group">
                                    <select class="form-control" name="cus">
                                        <c:forEach var="cu" items="${cuentas}">
                                            <option value="${cu.cnum}">
                                                <c:out value="${cu.cnom}"/>
                                            </option>
                                        </c:forEach>
                                    </select><br/>
                                    </div>
                                    <input type="hidden" name="opcion"/>
                                    <input type="button" value="aceptar"class="btn btn-default" onclick="enviar('oper_listado')"/><br><br>                               
                            </form>
                        </div>
                    </c:if>

                    <c:if test="${lop != null}">    
                        <table class="table table-striped table-bordered">
                            <tr>
                                <th>Numero de cuenta</th>                           
                                <th>Fecha</th>
                                <th>Movimiento</th>
                                <th>Importe</th>
                                <th>saldo</th>
                            </tr>
                            <c:forEach var="clo" items="${lop}">
                                <tr>                   
                                    <td> <c:out value="${clo.cuenta_local}"/><br/></td>                                   
                                    <td> <c:out value="${clo.hora}"/><br/></td>
                                    <td> <c:out value="${clo.cuenta_externa}"/><br/></td>
                                    <td> <c:out value="${clo.importe}"/><br/></td>
                                    <td> <c:out value="${clo.saldo}"/><br/></td>
                                </tr>
                            </c:forEach>
                        </table>
                        <a href="nav2.htm?opcion=operaciones">atras</a>
                    </c:if>
                </div>                
            </div>


        </div>
        <jsp:include page="includes/footer.jsp"/>
    </body>
</html>
