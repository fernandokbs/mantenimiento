<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>
<table class="striped" id="lugar">
  <thead>
    <tr>
      <th data-field="nombre">
        <a class="waves-effect" onclick="ordNombre();">
          <fmt:message key="formaListadoLugares.etiqueta.nombre" />
        </a>
      </th>
      <th data-field="descripcion">
        <a class="waves-effect" onclick="ordDescripcion();">
          <fmt:message key="formaListadoLugares.etiqueta.descripcion" />
        </a>
      </th>
      <th data-field="poblacion">
        <a class="waves-effect" onclick="ordPoblacion();">
           <fmt:message key="formaListadoLugares.etiqueta.poblacion" />
        </a>
      </th>
      <th data-field="coordenadas">
        <a class="waves-effect" onclick="ordCoordenadas();">
          <fmt:message key="formaListadoLugares.etiqueta.coordenadas" />
        </a>
      </th>
      <th data-field="estado">
        <a class="waves-effect" onclick="ordEstado();">
         <fmt:message key="formaListadoLugares.etiqueta.estado" />
        </a>
      </th>
      <th data-field="pais">
        <a class="waves-effect" onclick="ordPais();">
          <fmt:message key="formaListadoLugares.etiqueta.pais" />
        </a>
      </th>
      <th data-field="moneda">
        <a class="waves-effect" onclick="ordMoneda();">
          <fmt:message key="formaListadoLugares.etiqueta.moneda" />
        </a>
      </th>
      <th data-field="administracion">
        <fmt:message key="formaListadoLugares.etiqueta.administracion" />
      </th>
    </tr>
  </thead>

  <tbody>
    <c:forEach var="lugar" items="${formaListadoLugares.lugares}">
      <tr>
          
        <td align="left" width="20%"><c:out value="${lugar.nombre}"/></td>
        <td align="left" width="60%"><c:out value="${lugar.descripcion}"/></td>
        <td align="left" width="60%"><c:out value="${lugar.poblacion}"/></td>
        <td align="left" width="60%"><c:out value="${lugar.coordenadas}"/></td>
        <td align="left" width="60%"><c:out value="${lugar.estado}"/></td>
        <td align="left" width="60%"><c:out value="${lugar.pais}"/></td>
        <td align="left" width="60%"><c:out value="${lugar.moneda}"/></td>
        <td>

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
</tbody>
</table>

<script type="text/javascript">
$(document).ready(function(){
  // the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered
  $('.modal').modal();
});
</script>
