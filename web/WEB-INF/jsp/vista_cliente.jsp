<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="includes/header.jsp" flush="false"/> 


        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <ol class="breadcrumb">
                        <li class="active">Consulta de clientes</li>
                    </ol>               
                </div>
            </div>
            <div class="row">
                <div class="col-md-4">
                    <jsp:include page="includes/menu1.jsp"/>
                </div>
                <div class="col-md-8">
                    <table class="table table-striped table-bordered">
                        <tr>
                            <th>Nombre</th>
                            <th>Apellido</th>
                            <th>Dni</th>
                        </tr>

                        <c:forEach var="l" items="${L}">         
                            <tr>
                                <td><c:out  value="${l.nombre}"/></td>                                    
                                <td><c:out  value="${l.apellido1}"/></td> 
                                <td><c:out  value="${l.dni}"/></td>   
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>


        </div>

        <jsp:include page="includes/footer.jsp"/>       
    </body>
</html>
