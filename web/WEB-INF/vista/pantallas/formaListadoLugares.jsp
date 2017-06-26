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
        <table class="bordered" id="lugar">

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
                
                <th data-field="nombre">
                    <a class="waves-effect" onclick="ordNombre('nombre');">
                        <fmt:message key="formaListadoLugares.etiqueta.nombre" />
                    </a>
                </th>
                <th data-field="descripcion">
                    <a class="waves-effect" onclick="ordDescripcion('descripcion');">
                        <fmt:message key="formaListadoLugares.etiqueta.descripcion" />
                    </a>
                </th>
                <th data-field="poblacion">
                    <a class="waves-effect" onclick="ordPoblacion('poblacion');">
                        <fmt:message key="formaListadoLugares.etiqueta.poblacion" />
                    </a>
                </th>
                <th data-field="coordenadas">
                    <a class="waves-effect" onclick="ordCoordenadas('coordenadas');">
                        <fmt:message key="formaListadoLugares.etiqueta.coordenadas" />
                    </a>
                </th>
                <th data-field="estado">
                    <a class="waves-effect" onclick="ordEstado('estado');">
                        <fmt:message key="formaListadoLugares.etiqueta.estado" />
                    </a>
                </th>
                <th data-field="pais">
                    <a class="waves-effect" onclick="ordPais('pais');">
                        <fmt:message key="formaListadoLugares.etiqueta.pais" />
                    </a>
                </th>
                <th data-field="moneda">
                    <a class="waves-effect" onclick="ordMoneda('moneda');">
                        <fmt:message key="formaListadoLugares.etiqueta.moneda" />
                    </a>
                </th>
                <th data-field="administracion">
                    <fmt:message key="formaListadoLugares.etiqueta.administracion" />
                </th>
            </tr>
            
            <tbody>
                
            </tbody>
            
            <c:forEach var="lugar" items="${formaListadoLugares.lugares}">
                    
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
<script type="text/javascript">
    $(document).ready(function(){
         // the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered
        $('.modal').modal();
    });
    
    function ordenarPor( attribute ) {
    var xmlhttp=new XMLHttpRequest();

    xmlhttp.onreadystatechange = function() {
      if(xmlhttp.status==404){
          document.getElementById("lugar").innerHTML="Page not found";
      }
      if (xmlhttp.readyState==4 && xmlhttp.status==200){
          console.log("Entro");
          console.log(xmlhttp.responseText);
          document.getElementById("lugar").innerHTML=xmlhttp.responseText;
      }
    };

    xmlhttp.open("GET","ordenarLugaresPor.do?nombre=" + attribute , true );
    xmlhttp.send();

    $(document).ready(function(){
      // the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered
      $('.modal').modal();
    });
  }
  
  function ordNombre(){
    ordenarPor("Nombre");
  }
  function ordDescripcion(){
   ordenarPor("Descripcion");
  }
  function ordPoblacion(){
   ordenarPor("Poblacion");
  }
  function ordCoordenadas(){
   ordenarPor("Coordenadas");
  }
  function ordEstado(){
   ordenarPor("Estado");
  }
  function ordPais(){
   ordenarPor("Pais");
  }
  function ordMoneda(){
   ordenarPor("Moneda");
  }
  
</script>