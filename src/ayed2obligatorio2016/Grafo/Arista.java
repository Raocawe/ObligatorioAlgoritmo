/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayed2obligatorio2016.Grafo;

import Dijkstra.TablaCaminoCorto;
import ayed2obligatorio2016.ArbolBinario.ArbolBinario;
import ayed2obligatorio2016.ArbolBinario.NodoBinario;
import ayed2obligatorio2016.Grafo.NodoGrafo;
import ayed2obligatorio2016.ListaDoble.ListaDobleEnc;
import ayed2obligatorio2016.ListaDoble.NodoLista;
import ayed2obligatorio2016.ListaSimple.ListaSimpleGeneric;
import ayed2obligatorio2016.ListaSimple.NodoListaSimple;
import ayed2obligatorio2016.Sistema;
import static ayed2obligatorio2016.Sistema.getListaAristaOrdenadasNombre;
import static ayed2obligatorio2016.Sistema.getMetro;
import clases.CHashSolucionNodo;
import clases.Hash;
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
    
    private String[] Estaciones;
    private int[] EstacionesI ;
    private int NodoinicioRecorrido;
    
    private void bus(String p)
    {
        for(int i=0;i<Estaciones.length;i++)
        {
            if(Estaciones[i]==null)
            {
                Estaciones[i] = p;
                EstacionesI[i]=1;
                return;
            }
            if(Estaciones[i].equals(p))
            {
                EstacionesI[i]=EstacionesI[i]+1;
                return;
            }
        }
    }
    // </editor-fold>
    
    private void Recorrido_En_Orden(NodoBinario raiz)
    {
        if(raiz != null)
        {
            
            Recorrido_En_Orden(raiz.getHijoIzquierdo());
            
            NodoListaConNombre a = (NodoListaConNombre)raiz.getElemento();
            
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
    
    public void ImprimirLineas(NodoListaConNombre NlCn)
    {        
        Estaciones = new String[NlCn.getCantidadEnLista()];
        EstacionesI = new int[NlCn.getCantidadEnLista()];
        TablaCaminoCorto d = new TablaCaminoCorto(NlCn.getHashEstacionLinea(),NlCn.getNombre());
        NodoGrafo s = BuscarGrafoInicio(NlCn.getHashEstacionLinea(),NlCn.getNombre());
        d.DijktraLineas(s);
        
        System.out.println("Linea: "+NlCn.getNombre());
        System.out.println(s.getNombre());
        
        s = BuscarNodoFin(NlCn.getHashEstacionLinea());//Captura La estacion opuesta la estacion Inicio del Disjktra para imprimir luego(fin del recorrido de la linea)
        d.imprimir_Camino(s);
        System.out.println("\n");
    }
    
    private NodoGrafo BuscarGrafoInicio(Hash s,char nom)
    {
        NodoGrafo[] r = s.getArray();
        for(int i = 0;i<r.length;i++)
        {
            if(r[i]!=null){
                NodoLista q = (NodoLista)r[i].getAristas().getInicio();
                while(q!=null)
                {
                    Arista a = (Arista)q.getDato();
                    if(a.getNombre()==nom){
                        bus(a.getDestino().getNombre());
                        bus(a.getOrigen().getNombre());
                    }
                    q= q.getSiguiente();
                } 
            }
        }
        return BuscarNodoInicio(s);
    }
       
    private NodoGrafo BuscarNodoInicio(Hash  s)
    {
        int menor = EstacionesI[0];
        int indice = 0;
        for(int i = 1;i<EstacionesI.length;i++)
        {
            if(EstacionesI[i]<menor)
            {
                menor = EstacionesI[i];
                indice = i;
            }
        }
        NodoinicioRecorrido = indice;
        return s.BuscarHash(Estaciones[indice]);
    }
    
    private NodoGrafo BuscarNodoFin(Hash  s)
    {
        int menor = Integer.MAX_VALUE;
        int indice = 0;
        for(int i = 1;i<EstacionesI.length;i++)
        {
            if(i !=NodoinicioRecorrido){
                if(EstacionesI[i]<menor)
                {
                    menor = EstacionesI[i];
                    indice = i;
                }
            }
        }
        return s.BuscarHash(Estaciones[indice]);
    }
}
