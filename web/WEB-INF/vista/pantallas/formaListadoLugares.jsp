<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>
<style>
    .HipervinculoAdmon{
        color:#000000;
        text-decoration:none;
    }

    .HipervinculoAdmon:hover{
        color:#006666;
        text-decoration:underline;
    }
</style>
<script language="javascript" type="text/javascript">
<!--
    function EliminarLugar(strLugarName) {
        return confirm("¿Desea eliminar el estado '" + strLugarName + "'?")
    }
-->
</script>
<br>
<div class="center-align">
    <h1><fmt:message key="formaListadoLugares.titulo" /></h1>
</div>

<div class="
     ">
    <div class="container">
        <table class="bordered">

            <div class="fixed-action-btn">
                <a href="solicitarRegistroLugar.do" class="btn-floating btn-large waves-effect waves-light red" >
                    <i class="material-icons">add</i>
                </a>
            </div>
            <tr>
            <div>
               
            </div>
            </tr>
            <tr>
                <td><b><fmt:message key="formaListadoLugares.etiqueta.nombre" /></b></td>
                <td><b><fmt:message key="formaListadoLugares.etiqueta.descripcion" /></b></td>
                <td><b><fmt:message key="formaListadoLugares.etiqueta.poblacion" /></b></td>
                <td><b><fmt:message key="formaListadoLugares.etiqueta.coordenadas" /></b></td>
                <td><b><fmt:message key="formaListadoLugares.etiqueta.estado" /></b></td>
                <td><b><fmt:message key="formaListadoLugares.etiqueta.pais" /></b></td>
                <td><b><fmt:message key="formaListadoLugares.etiqueta.moneda" /></b></td>

                <td colspan="2"><b><fmt:message key="formaListadoLugares.etiqueta.administracion" /></b></td>
            </tr>
            <c:forEach var="lugar" items="${formaListadoLugares.lugares}">
                <tr>
                    <td align="left" width="20%"><c:out value="${lugar.nombre}"/></td>
                    <td align="left" width="60%"><c:out value="${lugar.descripcion}"/></td>
                    <td align="left" width="60%"><c:out value="${lugar.poblacion}"/></td>
                    <td align="left" width="60%"><c:out value="${lugar.coordenadas}"/></td>
                    <td align="left" width="60%"><c:out value="${lugar.estado}"/></td>
                    <td align="left" width="60%"><c:out value="${lugar.pais}"/></td>
                    <td align="left" width="60%"><c:out value="${lugar.moneda}"/></td>

                    <td align="left" width="20%">
  
                            <a href='solicitarModificarLugar.do?id=<c:out value="${lugar.id}"/>&descripcion=<c:out value="${lugar.descripcion}"/>
                               &nombre=<c:out value="${lugar.nombre}"/>
                               &coordenadas=<c:out value="${lugar.coordenadas}"/>
                               &imagen=<c:out value="${lugar.imagen}"/>
                               &estado=<c:out value="${lugar.estado}"/>
                               &pais=<c:out value="${lugar.pais}"/>
                               &moneda=<c:out value="${lugar.moneda}"/>
                               &poblacion=<c:out value="${lugar.poblacion}"/>
                               ' 
                               class="waves-effect waves-light blue btn">
                               
                                <fmt:message key="formaListadoLugares.etiqueta.modificar" />
                                <i class="material-icons left">mode_edit</i>
                            </a>
                        
                    </td>
                    <td>
                        <a class="waves-effect waves-light red btn" href='procesarEliminarLugar.do?id=<c:out value="${lugar.id}"/>'  
                           onClick="javascript: return EliminarLugar('<c:out value="${lugar.nombre}"/>') "
                           class="HipervinculoAdmon">
                            <fmt:message key="formaListadoLugares.etiqueta.eliminar" />
                        </a>
                       
                    </td>
                </tr>
            </c:forEach>
                <div>
                    <p>Total: ${formaListadoLugares.contador}</p>
                </div>
            
        </table>
    </div>
</div>