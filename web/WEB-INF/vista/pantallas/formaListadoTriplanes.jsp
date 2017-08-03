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
    <h1><fmt:message key="formaListadoTriplanes.titulo" /></h1>
</div>

<div class="
     ">
    <div class="container">
        <table class="bordered" id="triplan">

            <div class="fixed-action-btn">
                <a href="solicitarRegistroTriplan.do" class="btn-floating btn-large waves-effect waves-light red" >
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
                        <fmt:message key="formaListadoTriplanes.etiqueta.nombre" />
                    </a>
                </th>
                <th data-field="descripcion">
                    <a class="waves-effect" onclick="ordDescripcion('descripcion');">
                        <fmt:message key="formaListadoTriplanes.etiqueta.descripcion" />
                    </a>
                </th>
                <th data-field="poblacion">
                    <a class="waves-effect" onclick="ordPoblacion('poblacion');">
                        <fmt:message key="formaListadoTriplanes.etiqueta.poblacion" />
                    </a>
                </th>
                <th data-field="coordenadas">
                    <a class="waves-effect" onclick="ordCoordenadas('coordenadas');">
                        <fmt:message key="formaListadoTriplanes.etiqueta.coordenadas" />
                    </a>
                </th>
                <th data-field="estado">
                    <a class="waves-effect" onclick="ordEstado('estado');">
                        <fmt:message key="formaListadoTriplanes.etiqueta.estado" />
                    </a>
                </th>
                <th data-field="pais">
                    <a class="waves-effect" onclick="ordPais('pais');">
                        <fmt:message key="formaListadoTriplanes.etiqueta.pais" />
                    </a>
                </th>
                <th data-field="moneda">
                    <a class="waves-effect" onclick="ordMoneda('moneda');">
                        <fmt:message key="formaListadoTriplanes.etiqueta.moneda" />
                    </a>
                </th>
                <th data-field="administracion">
                    <fmt:message key="formaListadoTriplanes.etiqueta.administracion" />
                </th>
            </tr>
            
            <tbody>
                
            </tbody>
            
            <c:forEach var="triplan" items="${formaListadoTriplanes.triplanes}">
                    
                    <td align="left" width="20%"><c:out value="${triplan.nombre}"/></td>
                    <td align="left" width="60%"><c:out value="${triplan.descripcion}"/></td>
                    <td align="left" width="60%"><c:out value="${triplan.poblacion}"/></td>
                    <td align="left" width="60%"><c:out value="${triplan.coordenadas}"/></td>
                    <td align="left" width="60%"><c:out value="${triplan.estado}"/></td>
                    <td align="left" width="60%"><c:out value="${triplan.pais}"/></td>
                    <td align="left" width="60%"><c:out value="${triplan.moneda}"/></td>

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
                                <fmt:message key="formaListadoTriplanes.etiqueta.modificar" />
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
                <div>
                    <p>Total: ${formaListadoTriplanes.contador}</p>
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
          document.getElementById("triplan").innerHTML="Page not found";
      }
      if (xmlhttp.readyState==4 && xmlhttp.status==200){
          console.log("Entro");
          console.log(xmlhttp.responseText);
          document.getElementById("triplan").innerHTML=xmlhttp.responseText;
      }
    };

    xmlhttp.open("GET","ordenarTriplanesPor.do?nombre=" + attribute , true );
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
