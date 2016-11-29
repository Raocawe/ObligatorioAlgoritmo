/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dijkstra;

import ayed2obligatorio2016.Grafo.NodoGrafo;

/**
 *
 * @author cristian castro
 */
public class NodoTablaCaminoCorto {
    private String Estacion;
    private boolean Conocido;
    private float Distancia;
    private NodoGrafo EstacionA;
    
    public NodoTablaCaminoCorto(String pEstacion)
    {
        Estacion = pEstacion;
        Conocido = false;
        Distancia = -1;
        EstacionA = null;
    }
    
    public NodoTablaCaminoCorto()
    {
        Estacion = "0";
        Conocido = false;
        Distancia = -1;
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
    public boolean getConocido() {
        return Conocido;
    }

    /**
     * @param Conocido the Conocido to set
     */
    public void setConocido(boolean Conocido) {
        this.Conocido = Conocido;
    }

    /**
     * @return the Distancia
     */
    public float getDistancia() {
        return Distancia;
    }

    /**
     * @param Distancia the Distancia to set
     */
    public void setDistancia(float Distancia) {
        this.Distancia = Distancia;
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
