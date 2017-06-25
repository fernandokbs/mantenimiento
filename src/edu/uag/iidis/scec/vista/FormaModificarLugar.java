/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uag.iidis.scec.vista;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

/**
 *
 * @author Fernando
 */
public class FormaModificarLugar extends ValidatorForm{
    private Long id;
    private String nombre;
    private String descripcion;
    private Long poblacion;
    private String coordenadas;
    private String estado;
    private String imagen;
    private String pais;
    private String moneda;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(Long poblacion) {
        this.poblacion = poblacion;
    }

    public String getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(String coordenadas) {
        this.coordenadas = coordenadas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }
    
    public ActionErrors validate(ActionMapping mapping,
                                 HttpServletRequest request) {
        // Ejecuta las validaciones proporcionadas por Struts-Validator
        ActionErrors errores = super.validate(mapping, request);
        // Validaciones no cubiertas por Struts-Validator
        return errores;
    }
    
    @Override
    public String toString() {
        return "FormaModificarHotel{" + "id=" + id + ", nombre=" + nombre +
                    ", descripcion=" + descripcion + ", precio="  +
                    ", poblacion=" + poblacion  + ", estado=" + estado +
                    ", pais=" + pais + ", direccion="  + ", estados=" +
                    ", imagen=" + imagen +
                '}';
    }
}
