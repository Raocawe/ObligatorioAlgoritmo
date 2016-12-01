/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayed2obligatorio2016.Grafo;

import Dijkstra.DijktraPorLinea;
import Dijkstra.TablaCaminoCorto;
import ayed2obligatorio2016.ArbolBinario.ArbolBinario;
import ayed2obligatorio2016.ArbolBinario.NodoBinario;
import ayed2obligatorio2016.Grafo.NodoGrafo;
import ayed2obligatorio2016.ListaSimple.NodoListaSimple;
import ayed2obligatorio2016.Sistema;
import static ayed2obligatorio2016.Sistema.getListaAristaOrdenadasNombre;
import clases.NodoListaConNombre;
import clases.Servicio;

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
    
    private void Recorrido_En_Orden(NodoBinario raiz)
    {
        if(raiz != null)
        {
            NodoListaConNombre a = (NodoListaConNombre)raiz.getElemento();

            Recorrido_En_Orden(raiz.getHijoIzquierdo());
            
            ImprimirLineas(a);
                    
            Recorrido_En_Orden(raiz.getHijoDerecho());
        }
    }
    
    public void ListadoAristas()
    {      
        ArbolBinario<NodoListaConNombre> a = getListaAristaOrdenadasNombre();
        NodoBinario s1 = (NodoBinario)a.getRaiz();
        if(s1==null)
        {
            System.out.println("No hay Líneas en el Metro");
            return;
        }
        Recorrido_En_Orden(s1); 
    } 
    
    public void ImprimirLineas(NodoListaConNombre pN)
    {
        int contador = 0;
        // <editor-fold defaultstate="collapsed" desc=" CargarContador ">
        String[] Estaciones = new String[20];
        NodoListaSimple s = pN.getListaArista().getInicio();
        while(s!=null)
        {
            Arista a = (Arista)s.getDato();
            if(!buscarString(Estaciones,a.getOrigen().getNombre()))
            {
                contador++;
            }
            if(!buscarString(Estaciones,a.getDestino().getNombre()))
            {
                contador++;
            }
            s = s.getSiguiente();
        }
        // </editor-fold >
        NodoGrafo[] array = new NodoGrafo[contador];
        // <editor-fold defaultstate="collapsed" desc=" CargarArray ">
        contador = 0;
        Estaciones = new String[20];
        s = pN.getListaArista().getInicio();
        while(s!=null)
        {
            Arista a = (Arista)s.getDato();
            if(!buscarString(Estaciones,a.getOrigen().getNombre()))
            {
                array[contador] = a.getOrigen();
            }
            if(!buscarString(Estaciones,a.getDestino().getNombre()))
            {
                array[contador] = a.getDestino();;
            }
            s = s.getSiguiente();
        }
        
        // </editor-fold>
        
        DijktraPorLinea d = new DijktraPorLinea();
        d.DijktraPorLineas(array);
        /////////////////////////////// <<<<<<<<<
    }
    
    private boolean buscarString(String[] array,String pNombre)
    {
        for(int i = 0; i <array.length;i++){
            if(array[i]==null)
            {
                return false;
            }
            if(array[i].equals(pNombre))
            {
                return true;
            }
        }
        return false;
    }
}
