/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dijkstra;

import ayed2obligatorio2016.Grafo.NodoGrafo;

/**
 *
 * @author Kingdel
 */
public class NodoTablaPrecioMenor {
    private String Estacion;
    private boolean Conocido;
    private float Precio;
    private NodoGrafo EstacionA;
    
    public NodoTablaPrecioMenor(String pEstacion)
    {
        Estacion = pEstacion;
        Conocido = false;
        Precio = Integer.MAX_VALUE;
        EstacionA = null;
    }
    
    public NodoTablaPrecioMenor()
    {
        Estacion = "0";
        Conocido = false;
        Precio = Integer.MAX_VALUE;
        EstacionA = null;
    }

    /**
     * @return the Estacion
     */
    public String getEstacion() {
        return Estacion;
    }

    /**
     * @param Estacion the Estacion to set
     */
    public void setEstacion(String Estacion) {
        this.Estacion = Estacion;
    }

    /**
     * @return the Conocido
     */
    public boolean isConocido() {
        return Conocido;
    }

    /**
     * @param Conocido the Conocido to set
     */
    public void setConocido(boolean Conocido) {
        this.Conocido = Conocido;
    }

    /**
     * @return the Precio
     */
    public float getPrecio() {
        return Precio;
    }

    /**
     * @param Precio the Precio to set
     */
    public void setPrecio(float Precio) {
        this.Precio = Precio;
    }

    /**
     * @return the EstacionA
     */
    public NodoGrafo getEstacionA() {
        return EstacionA;
    }

    /**
     * @param EstacionA the EstacionA to set
     */
    public void setEstacionA(NodoGrafo EstacionA) {
        this.EstacionA = EstacionA;
    }
    
}
