package edu.uag.iidis.scec.modelo;

import java.io.Serializable;
import java.util.*;


/**
 * 
 *  
 *
 * <p><a href="Estado.java.html"><i>Ver código fuente</i></a></p>
 *
 * @author <a href="mailto:vramos@uag.mx">Victor Ramos</a>
 * @version 1.0
 */
public class Transporte extends ClaseBase 
        implements Serializable {

    private Long id;
    
    private int capacidad;
    private String tipo;
    
    public Transporte() {
    }

    public Transporte(int capacidad, String tipo) {
        this.capacidad = capacidad;
        this.tipo = tipo;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public Transporte(Long id){
        this.id = id;
    }

}