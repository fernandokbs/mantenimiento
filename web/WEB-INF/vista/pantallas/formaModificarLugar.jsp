<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>

<style media="screen">
  div.card{
    margin: 50px;
  }
</style>


<h1>
  <fmt:message key="formaListadoLugares.titulo" />
</h1>


      <div class="card horizontal">
        <div class="card-image">
          <img style="height: 100%; width: 100%;" src="${formaModificarLugar.imagen}">
          <span class="card-title">${formaModificarLugar.nombre}</span>


        </div>
        <div class="card-stacked">
        <div class="card-content">


          <form id="forma" action="procesarModificarLugar.do" method="post" enctype="multipart/form-data">

              <div class="input-field">
                <i class="material-icons prefix">view_headline</i>
                <input type="text"
                       name="nombre"
                       maxlength="100"
                       value="${formaModificarLugar.nombre}">
                <label for="icon_prefix">
                  <fmt:message key="formaListadoLugares.etiqueta.nombre" />
                </label>
              </div>

              <div class="input-field">
                <i class="material-icons prefix">description</i>
                <input type="text"
                       name="descripcion"

                       maxlength="100"
                       value="${formaModificarLugar.descripcion}">
                <label for="icon_telephone">
                  <fmt:message key="formaListadoLugares.etiqueta.descripcion" />
              </label>
              </div>

              <div class="input-field">
                <i class="material-icons prefix">credit_card</i>
                <input type="text"
                       id="poblacion"
                       name="poblacion"
                       value="${formaModificarLugar.poblacion}">
                <label for="icon_prefix">
                  <fmt:message key="formaListadoLugares.etiqueta.poblacion" />
                </label>
              </div>

              <div class="input-field">
                <i class="material-icons prefix">today</i>
                <input type="text"
                       name="coordenadas"
                       maxlength="100"
                       value="${formaModificarLugar.coordenadas}">
                <label for="icon_telephone">
                  <fmt:message key="formaListadoLugares.etiqueta.coordenadas" />
                </label>
              </div>

              <div class="input-field">
                <i class="material-icons prefix">my_location</i>
                <input type="text"
                      id="estado"
                      name="estado"
                       maxlength="100"
                       value="${formaModificarLugar.estado}">
                <label for="icon_prefix" class="active">
                  <fmt:message key="formaListadoLugares.etiqueta.estado" />
                </label>
              </div>

              <div class="input-field">
                <i class="material-icons prefix">my_location</i>
                <input type="text"
                      id="pais"
                      name="pais"
                       maxlength="100"
                       value="${formaModificarLugar.pais}">
                <label for="icon_telephone" class="active">
                  <fmt:message key="formaListadoLugares.etiqueta.pais" />
                </label>
              </div>

              <div class="input-field">
                <i class="material-icons prefix">my_location</i>
                <input type="text"
                      name="moneda"
                      id="moneda"
                       maxlength="100"
                       value="${formaModificarLugar.moneda}">
                <label for="icon_prefix" class="active">
                  <fmt:message key="formaListadoLugares.etiqueta.direccion" />
                </label>
              </div>
              <input value="${formaModificarLugar.imagen}" name="imagen" />
                <input value="${formaModificarLugar.id}" name="id" style="display: none"/>

                <button class="btn waves-effect waves-light" type="submit" name="action">
                    Actualizar
                    <i class="material-icons right">send</i>
                </button>
          </form>
        </div>
      </div>
      </div>
