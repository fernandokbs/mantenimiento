<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>
<table class="striped" id="triplan">
  <thead>
    <tr>
      <th data-field="nombre">
        <a class="waves-effect" onclick="ordNombre();">
          <fmt:message key="formaListadoTriplanes.etiqueta.nombre" />
        </a>
      </th>
      <th data-field="descripcion">
        <a class="waves-effect" onclick="ordDescripcion();">
          <fmt:message key="formaListadoTriplanes.etiqueta.descripcion" />
        </a>
      </th>
      <th data-field="poblacion">
        <a class="waves-effect" onclick="ordPoblacion();">
           <fmt:message key="formaListadoTriplanes.etiqueta.poblacion" />
        </a>
      </th>
      <th data-field="coordenadas">
        <a class="waves-effect" onclick="ordCoordenadas();">
          <fmt:message key="formaListadoTriplanes.etiqueta.coordenadas" />
        </a>
      </th>
      <th data-field="estado">
        <a class="waves-effect" onclick="ordEstado();">
         <fmt:message key="formaListadoTriplanes.etiqueta.estado" />
        </a>
      </th>
      <th data-field="pais">
        <a class="waves-effect" onclick="ordPais();">
          <fmt:message key="formaListadoTriplanes.etiqueta.pais" />
        </a>
      </th>
      <th data-field="moneda">
        <a class="waves-effect" onclick="ordMoneda();">
          <fmt:message key="formaListadoTriplanes.etiqueta.moneda" />
        </a>
      </th>
      <th data-field="administracion">
        <fmt:message key="formaListadoTriplanes.etiqueta.administracion" />
      </th>
    </tr>
  </thead>

  <tbody>
    <c:forEach var="triplan" items="${formaListadoTriplanes.triplanes}">
      <tr>
          
        <td align="left" width="20%"><c:out value="${triplan.nombre}"/></td>
        <td align="left" width="60%"><c:out value="${triplan.descripcion}"/></td>
        <td align="left" width="60%"><c:out value="${triplan.poblacion}"/></td>
        <td align="left" width="60%"><c:out value="${triplan.coordenadas}"/></td>
        <td align="left" width="60%"><c:out value="${triplan.estado}"/></td>
        <td align="left" width="60%"><c:out value="${triplan.pais}"/></td>
        <td align="left" width="60%"><c:out value="${triplan.moneda}"/></td>
        <td>

        <td align="left" width="20%">
            <a href='solicitarModificarLugar.do?id=<c:out value="${triplan.id}"/>&descripcion=<c:out value="${triplan.descripcion}"/>
               &nombre=<c:out value="${triplan.nombre}"/>
               &coordenadas=<c:out value="${triplan.coordenadas}"/>
               &imagen=<c:out value="${triplan.imagen}"/>
               &estado=<c:out value="${triplan.estado}"/>
               &pais=<c:out value="${triplan.pais}"/>
               &moneda=<c:out value="${triplan.moneda}"/>
               &poblacion=<c:out value="${triplan.poblacion}"/>
               ' 
               class="waves-effect waves-light blue btn">
                <fmt:message key="formaListadoLugares.etiqueta.modificar" />
                <i class="material-icons left">mode_edit</i>
            </a> 
        </td>
        <td>
            <a class="waves-effect waves-light red btn" href='procesarEliminarTriplan.do?id=<c:out value="${triplan.id}"/>'  
               onClick="javascript: return EliminarLugar('<c:out value="${triplan.nombre}"/>') "
               class="HipervinculoAdmon">
                <fmt:message key="formaListadoTriplanes.etiqueta.eliminar" />
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
