/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayed1obligatorio2016.Grafo;

import ayed1obligatorio2016.ListaDoble.ListaDobleEnc;
import ayed1obligatorio2016.ListaSimple.ListaSimpleGeneric;
import ayed2obligatorio2016.Sistema;
import clases.Servicio;

/**
 *
 * @author cristian castro
 */
public class NodoGrafo {

    private ListaSimpleGeneric<Servicio> Servicios;
    private String nombre;
    private ListaDobleEnc<Arista> Aristas;

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
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the Aristas
     */
    public ListaDobleEnc<Arista> getAristas() {
        return Aristas;
    }

    /**
     * @param Aristas the Aristas to set
     */
    public void setAristas(ListaDobleEnc<Arista> Aristas) {
        this.Aristas = Aristas;
    }

}