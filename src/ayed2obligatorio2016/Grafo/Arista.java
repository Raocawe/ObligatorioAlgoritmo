/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayed2obligatorio2016.Grafo;

import ayed2obligatorio2016.Grafo.NodoGrafo;
import ayed2obligatorio2016.ListaSimple.NodoListaSimple;
import ayed2obligatorio2016.Sistema;

/**
 *
 * @author cristian castro
 */
public class Arista {
    
    private NodoGrafo origen;
    private NodoGrafo destino;
    private char nombre;
    private float distancia;
    private float tarifa;

    // <editor-fold defaultstate="collapsed" desc=" GetSet ">
    /**
     * @return the origen
     */
    public NodoGrafo getOrigen() {
        return origen;
    }

    /**
     * @param origen the origen to set
     */
    public void setOrigen(NodoGrafo origen) {
        this.origen = origen;
    }

    /**
     * @return the destino
     */
    public NodoGrafo getDestino() {
        return destino;
    }

    /**
     * @param destino the destino to set
     */
    public void setDestino(NodoGrafo destino) {
        this.destino = destino;
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

    /**
     * @return the distancia
     */
    public float getDistancia() {
        return distancia;
    }

    /**
     * @param distancia the distancia to set
     */
    public void setDistancia(float distancia) {
        this.distancia = distancia;
    }

    /**
     * @return the tarifa
     */
    public float getTarifa() {
        return tarifa;
    }

    /**
     * @param tarifa the tarifa to set
     */
    public void setTarifa(float tarifa) {
        this.tarifa = tarifa;
    }
    
    // </editor-fold>
    
    public Arista buscarArista(Arista pA)
    {
        NodoListaSimple nls = Sistema.getListaArista().getInicio();

        if(nls!=null)
        {
            Arista a = (Arista)nls.getDato();
            if(a.destino.equals(pA.destino)&&a.origen.equals(pA.origen))
            {
                return a;
            }
            else
            {
                while(nls.getSiguiente()!=null)
                {
                   a =  (Arista)nls.getSiguiente().getDato();
                   if(a.destino.equals(pA.destino)&&a.origen.equals(pA.origen))
                   {
                       return a;
                   }
                   nls =  nls.getSiguiente(); 
                }
                return null;
            }
        }
        else
        {
            return null;
        }
    }
    
}
