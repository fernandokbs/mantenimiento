<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>

<style media="screen">
  div.card{
    margin: 50px;
  }
</style>

<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDrXf9CxNYGJnAoO1odTbpFBHYAONeIEKg&callback=initMap" async defer ></script>
  <script>
  var geocoder;
  var infowindow;
  var marker;
  window.onload = function () {
    var latLng = new google.maps.LatLng(16.7408929, -93.10159049999999);
    var opciones = {
      center: latLng,
      zoom: 5,
      mapTypeId: google.maps.MapTypeId.HYBRID
    };
    var map = new google.maps.Map(document.getElementById("mapa"), opciones);
    geocoder = new google.maps.Geocoder();
    infowindow = new google.maps.InfoWindow();
    google.maps.event.addListener(map, 'click', function (event) {
      geocoder.geocode({
        'latLng': event.latLng
      }, function (results, status) {
        if (status == google.maps.GeocoderStatus.OK) {
          if (results[0]) {
            document.getElementById('coordenadas').value =  results[0].geometry.location;
            var a = results[0].formatted_address.split(',');
            document.getElementById('estado').value =  a[1].trim();

            var valor = a[2];
            var xmlhttp=new XMLHttpRequest();
            var v = valor.replace("México","Mexico");
            xmlhttp.onreadystatechange=function(){
              if(xmlhttp.status==404){
              }
              if (xmlhttp.readyState==4 && xmlhttp.status==200){
                  var d = xmlhttp.responseText.trim().replace(/\s/g, ',');
                  var d1 = d.split(',');
                  //alert(d1[0] + ":"  +d1[5] + ":" + d1[10]);
                  document.getElementById('pais').value =  d1[0];
              }
            };
            xmlhttp.open("GET","Service.do?pais="+valor,true);
            xmlhttp.send();
            if (marker) {
              marker.setPosition(event.latLng);
            } else {
              marker = new google.maps.Marker({
                position: event.latLng,
                map: map
              })
            }
            infowindow.setContent(results[0].formatted_address + '<br/> Horario: ' + results[0].geometry.location);
            infowindow.open(map, marker);
          } else {
            document.getElementById('coordenadas').value = 'No se encontraron resultados';
          }
        } else {
          document.getElementById('coordenadas').value = 'Geocodificación  ha fallado debido a: ' + status;
        }
      });
    });
  }
</script>

<div class="center-align">
    <h1>
        <fmt:message key="formaNuevoTriplan.titulo" />
    </h1>
</div>

<div class="card horizontal">
  <div class="card-image">

<div id="mapa" style="height: 100%; width:40vw;"></div>

  </div>
  <div class="card-stacked">
  <div class="card-content">

    <form id="forma" action="procesarRegistroTriplan.do" method="post" enctype="multipart/form-data">


        <div class="input-field">
          <i class="material-icons prefix">view_headline</i>
          <input type="text"
                 name="nombre"

                 maxlength="100"
                 value="${formaNuevoTriplan.nombre}">
          <label for="icon_prefix">
            <fmt:message key="formaNuevoTriplan.etiqueta.nombre" />
          </label>
        </div>

        <div class="input-field">
          <i class="material-icons prefix">description</i>
          <input type="text"
                 name="descripcion"

                 maxlength="100"
                 value="${formaNuevoTriplan.descripcion}">
          <label for="icon_telephone">
            <fmt:message key="formaNuevoTriplan.etiqueta.descripcion" />
        </label>
        </div>

        <div class="input-field">
          <i class="material-icons prefix">credit_card</i>
          <input type="number" step='any'
                 name="poblacion"

                 maxlength="100"
                 value="${formaNuevoTriplan.poblacion}">
          <label for="icon_prefix">
            <fmt:message key="formaNuevoTriplan.etiqueta.poblacion" />
          </label>
        </div>

        <div class="input-field">
          <i class="material-icons prefix">today</i>
          <input type="text"
                 name="moneda"

                 maxlength="100"
                 value="${formaNuevoTriplan.moneda}">
          <label for="icon_telephone">
            <fmt:message key="formaNuevoTriplan.etiqueta.moneda" />
          </label>
        </div>

        <div class="input-field">
          <i class="material-icons prefix">my_location</i>
          <input type="text"
                id="estado"
                name="estado"

                 maxlength="100"
                 value="${formaNuevoTriplan.estado}">
          <label for="icon_prefix" class="active">
            <fmt:message key="formaNuevoTriplan.etiqueta.estado" />
          </label>
        </div>

        <div class="input-field">
          <i class="material-icons prefix">my_location</i>
          <input type="text"
                id="pais"
                name="pais"

                 maxlength="100"
                 value="${formaNuevoTriplan.pais}">
          <label for="icon_telephone" class="active">
            <fmt:message key="formaNuevoTriplan.etiqueta.pais" />
          </label>
        </div>

        <div class="input-field">
          <i class="material-icons prefix">my_location</i>
          <input type="text"
                name="coordenadas"
                id="coordenadas"
                 maxlength="100"
                 value="${formaNuevoTriplan.coordenadas}">
          <label for="icon_prefix" class="active">
            <fmt:message key="formaNuevoTriplan.etiqueta.coordenadas" />
          </label>
        </div>

        <div class="file-field input-field">
    <div class="btn">
    <span>
    <fmt:message key="formaNuevoTriplan.etiqueta.foto" />
    </span>
    <input type="file"
     name="imagen"
     value="${formaNuevoTriplan.imagen}">
    </div>
    <div class="file-path-wrapper">
    <input class="file-path validate" type="text">
    </div>
    </div>

    <input class="waves-effect waves-light btn" type="submit"
    name="submit"
    value="Agregar"/>


    </form>

  </div>
</div>
</div>
