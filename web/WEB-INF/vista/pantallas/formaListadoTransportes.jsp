<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>

<style media="screen">
div.card{
  margin: 50px;
}
</style>

<script language="javascript" type="text/javascript">
function EliminarTransporte(tipo){
  return confirm("¿Desea eliminar el Usuario '" + tipo + "'?")
}
</script>

<script type="text/javascript" src="js/jquery.tablesorter.js"></script>

<h1 style="text-align:center;">
  <fmt:message key="formaListadoTransporte.titulo" />
</h1>

<div class="fixed-action-btn">
  <a href="solicitarAgregarTransporte.do" class="btn-floating btn-large waves-effect waves-light red"><i class="material-icons">add</i></a>
</div>

<div class="card" id=cardT>
  <table class="striped" id="usuario">
    <thead>
      <tr>
        <th data-field="nombre">
          <a class="waves-effect" onclick="ordNombre('nombre');">
            <fmt:message key="formaListadoTransporte.etiqueta.tipo" />
          </a>
        </th>
        <th data-field="descripcion">
          <a class="waves-effect" onclick="ordDescripcion('descripcion');">
            <fmt:message key="formaListadoTransporte.etiqueta.capacidad" />
          </a>
        </th>
        
        <th data-field="administracion">
          <fmt:message key="formaListadoTransporte.etiqueta.administracion" />
        </th>
      </tr>
    </thead>

    <tbody>
      <c:forEach var="transporte" items="${formaListadoTransporte.transporte}">
        <tr>
          <td>

            <a class="waves-effect" href="#modal${transporte.id}">${transporte.tipo}</a>

            <div id="modal${usuario.id}" class="modal">
              <div class="modal-content">

                <div class="card">
                  <div class="card-image">
                    <span class="card-title">${transporte.tipo}</span>
                  </div>
                </div>


              </div>
            </div>

          </td>
           
          <td>

            <a href='solicitarEditarTransporte.do?id=<c:out value="${transporte.id}"/>&apellidoPaterno=<c:out value="${transporte.tipo}"/> class="waves-effect waves-light blue btn">
            <i class="material-icons left">mode_edit</i>
            <fmt:message key="formaListadoTransporte.etiqueta.modificar" />
          </a>
          <a href='procesarEliminarTransporte.do?id=<c:out value="${transporte.id}"/>' class="waves-effect waves-light red btn" onClick="javascript: return EliminarTransporte('<c:out value="${transporte.getTipo()}"/>')">
          <i class="material-icons left">delete</i>
          <fmt:message key="formaListadoTransporte.etiqueta.eliminar" />
        </a>
      </td>
    </tr>
  </c:forEach>
</tbody>
</table>
</div>

<script type="text/javascript">
  $(document).ready(function() {
    $("#usuario").tablesorter();
  } );
  $(document).ready(function(){
    // the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered
    $('.modal').modal();
  });

  function ordenarPor( attribute ) {
    console.log("Alex implementa un ajax aqui");
  }

  function ordNombre(){
    ordenarPor("Nombre");
  }
  function ordDescripcion(){
   ordenarPor("Descripcion");
  }
  function ordPrecio(){
   ordenarPor("Precio");
  }
  function ordHorario(){
   ordenarPor("Horario");
  }
  function ordEstado(){
   ordenarPor("Estado");
  }
  function ordPais(){
   ordenarPor("Pais");
  }
  function ordDireccion(){
   ordenarPor("Direccion");
  }


</script>