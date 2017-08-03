<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>
<table class="striped" id="restaurante">
  <thead>
    <tr>
      <th data-field="nombre">
        <a class="waves-effect" onclick="ordNombre();">
          <fmt:message key="formaListadoRestaurantes.etiqueta.nombre" />
        </a>
      </th>
      <th data-field="descripcion">
        <a class="waves-effect" onclick="ordDescripcion();">
          <fmt:message key="formaListadoRestaurantes.etiqueta.descripcion" />
        </a>
      </th>
      <th data-field="precio">
        <a class="waves-effect" onclick="ordPrecio();">
           <fmt:message key="formaListadoRestaurantes.etiqueta.precio" />
        </a>
      </th>
      <th data-field="direccion">
        <a class="waves-effect" onclick="ordDireccion();">
          <fmt:message key="formaListadoRestaurantes.etiqueta.direccion" />
        </a>
      </th>
      <th data-field="estado">
        <a class="waves-effect" onclick="ordEstado();">
         <fmt:message key="formaListadoRestaurantes.etiqueta.estado" />
        </a>
      </th>
      <th data-field="pais">
        <a class="waves-effect" onclick="ordPais();">
          <fmt:message key="formaListadoRestaurantes.etiqueta.pais" />
        </a>
      </th>
      <th data-field="horario">
        <a class="waves-effect" onclick="ordHorario();">
          <fmt:message key="formaListadoRestaurantes.etiqueta.horario" />
        </a>
      </th>
      <th data-field="administracion">
        <fmt:message key="formaListadoRestaurantes.etiqueta.administracion" />
      </th>
    </tr>
  </thead>

  <tbody>
    <c:forEach var="restaurante" items="${formaListadoRestaurantes.restaurantes}">
      <tr>
          
        <td align="left" width="20%"><c:out value="${restaurante.nombre}"/></td>
        <td align="left" width="60%"><c:out value="${restaurante.descripcion}"/></td>
        <td align="left" width="60%"><c:out value="${restaurante.precio}"/></td>
        <td align="left" width="60%"><c:out value="${restaurante.direccion}"/></td>
        <td align="left" width="60%"><c:out value="${restaurante.estado}"/></td>
        <td align="left" width="60%"><c:out value="${restaurante.pais}"/></td>
        <td align="left" width="60%"><c:out value="${restaurante.horario}"/></td>
        <td>

        <td align="left" width="20%">
            <a href='solicitarModificarRestaurante.do?id=<c:out value="${restaurante.id}"/>&descripcion=<c:out value="${restaurante.descripcion}"/>
               &nombre=<c:out value="${restaurante.nombre}"/>
               &coordenadas=<c:out value="${restaurante.direccion}"/>
               &imagen=<c:out value="${restaurante.imagen}"/>
               &estado=<c:out value="${restaurante.estado}"/>
               &pais=<c:out value="${restaurante.pais}"/>
               &moneda=<c:out value="${restaurante.precio}"/>
               &poblacion=<c:out value="${restaurante.horario}"/>
               ' 
               class="waves-effect waves-light blue btn">
                <fmt:message key="formaListadoRestaurantes.etiqueta.modificar" />
                <i class="material-icons left">mode_edit</i>
            </a> 
        </td>
        <td>
            <a class="waves-effect waves-light red btn" href='procesarEliminarRestaurante.do?id=<c:out value="${restaurante.id}"/>'  
               onClick="javascript: return EliminarLugar('<c:out value="${restaurante.nombre}"/>') "
               class="HipervinculoAdmon">
                <fmt:message key="formaListadoRestaurantes.etiqueta.eliminar" />
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
