/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayed2obligatorio2016.Grafo;

import ayed2obligatorio2016.ArbolBinario.ArbolBinario;
import ayed2obligatorio2016.ListaSimple.ListaSimpleGeneric;
import ayed2obligatorio2016.Sistema;
import clases.Servicio;

/**
 *
 * @author cristian castro
 */
public class NodoGrafo <E extends Comparable<E>>{

    private ArbolBinario<Servicio> Servicios;
    private String nombre;
    private ListaSimpleGeneric<Arista> Aristas;
    private Enumerado estado;
    

    public NodoGrafo()
    {
        Servicios = new ArbolBinario<Servicio>();
        nombre = "";
        Aristas = new ListaSimpleGeneric<Arista>();
        estado = Enumerado.V;
    }
    /**
     * @return the Servicios
     */
    public ArbolBinario<Servicio> getServicios() {
        return Servicios;
    }

    /**
     * @param Servicios the Servicios to set
     */
    public void setServicios(ArbolBinario<Servicio> Servicios) {
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
    public ListaSimpleGeneric<Arista> getAristas() {
        return Aristas;
    }

    /**
     * @param Aristas the Aristas to set
     */
    public void setAristas(ListaSimpleGeneric<Arista> Aristas) {
        this.Aristas = Aristas;
    }

    /**
     * @return the estado
     */
    public Enumerado getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(Enumerado estado) {
        this.estado = estado;
    }

    
}