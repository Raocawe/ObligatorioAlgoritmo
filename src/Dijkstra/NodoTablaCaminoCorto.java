/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dijkstra;

/**
 *
 * @author cristian castro
 */
public class NodoTablaCaminoCorto {
    private String Estacion;
    private byte Conocido;
    private float Distancia;
    private String EstacionA;
    
    public NodoTablaCaminoCorto(String pEstacion)
    {
        Estacion = pEstacion;
        Conocido = 0;
        Distancia = -1;
        EstacionA = "0";
    }
    
    public NodoTablaCaminoCorto()
    {
        Estacion = "0";
        Conocido = 0;
        Distancia = -1;
        EstacionA = "0";
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
    public byte getConocido() {
        return Conocido;
    }

    /**
     * @param Conocido the Conocido to set
     */
    public void setConocido(byte Conocido) {
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
    public String getEstacionA() {
        return EstacionA;
    }

    /**
     * @param EstacionA the EstacionA to set
     */
    public void setEstacionA(String EstacionA) {
        this.EstacionA = EstacionA;
    }
}
