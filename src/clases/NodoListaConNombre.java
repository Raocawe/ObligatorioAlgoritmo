/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import ayed2obligatorio2016.ArbolBinario.NodoBinario;
import ayed2obligatorio2016.Grafo.Arista;
import ayed2obligatorio2016.ListaSimple.ListaSimpleGeneric;
import static ayed2obligatorio2016.Sistema.getListaAristaOrdenadasNombre;

/**
 *
 * @author cristian castro
 */
public class NodoListaConNombre implements Comparable<NodoListaConNombre>{
    
    private char nombre;
    private ListaSimpleGeneric<Arista> ListaArista;
    private int CantidadEnLista;

    public NodoListaConNombre()
    {   
        ListaArista = new ListaSimpleGeneric<Arista>();
        CantidadEnLista = 0;
    }
    
    public int compareTo(NodoListaConNombre o) {
        
        int a = CharAint(this.getNombre());
        int b = CharAint(o.getNombre());
        
        if(a>b)
            return 1;
        else if(a < b)
            return -1;
        else
            return 0;
        
    }
    
    public int CharAint(char pC)
    {
        return (int)pC;
    }

    /*public NodoListaConNombre buscar(NodoListaConNombre pI)
    {
        NodoListaConNombre aux = (NodoListaConNombre)getListaAristaOrdenadasNombre().getRaiz();
        if(aux!=null){
            
            if(aux.getNombre()==pI.getNombre())
            {
                return pI;
            }
            else
            {
                NodoBinario n = new NodoBinario(dato);
                NodoBinario r = (NodoBinario)getRaiz();
                return Buscar(n, r);
            }
            
        }
        if(aux.getNombre()==pI.getNombre())
        {
            return pI;
        }
        return null;
        
         if(dato !=null)
        {
            if(raiz!=null){
                if(this.getRaiz().equals(dato))
                {
                    return getRaiz();
                }
                else{
                    NodoBinario n = new NodoBinario(dato);
                    NodoBinario r = (NodoBinario)getRaiz();
                    return Buscar(n, r);
                }
            }
            else
            {return null;}
        }
        else
        {return null;}
    }
    
    private NodoListaConNombre Buscar(NodoBinario buscado, NodoBinario recorrido)
    {
        Arista s = new Arista();
        if(recorrido == null){
            return null;
        }  
        buscado.getElemento();
        else if(buscado.getNombre()==recorrido.getNombre()){
            return recorrido;
        }
        else
        {
            if(CharAint(buscado.nombre)<CharAint(recorrido.nombre)) 
            {
                return Buscar(buscado, recorrido.getHijoDerecho());
            }
            else 
                return Buscar(buscado, recorrido.getHijoIzquierdo());
        }
    }
    */
    
    public char getNombre() {
        return nombre;
    }
    public void setNombre(char nombre) {
        this.nombre = nombre;
    }
    public ListaSimpleGeneric<Arista> getListaArista() {
        return ListaArista;
    }
    public void setListaArista(ListaSimpleGeneric<Arista> ListaArista) {
        this.ListaArista = ListaArista;
    }
    public int getCantidadEnLista() {
        return CantidadEnLista;
    }
    public void setCantidadEnLista(int CantidadEnLista) {
        this.CantidadEnLista = CantidadEnLista;
    }
    
}
