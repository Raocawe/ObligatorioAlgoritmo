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
import static ayed2obligatorio2016.Sistema.getMetro;
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
    // <editor-fold defaultstate="collapsed" desc=" Metodos ">
    private String[] NombreEstaciones = new String[20];
    private int[] RepeticionPorEstacion = new int[20];
    
    public int CharAInt(char pC)
    {
        return (int)pC;
    }
    
    private boolean buscarString(String pNombre)
    {
        BuscarNodoPrincipalDisktra(pNombre);
        for (int i = 0;i<Estaciones.length;i++) {
            if (Estaciones[i] == null) {
                Estaciones[i] = pNombre;
                return false;
            }
            if(Estaciones[i].equals(pNombre))
                return true;
        }
        return false;
    }
    
    private void  BuscarNodoPrincipalDisktra(String p)
    {
        for (int i = 0;i<NombreEstaciones.length;i++) {
            if (NombreEstaciones[i] == null) {
                NombreEstaciones[i] = p;
                RepeticionPorEstacion[i]=0;
                return;
            }
            if(NombreEstaciones[i].equals(p))
            {
                RepeticionPorEstacion[i]=RepeticionPorEstacion[i]++;
                return;
            }
        }
    }
    
    private NodoGrafo NodoPrincipal()
    {
        Grafo ch = getMetro();
        int menor = 0;
        for(int x : RepeticionPorEstacion)
        {
            if(x<menor)
            {
                menor = x;
            }
        }
        return ch.getTablaEstaciones().BuscarHash(NombreEstaciones[menor]);
    }
    
    private NodoGrafo[] DescartarNull(NodoGrafo[] pNG , NodoGrafo[] retorno)
    {
        for(int i=0;i<retorno.length;i++){
            retorno[i]=pNG[i];
        }      
        return retorno;
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
    // </editor-fold>
    
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
    
    public String[] Estaciones = new String[100];
    
    public void ImprimirLineas(NodoListaConNombre pN)
    {
        
        NodoGrafo[] array = new NodoGrafo[20];
        // <editor-fold defaultstate="collapsed" desc=" CargarArray ">
        int contador = 0;
        NodoListaSimple s = pN.getListaArista().getInicio();
        while(s!=null)
        {
            Arista a = (Arista)s.getDato();
            if(!buscarString(a.getOrigen().getNombre()))
            {
                array[contador] = a.getOrigen();
                contador++;
            }
            if(!buscarString(a.getDestino().getNombre()))
            {
                array[contador] = a.getDestino();
                contador++;
            }
            s = s.getSiguiente();
        }
        NodoGrafo[] arraySoloEstaciones = new NodoGrafo[contador];
        // </editor-fold>
        arraySoloEstaciones = DescartarNull(array, arraySoloEstaciones);
        
        DijktraPorLinea d = new DijktraPorLinea();
        d.DijktraPorLineas(arraySoloEstaciones,NodoPrincipal());
        
        d.imprimir_Camino_PrimeraParte();
    }
    
    
}
