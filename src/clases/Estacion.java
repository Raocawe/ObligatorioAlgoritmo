/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import ayed1obligatorio2016.ListaSimple.ListaSimpleGeneric;

/**
 *
 * @author cristian castro
 */
public class Estacion {
    
    private ListaSimpleGeneric<Servicio> Servicios;
    private char nombre;

    /**
     * @return the Servicios
     */
    public ListaSimpleGeneric<Servicio> getServicios() {
        return Servicios;
    }

    /**
     * @param Servicios the Servicios to set
     */
    public void setServicios(ListaSimpleGeneric<Servicio> Servicios) {
        this.Servicios = Servicios;
    }

    /**
     * @return the nombre
     */
    public char getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(char nombre) {
        this.nombre = nombre;
    }
    
}
