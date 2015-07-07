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
        <jsp:include page="includes/header.jsp"/>

        <div class="container">
            <div class="row">
                <div class="col-md-3">
                    <jsp:include page="includes/menu2.jsp"/>
                </div>   
                <div class="col-md-9">
                    <h2>Transferencias</h2>
                    
                    
                    <form action="oper_list.htm" method="post" name="form1">
                        <div class="form-group">
                        <label>cuenta origen</label><br/>
                        <select name="cum" class="form-control">
                            <c:forEach var="c" items="${cuentas}">
                                <option value="<c:out value="${c.cnum}"/>"><c:out value="${c.cnom}"/></option>
                            </c:forEach>
                        </select>
                        </div>
                        
                        <div class="form-group">
                        <label>Cuenta destino</label>
                        <input class="form-control" type="text" name="cud"/><br/>
                        </div>
                        
                        <div class="form-group">
                        <label>Importe</label>
                        <input class="form-control" type="text" name="importe"/><br/>
                        </div>
                        
                        <input type="hidden" name="opcion"/>
                        <input class="btn btn-default"  type="button" value="ejecutar" onclick="enviar('transferencias')"/><br/>
                        <c:out value="${error}"/>
                    </form>
                </div>   
            </div>
            <jsp:include page="includes/footer.jsp"/>
        </div>
    </body>
</html>
