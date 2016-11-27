/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayed2obligatorio2016.Grafo;

import ayed2obligatorio2016.ArbolBinario.NodoBinario;
import ayed2obligatorio2016.Grafo.NodoGrafo;
import ayed2obligatorio2016.ListaSimple.NodoListaSimple;
import ayed2obligatorio2016.Sistema;

/**
 *
 * @author cristian castro
 */
public class Arista implements Comparable<Arista>{
    
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
    
   /* public Arista buscarArista(Arista pA)
    {
        NodoBinario e = new NodoBinario();
        e.setElemento(pA);
        NodoBinario nls = (NodoBinario)Sistema.getListaAristaOrdenadasNombre().Buscar(e);

        if(nls!=null)
        {
            Arista a = (Arista)nls.getElemento();
            if(a.destino.equals(pA.destino)&&a.origen.equals(pA.origen))
            {
                return a;
            }
            else
            {
                while(nls.!=null)
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
    }*/

    public int CharAInt(char pC)
    {
        return (int)pC;
    }
    
    public int compareTo(Arista o) {
        int a = CharAInt(this.nombre);
        int b = CharAInt(o.nombre);
        
        if(a>b)
            return 1;
        else if(a < b)
            return -1;
        else
            return 0; 
    }
    
}
